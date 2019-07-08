package assignment2;

import java.util.*;

public class Assignment02_HeadOrTailTally{


	public static void main(String[] args){

		int tally[] = {0, 0};
		int num;
		for(int i=0; i < 1000; i++){
			num = randomNumber();
			if(num == 1){
				tally[0]++;
			}else{
				tally[1]++;
			}
		}

		System.out.println("1000 Coin Flips");
		System.out.println("Count of Heads: " + tally[0]);
		System.out.println("Count of Tails: " + tally[1]);


	}//end main


	//gives random number thats either 1 or 2
	public static int randomNumber(){

		Random rand = new Random();
		int number = rand.nextInt(2) + 1;

		return number;

	}//end randomBNumber


	//returns a string depending on number input
	public static String headOrTails(int input){

		String str;
		if(input == 1){
			str = "Head";
		}else{
			str = "Tail";
		}

		return str;

	}//end headOrTails


}//end class Assignment01