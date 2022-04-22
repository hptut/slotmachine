/**
 * PROGRAM PURPOSE: SlotWheel class for SlotMachine.
 * Name: Cece Schweighardt, Rachel Costello, Hayden Franklin, Haley Rogers, Hayden Tuttle
 * Date: 4/24/2022
 * Section: CSC 331-001
 */
package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SlotWheel {
	
	Image[] imageTable;
	int currentPosition;
	private ImageView myView;

	//constructor for SlotWheel class array of images and an image view
	SlotWheel(Image[] imageTable, ImageView view) {
		this.myView = view;
		this.imageTable = imageTable;
		roll(); //in order to have an initial state 
	}
	
	//generate a new position for the slot wheel
	public int roll() {
		int newPosition = (int)(Math.random() * imageTable.length);
		currentPosition = newPosition;
		myView.setImage(getCurrentImage());
		return newPosition;
	}
	
	//return the image from the image table of the current position of the slot wheel
	public Image getCurrentImage() {
		return imageTable[currentPosition];
	}
	
	//return the current position of the slot wheel
	public int getCurrentPosition() {
		return currentPosition;
	}
}
