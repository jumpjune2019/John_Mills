package basicsorting;

import java.util.*;

public class Driver{

	public static void main(String[] args) {

		
		Sort<Integer> sortInt;
		Sort<String> sortString;
		Integer intArr[] = {10, 3, 4, 15, 7, 1, 21};
		String stringArr[] = { "claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce" };
		boolean up = true;
		boolean down = false;
		boolean caseSensitive = true;
		boolean caseNotSens = false;

		sortInt = (arr, ascOrDesc, caseSens) -> {
			
			Collections.sort(Arrays.asList(arr));
			if(ascOrDesc == true) {
				return arr;
			}else {
				Collections.reverse(Arrays.asList(arr));
				return arr;
			}
			
		};
		
		sortString = (arr, ascOrDesc, caseSens) -> {
			
			if(caseSens == true) {
				Collections.sort(Arrays.asList(arr));
			}else {
				Collections.sort(Arrays.asList(arr), String.CASE_INSENSITIVE_ORDER);
			}
			
			if(ascOrDesc == true) {
				return arr;
			}else {
				Collections.reverse(Arrays.asList(arr));
				return arr;
			}
			
		};
		
		System.out.print("Initial integer array: ");
		displayIntArr(intArr);
		System.out.print("Sorted ASC: " );
		displayIntArr(sortInt.sort(intArr, up, caseNotSens));
		System.out.print("Sorted DESC: " );
		displayIntArr(sortInt.sort(intArr, down, caseNotSens));
		System.out.println();

		System.out.print("Initial string array: ");
		displayStringArr(stringArr);
		System.out.print("Sorted ASC and CASE SENS ON: " );
		displayStringArr(sortString.sort(stringArr, up, caseSensitive));
		System.out.print("Sorted ASC and CASE SENS OFF: " );
		displayStringArr(sortString.sort(stringArr, up, caseNotSens));
		
		System.out.print("Sorted DESC and CASE SENS ON: " );
		displayStringArr(sortString.sort(stringArr, down, caseSensitive));
		System.out.print("Sorted DESC and CASE SENS OFF: " );
		displayStringArr(sortString.sort(stringArr, down, caseNotSens));
			
	}//end main
	
	
	//simple method to show items in array
	//would have made generic if needed
	//for more than Integer and String
	public static void displayIntArr(Integer[] arr) {
		
		System.out.print("{ ");
		for(int i=0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length-1] + " }");
		
	}//end displayArr
	
	public static void displayStringArr(String[] arr) {
		
		System.out.print("{ ");
		for(int i=0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length-1] + " }");
		
	}//end displayArr
	
	
}//end Driver class