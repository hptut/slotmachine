/**
 * PROGRAM PURPOSE: Class that creates object for SlotMachine instance.
 * Changes made by:
 * Name: Cece Schweighardt, Rachel Costello, Hayden Franklin, Haley Rogers, Hayden Tuttle
 * Date: 4/15/2022
 * Section: CSC 331-001
 */
package application;

import javafx.scene.image.Image;

import java.math.BigDecimal;

public class CreateSlotInstance {
    private Image display1;
    private Image display2;
    private Image display3;
    private BigDecimal bet;

    public CreateSlotInstance(Image display1, Image display2, Image display3, BigDecimal bet) {
        this.display1 = display1;
        this.display2 = display2;
        this.display3 = display3;
        this.bet = bet;
    }
    //Mutators
    public void setDisplay1(Image display1) {
        this.display1 = display1;
    }
    public void setDisplay2(Image display2) {
        this.display2 = display2;
    }
    public void setDisplay3(Image display3) {
        this.display3 = display3;
    }
    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }


    //Accessors
    public Image getDisplay1() {
        return this.display1;
    }
    public Image getDisplay2() {
        return this.display2;
    }
    public Image getDisplay3() {
        return this.display3;
    }
    public BigDecimal getBet() {
        return this.bet;
    }


    //Other Methods
    public BigDecimal betResult(){
        if (getDisplay1() == getDisplay2() &&  getDisplay2() == getDisplay3()) {
            setBet(getBet().multiply(BigDecimal.valueOf(3)));
            return getBet();

        }
        else if (getDisplay1() == getDisplay2() || getDisplay1() == getDisplay3() || getDisplay2() == getDisplay3()) {
            setBet(getBet().multiply(BigDecimal.valueOf(2)));
            return getBet();
        }
        else {
            return BigDecimal.valueOf(0);

        }


    }

    public String displayResult() {
        if (getDisplay1() == getDisplay2() &&  getDisplay2() == getDisplay3()) {
            return "Triple";

        }
        else if (getDisplay1() == getDisplay2() || getDisplay1() == getDisplay3() || getDisplay2() == getDisplay3()) {
            return "Double";
        }
        else {
            return "Better Luck Next Time!";


        }
    }





}
