/**
 * PROGRAM PURPOSE: Controller class for SlotMachine.
 * Changes made by:
 * Name: Cece Schweighardt, Rachel Costello, Hayden Franklin, Haley Rogers, Hayden Tuttle
 * Date: 4/15/2022
 * Section: CSC 331-001
 */

package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Objects;

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
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    private BigDecimal betText = new BigDecimal(500);

    @FXML
    private Label betLabel;

    @FXML
    private TextField currencyTextField;

    @FXML
    private ImageView firstSlotImageView;

    @FXML
    private TextField resultTextField;

    @FXML
    private Slider betSlider;

    @FXML
    private ImageView secondSlotImageView;

    @FXML
    private ImageView thirdSlotImageView;

    @FXML
    //Method for if Add Funds button is pressed. Adds a value of 1000 to currency.
    public void fundsButtonPressed(ActionEvent event) {
        String balance = currencyTextField.getText().replace("$","");//replacement allows use of currencyTextField as Big Decimal.
        balance = balance.replace(",",""); //replacement allows use of currencyTextField as Big Decimal.
        BigDecimal amount = new BigDecimal(balance);
        amount = amount.add(BigDecimal.valueOf(1000)); //Adds 1000 to currency
        currencyTextField.setText(currency.format(amount));
        betSlider.setMax(amount.intValue()); //Sets betSlider max to new int value of currency.
    }

    @FXML
    //Method for if Spin button is pressed. Finds three random images and displays results.
    public void spinButtonPressed(ActionEvent event) {
        try {

            String balance = currencyTextField.getText().replace("$","");
            balance = balance.replace(",","");
            BigDecimal amount = new BigDecimal(balance);
            BigDecimal bet = (betText);

            //creates six new images for random display results.
            Image Cherries = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Cherries.jpg")));
            Image Seven = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/7.jpg")));
            Image Bells = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Bells.jpg")));
            Image Bar = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Bar.jpg")));
            Image Strawberry = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Strawberry.png")));
            Image Orange = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Orange.jpg")));

            //creates array of six images.
            Image[] imageArray = {Cherries,Seven,Bells,Bar,Strawberry,Orange};

            //finds three random numbers in the range of 0-5.
            int randNum1 = (int) (6 * Math.random());
            int randNum2 = (int) (6 * Math.random());
            int randNum3 = (int) (6 * Math.random());

            //finds three random images from Image Array.
            firstSlotImageView.setImage(imageArray[randNum1]);
            secondSlotImageView.setImage(imageArray[randNum2]);
            thirdSlotImageView.setImage(imageArray[randNum3]);

            
            amount = amount.subtract(bet);
            currencyTextField.setText(currency.format(amount));

            //calls class CreateSlotInstance and creates object instance.
            CreateSlotInstance instance = new CreateSlotInstance(firstSlotImageView.getImage(),secondSlotImageView.getImage(),thirdSlotImageView.getImage(),bet);

            //find profits through betResults in instance object.
            BigDecimal profits = instance.betResult();
            amount = amount.add(profits);
            currencyTextField.setText(currency.format(amount));

            //find results based on displayResult from object instance.
            resultTextField.setText(instance.displayResult());

            betSlider.setMax(amount.intValue()); //Sets betSlider max to new int value of currency.
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    //initialize method for listener between betSlider and betLabel.
    public void initialize() {
        currency.setRoundingMode(RoundingMode.HALF_UP);
        
        betSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                betText = BigDecimal.valueOf(newValue.intValue());
                betLabel.setText(String.valueOf(betText));
            }
        }
        );
    }

}
