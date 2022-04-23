/**
 * PROGRAM PURPOSE: Controller class for SlotMachine.
 * Name: Cece Schweighardt, Rachel Costello, Hayden Franklin, Haley Rogers, Hayden Tuttle
 * Date: 4/24/2022
 * Section: CSC 331-001
 */

package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Objects;

import javax.imageio.ImageIO;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class SlotMachineController {
	
	//helper objects
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance(); //number formatting 
    
    //image variables
    static Image[] imageTable;
	private static final String[] toLoad = {"/resources/cherries.png","/resources/seven.png","/resources/bell.png","/resources/bar.png","/resources/lemon.png","/resources/orange.png"};

	//payout variables 
	private static PayoutTable pTable;
	private static final int playCost = 5;
	private static final int[] pointsTable = {5,15,8,10,9,11};
	private static final int doubleMult = 1;
	private static final int tripleMult = 5;
	
	//slot wheel objects
	private static SlotWheel slot1;
	private static SlotWheel slot2;
	private static SlotWheel slot3;

    //Objects from JavaFX Layout

    @FXML
    private TextField currencyTextField;

    @FXML
    private ImageView firstSlotImageView;
    
    @FXML
    private ImageView fundsButton;

    @FXML
    private TextField resultTextField;

    @FXML
    private ImageView secondSlotImageView;

    @FXML
    private ImageView thirdSlotImageView;

    @FXML
    private ImageView spinButton;

    //Functions Triggered by JavaFX Layout

    @FXML
    public void fundsButtonPressed() {		//method adds funds of 5 to currencyTextField
        String balance = currencyTextField.getText().replace("$","");//replacement allows use of currencyTextField as Big Decimal.
        balance = balance.replace(",",""); //replacement allows use of currencyTextField as Big Decimal.
        BigDecimal amount = new BigDecimal(balance);
        currencyTextField.setText(currency.format(amount.add(BigDecimal.valueOf(5))));
    }

    @FXML
    public void spinButtonPressed() {		//method for when user presses roll 
        try {

            String balance = currencyTextField.getText().replace("$","");//replacement allows use of currencyTextField as Big Decimal.
            balance = balance.replace(",",""); //replacement allows use of currencyTextField as Big Decimal.
            BigDecimal amount = new BigDecimal(balance);
            
           //check to see if there is enough currency to pay for roll
            
            //remove play cost from credits
            amount = amount.subtract(BigDecimal.valueOf(playCost));

           //roll the slot objects
           slot1.roll();
           slot2.roll();
           slot3.roll();

            
            currencyTextField.setText(currency.format(amount));

            BigDecimal profits = new BigDecimal(String.valueOf(pTable.calculatePayout(slot1.getCurrentPosition(), slot2.getCurrentPosition(), slot3.getCurrentPosition())));
            amount = amount.add(profits);
            currencyTextField.setText(currency.format(amount));

            resultTextField.setText(pTable.lastPayoutMessage());
        }
        catch(NumberFormatException ex){
            System.out.print("NumberFormatException");
        }
    }
    public void initialize() {		//initialize method for loading images and calling PayoutTable and SlotWheel class
        
        //load images
        imageTable = new Image[toLoad.length];
		for(int i=0; i<imageTable.length; i++) {
			imageTable[i] = new Image(Objects.requireNonNull(getClass().getResourceAsStream(toLoad[i])));
		}
		
		//create and populate payout Table
		pTable = new PayoutTable(pointsTable, doubleMult, tripleMult);
		
		//create slot wheel objects
		slot1 = new SlotWheel(imageTable, firstSlotImageView);
        slot2 = new SlotWheel(imageTable, secondSlotImageView);
        slot3 = new SlotWheel(imageTable, thirdSlotImageView);
    }

}
