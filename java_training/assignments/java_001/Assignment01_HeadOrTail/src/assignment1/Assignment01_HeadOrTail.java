package assignment1;
import java.util.*;

public class Assignment01_HeadOrTail{


	public static void main(String[] args){

		int num = randomNumber();
		String headOrTails = headOrTails(num);

		System.out.println("Coin Flip Program");
		System.out.println("The Coin Flip is: " + headOrTails);

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
			str = "Heads";
		}else{
			str = "Tails";
		}

		return str;

	}//end headOrTails


}//end class Assignment01