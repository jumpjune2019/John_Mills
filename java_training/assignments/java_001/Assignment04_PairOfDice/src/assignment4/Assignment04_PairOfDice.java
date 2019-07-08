package assignment4;

import java.util.*;

public class Assignment04_PairOfDice{


	public static void main(String[] args){

		System.out.println("Press any key to throw a die and press Enter (or Q and Enter to quit)");
		play();

	}//end main


	public static void play(){

		Scanner scan = new Scanner(System.in);
		if(scan.next().equalsIgnoreCase("q")){
			//do nothing
		}else{
			System.out.println("You have rolled the following: ");
			System.out.println("First Die: " + rollDie());
			System.out.println("Second Die: " + rollDie());
			System.out.println("Play Again? (Y or y) and Enter, any other key and Enter to Quit.");

				while(scan.next().equalsIgnoreCase("y")){

					System.out.println("First Die: " + rollDie());
					System.out.println("Second Die: " + rollDie());
					System.out.println("Play Again? (Y or y) and Enter, any other key and Enter to Quit.");

				}

		}


	}//end play


	public static int rollDie(){

		int num;
		Random rand = new Random();

		num = rand.nextInt(6) + 1;
		return num;

	}//end rollDie


}//end class