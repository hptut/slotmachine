/**
 * PROGRAM PURPOSE: Class that creates object for SlotMachine instance.
 * Changes made by:
 * Name: Cece Schweighardt, Rachel Costello, Hayden Franklin, Haley Rogers, Hayden Tuttle
 * Date: 4/15/2022
 * Section: CSC 331-001
 */
package application;
//comment
import javafx.scene.image.Image;

import java.math.BigDecimal;

public class CreateSlotInstance {
    private Image display1;
    private Image display2;
    private Image display3;
    private BigDecimal bet;
    //constructor for CreateSlotInstance takes in dispaly1, diplay2, display3, and bet.
    public CreateSlotInstance(Image display1, Image display2, Image display3, BigDecimal bet) {
        this.display1 = display1;
        this.display2 = display2;
        this.display3 = display3;
        this.bet = bet;
    }
    //Mutator for display1, takes in display1 and returns nothing.
    public void setDisplay1(Image display1) {
        this.display1 = display1;
    }
    //Mutator for display2, takes in display2 and returns nothing.
    public void setDisplay2(Image display2) {
        this.display2 = display2;
    }
    //Mutator for display3, takes in display3 and returns nothing.
    public void setDisplay3(Image display3) {
        this.display3 = display3;
    }
    //Mutator for bet, takes in bet and returns nothing.
    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }


    //Accessor for display1, returns display1.
    public Image getDisplay1() {
        return this.display1;
    }
    //Accessor for display2, returns display2.
    public Image getDisplay2() {
        return this.display2;
    }
    //Accessor for display3, returns display3.
    public Image getDisplay3() {
        return this.display3;
    }
    //Accessor for bet, returns bet.
    public BigDecimal getBet() {
        return this.bet;
    }


    //Other Methods
    //Method for calcualting bet result.
    public BigDecimal betResult(){
        //if three displays equal eachother return a bet multiplied by three. Returns new bet value.
        if (getDisplay1() == getDisplay2() &&  getDisplay2() == getDisplay3()) {
            setBet(getBet().multiply(BigDecimal.valueOf(3)));
            return getBet();

        }
        //if only two displays equal eachother return a bet multiplied by two. Returns new bet value.
        else if (getDisplay1() == getDisplay2() || getDisplay1() == getDisplay3() || getDisplay2() == getDisplay3()) {
            setBet(getBet().multiply(BigDecimal.valueOf(2)));
            return getBet();
        }
        //if non of the displays equal eachother return a value of zero.
        else {
            return BigDecimal.valueOf(0);

        }


    }
    //Method for solving display result.
    public String displayResult() {
        //if only two displays equal eachother return the String "Triple".
        if (getDisplay1() == getDisplay2() &&  getDisplay2() == getDisplay3()) {
            return "Triple";

        }
        //if only two displays equal eachother return the String "Double".
        else if (getDisplay1() == getDisplay2() || getDisplay1() == getDisplay3() || getDisplay2() == getDisplay3()) {
            return "Double";
        }
        //if non of the displays equal eachother return the String "Better Luck Next Time!".
        else {
            return "Better Luck Next Time!";


        }
    }





}
