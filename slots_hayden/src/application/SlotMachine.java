/**
 * PROGRAM PURPOSE: Main executable class for SlotMachine.
 * Changes made by:
 * Name: Cece Schweighardt, Rachel Costello, Hayden Franklin, Haley Rogers, Hayden Tuttle
 * Date: 4/15/2022
 * Section: CSC 331-001
 */
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class SlotMachine extends Application{
	@Override
	//start method to load fxml file.

	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SlotMachine.fxml")));
		
		Scene scene = new Scene(root);
		stage.setTitle("SlotMachine");
		stage.setScene(scene);
		stage.show();
	}
	//main method that launches Slot Machine.
	public static void main(String[] args) {
		launch(args);
	}
}
