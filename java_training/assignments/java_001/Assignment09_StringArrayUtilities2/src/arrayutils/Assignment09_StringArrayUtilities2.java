package arrayutils;
import java.util.Arrays;

public class Assignment09_StringArrayUtilities2 {

	public static void main(String[] args){

		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		boolean found;
		int foundIndexes[];

		System.out.println("This is the test of the arrayHasExactMatch and indexOfOccuranceInArray methods");
		System.out.println("The array to test contains the following items");
		System.out.println(Arrays.toString(myList));

		System.out.println("Scenario 1");
		found = ArrUtil.arrayHasExactMatch(myList, "zo", false);
		System.out.println("arrayHasExactMatch(myList, \"zo\", false): is " + found);
		System.out.println();

		System.out.println("Scenario 2");
		found = ArrUtil.arrayHasExactMatch(myList, "zoo", false);
		System.out.println("arrayHasExactMatch(myList, \"zoo\", false): is " + found);
		System.out.println();

		System.out.println("Scenario 3");
		found = ArrUtil.arrayHasExactMatch(myList, "zoo", true);
		System.out.println("arrayHasExactMatch(myList, \"zoo\", true): is " + found);
		System.out.println();

		System.out.println("Scenario 4");
		found = ArrUtil.arrayHasExactMatch(myList, "foo", true);
		System.out.println("arrayHasExactMatch(myList, \"foo\", true): is " + found);
		System.out.println();

		System.out.println("Scenario 5");
		found = ArrUtil.arrayHasExactMatch(myList, "foo", false);
		System.out.println("arrayHasExactMatch(myList, \"foo\", false): is " + found);
		System.out.println();

		System.out.println("Scenario 6");
		found = ArrUtil.arrayHasExactMatch(myList, "delta", true);
		System.out.println("arrayHasExactMatch(myList, \"delta\", true): is " + found);
		System.out.println();

		System.out.println("Scenario 7");
		found = ArrUtil.arrayHasExactMatch(myList, "Delta", true);
		System.out.println("arrayHasExactMatch(myList, \"Delta\", true): is " + found);
		System.out.println();


		//start testing arrayHasExactMatch
		System.out.println("Scenario 8");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "zo", false);
		System.out.println("indexOfOccuranceInArray(myList, \"zo\", false): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 9");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "zoo", false);
		System.out.println("indexOfOccuranceInArray(myList, \"zoo\", false): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 10");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "zoo", true);
		System.out.println("indexOfOccuranceInArray(myList, \"zoo\", true): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 11");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "foo", true);
		System.out.println("indexOfOccuranceInArray(myList, \"foo\", true): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 12");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "foo", false);
		System.out.println("indexOfOccuranceInArray(myList, \"foo\", false): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 13");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "delta", true);
		System.out.println("indexOfOccuranceInArray(myList, \"delta\", true): is " + Arrays.toString(foundIndexes));
		System.out.println();

		System.out.println("Scenario 14");
		foundIndexes = ArrUtil.indexOfOccuranceInArray(myList, "Delta", true);
		System.out.println("indexOfOccuranceInArray(myList, \"Delta\", true): is " + Arrays.toString(foundIndexes));

	}//end main
	

}//end class