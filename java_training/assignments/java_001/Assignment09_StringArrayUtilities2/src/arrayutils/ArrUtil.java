package arrayutils;

public class ArrUtil {

	static boolean arrayHasExactMatch(String[] arr, String target, boolean caseSensitive){

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

	}//end arrayHasExactMatch


	static int[] indexOfOccuranceInArray(String[] arr, String target, boolean caseSensitive){

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

	}//end indexOfOccuranceInArray
	
	
}
