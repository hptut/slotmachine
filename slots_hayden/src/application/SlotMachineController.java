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
    public void fundsButtonPressed(ActionEvent event) {
        BigDecimal amount = new BigDecimal(currencyTextField.getText());
        currencyTextField.setText(String.valueOf(amount.add(BigDecimal.valueOf(1000))));
        amount = new BigDecimal(currencyTextField.getText());
        betSlider.setMax(amount.intValue());
    }

    @FXML
    public void spinButtonPressed(ActionEvent event) {
        try {

            BigDecimal amount = new BigDecimal(currencyTextField.getText());
            BigDecimal bet = new BigDecimal(String.valueOf(betText));


            Image Cherries = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Cherries.jpg")));
            Image Seven = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/7.jpg")));
            Image Bells = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Bells.jpg")));
            Image Bar = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Bar.jpg")));
            Image Strawberry = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Strawberry.png")));
            Image Orange = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/Orange.jpg")));

            Image[] imageArray = {Cherries,Seven,Bells,Bar,Strawberry,Orange};

            int randNum1 = (int) (6 * Math.random());
            int randNum2 = (int) (6 * Math.random());
            int randNum3 = (int) (6 * Math.random());

            firstSlotImageView.setImage(imageArray[randNum1]);
            secondSlotImageView.setImage(imageArray[randNum2]);
            thirdSlotImageView.setImage(imageArray[randNum3]);

            bet = new BigDecimal(String.valueOf(betText));
            amount = amount.subtract(bet);
            currencyTextField.setText(String.valueOf(amount));

            CreateSlotInstance instance = new CreateSlotInstance(firstSlotImageView.getImage(),secondSlotImageView.getImage(),thirdSlotImageView.getImage(),bet);

            BigDecimal profits = new BigDecimal(String.valueOf(instance.betResult()));
            amount = amount.add(profits);
            currencyTextField.setText(String.valueOf(amount));

            resultTextField.setText(instance.displayResult());

            betSlider.setMax(amount.intValue());
        }
        catch(NumberFormatException ex){
            System.out.print("NumberFormatException");
        }
    }
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
