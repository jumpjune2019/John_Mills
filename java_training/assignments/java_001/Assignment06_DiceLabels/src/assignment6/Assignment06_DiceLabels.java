package assignment6;

import java.util.*;

public class Assignment06_DiceLabels{


	public static void main(String[] args){


		String myArr[][] = {

			{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one you're done"},
			{"Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"},
			{"Easy four", "OJ", "Brooklyn Forrest", "Big Red", "Eighter from Decatur", "Nina from Pasadena"},
			{"Little Phoebe", "Easy Six", "Skinny McKinney", "Square pair", "Railroad nine", "Big one on the end"},
			{"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"},
			{"The devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight"}

		};//end array instantiation


		System.out.println("Dice Combinations Label Matrix");
		System.out.print("      ");
		for(int i=0; i < 6; i++){
			System.out.format("%-24s", "Die " + (i+1));
		}
		System.out.println();

		for(int i=0; i < 6; i++){

			System.out.format("Die " + (i+1) + " ");

			for(int j=0; j < 6; j++){

				System.out.format("%-24s", myArr[i][j]);

			}
			System.out.println();

		}

	}//end main


}//end class