/**
 * PROGRAM PURPOSE: PayoutTable class for SlotMachine.
 * Name: Cece Schweighardt, Rachel Costello, Hayden Franklin, Haley Rogers, Hayden Tuttle
 * Date: 4/24/2022
 * Section: CSC 331-001
 */
package application;

public class PayoutTable {
	
	int[] valueTable;	//the point values of each slot image
	int doubleMult;		//multiplier for two of the same points
	int tripleMult;		//multiplier for three of the same points
	String payoutMessage;   //string for payout message based on calcualtion
	
	//initialize the pay out table
	public PayoutTable(int[] valueTable, int doubleMult, int tripleMult) {
		this.valueTable = valueTable;
		this.doubleMult = doubleMult;
		this.tripleMult = tripleMult;
	}

	//calculate and return point value pay out for the current slot display position 
	public int calculatePayout(int s1Pos, int s2Pos, int s3Pos) {
		if(s1Pos == s2Pos) {
			if(s1Pos == s3Pos) {
				//triple
				payoutMessage = "Triple!";
				return valueTable[s1Pos] * tripleMult;
			}else {
				//double [s1,s3]
				payoutMessage = "Double";
				return valueTable[s1Pos] * doubleMult;
			}
		}else {
			if(s2Pos == s3Pos) {
				//double [s2,s3]
				payoutMessage = "Double";
				return valueTable[s2Pos] * doubleMult;
			}else {
				if(s1Pos == s3Pos) {
					//double [s1, s3]
					payoutMessage = "Double";
					return valueTable[s1Pos] * doubleMult;
				}else {
					//no score
					payoutMessage = "Try Again...";
					return 0;
				}
			}
		}
	}
	//method returns String payoutMessge
	public String lastPayoutMessage() {
		return payoutMessage;
	}
}
