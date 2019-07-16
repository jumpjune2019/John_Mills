package stringarrayutilities_refactored;

import java.util.*;

public class Driver{


	public static void main(String[] args){

		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		boolean found;
		HasMatch myMatch;
		ArrayIndex myIndex;
		int foundIndexes[];
		
		myMatch = (arr, target, caseSensitive) -> {
			
			boolean flag = false;

			for(int i=0; i < arr.length; i++){

				if(caseSensitive == true){

					if(arr[i].equals(target)){
						flag = true;
					}

				}else{

					if(arr[i].equalsIgnoreCase(target)){
						flag = true;
					}

				}

			}//end for loop

			return flag;
		};
		
		myIndex = (arr, target, caseSensitive) -> {
			
			int newArr[];
			int tempArr[] = new int[arr.length];
			int count = 0;

			for(int i=0; i < arr.length; i++){

				if(caseSensitive == true){

					if(arr[i].equals(target)){
						tempArr[count] = i;
						count++;
					}

				}else{

					if(arr[i].equalsIgnoreCase(target)){
						tempArr[count] = i;
						count++;
					}

				}

			}//end for loop

			if(count != 0){
				newArr = new int[count];
				for(int i=0; i < count; i++){
					newArr[i] = tempArr[i];
				}
			}else{
				newArr = new int[1];
				newArr[0] = -1;
			}

			return newArr;
			
		};

		System.out.println("This is the test of the myMatch.hasMatch and myIndex.indexOf methods");
		System.out.println("The array to test contains the following items");
		System.out.println(Arrays.toString(myList));

		System.out.println("Scenario 1");
		found = myMatch.hasMatch(myList, "zo", false);
		System.out.println("myMatch.hasMatch(myList, \"zo\", false): is " + found);
		System.out.println();

		System.out.println("Scenario 2");
		found = myMatch.hasMatch(myList, "zoo", false);
		System.out.println("myMatch.hasMatch(myList, \"zoo\", false): is " + found);
		System.out.println();

		System.out.println("Scenario 3");
		found = myMatch.hasMatch(myList, "zoo", true);
		System.out.println("myMatch.hasMatch(myList, \"zoo\", true): is " + found);
		System.out.println();

		System.out.println("Scenario 4");
		found = myMatch.hasMatch(myList, "foo", true);
		System.out.println("myMatch.hasMatch(myList, \"foo\", true): is " + found);
		System.out.println();

		System.out.println("Scenario 5");
		found = myMatch.hasMatch(myList, "foo", false);
		System.out.println("myMatch.hasMatch(myList, \"foo\", false): is " + found);
		System.out.println();

		System.out.println("Scenario 6");
		found = myMatch.hasMatch(myList, "delta", true);
		System.out.println("myMatch.hasMatch(myList, \"delta\", true): is " + found);
		System.out.println();

		System.out.println("Scenario 7");
		found = myMatch.hasMatch(myList, "Delta", true);
		System.out.println("myMatch.hasMatch(myList, \"Delta\", true): is " + found);
		System.out.println();


		//start testing myMatch.hasMatch
		System.out.println("Scenario 8");
		foundIndexes = myIndex.indexOf(myList, "zo", false);
		System.out.println("myIndex.indexOf(myList, \"zo\", false): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 9");
		foundIndexes = myIndex.indexOf(myList, "zoo", false);
		System.out.println("myIndex.indexOf(myList, \"zoo\", false): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 10");
		foundIndexes = myIndex.indexOf(myList, "zoo", true);
		System.out.println("myIndex.indexOf(myList, \"zoo\", true): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 11");
		foundIndexes = myIndex.indexOf(myList, "foo", true);
		System.out.println("myIndex.indexOf(myList, \"foo\", true): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 12");
		foundIndexes = myIndex.indexOf(myList, "foo", false);
		System.out.println("myIndex.indexOf(myList, \"foo\", false): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 13");
		foundIndexes = myIndex.indexOf(myList, "delta", true);
		System.out.println("myIndex.indexOf(myList, \"delta\", true): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 14");
		foundIndexes = myIndex.indexOf(myList, "Delta", true);
		System.out.println("myIndex.indexOf(myList, \"Delta\", true): is " + Arrays.toString(foundIndexes));


	}//end main


}//end Driver class