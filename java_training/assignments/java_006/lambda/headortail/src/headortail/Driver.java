package headortail;

import java.util.*;

public class Driver {


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int getRand;
		String getString;
		RandomNum myRand;
		HeadOrTail headOrTail;
		
		myRand = () -> rand.nextInt(2) + 1;
		
		headOrTail = (x) -> (x == 1) ? "Head" : "Tail";
		
		//I say press F, but any press that isn't Q will work
		System.out.println("Welcome to the game of Head or Tail where you will flip your life away!");
		System.out.println("Press the F key and flip your luck!");
		
		//input = scan.next();
		while(!scan.next().equalsIgnoreCase("q")){
		
			getRand = myRand.getInt();
			getString = headOrTail.getString(getRand);
			
			System.out.println("The coin flip is: " + getString + "!");
			System.out.println("Press the F key to try again, press Q or q to quit");
			
		
		}//end while
			
		scan.close();
		
	}//end main
	
}//end Driver class