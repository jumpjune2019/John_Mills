package proofofconcepts;
import java.util.*;
public class IntToString {

	public static void main(String[] args) {
		
		int one = 2;
		String str = getCharForNumber(one);
		System.out.println(str);
		
		Random rand = new Random();
		int temp;
		for(int i=0; i < 1000; i++) {
			temp = rand.nextInt(10);
			System.out.println(temp);
		}
		
		
	}//end main

	
	public static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
	
	
}