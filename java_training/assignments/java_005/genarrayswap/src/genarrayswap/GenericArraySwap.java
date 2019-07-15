package genarrayswap;

public class GenericArraySwap {

	
	public static void main(String[] args) {
		
		Integer[] intArr = new Integer[10];
		String[] stringArr = new String[10];
		
		for(int i=0; i < 10; i++) {	
			intArr[i] = i;
			stringArr[i] = "String number: " + Integer.toString(i);
		}//end for loop
		
		
		GenericClass<Integer> myInt = new GenericClass<>(intArr);
		GenericClass<String> myString = new GenericClass<>(stringArr);
		
		System.out.println("Integer elements before swapping");
		System.out.println("arr[3]: " + myInt.getIndex(3));
		System.out.println("arr[6]: " + myInt.getIndex(6));
		
		System.out.println();
		System.out.println("After swap");
		
		myInt.genSwap(3, 6);
		
		System.out.println("arr[3]: " + myString.getIndex(3));
		System.out.println("arr[6]: " + myString.getIndex(6));
		System.out.println();
		
		
		System.out.println("String elements before swapping");
		System.out.println("arr[3]: " + myString.getIndex(3));
		System.out.println("arr[6]: " + myString.getIndex(6));
		
		System.out.println();
		System.out.println("After swap");
		
		myString.genSwap(3, 6);
		
		System.out.println("arr[3]: " + myString.getIndex(3));
		System.out.println("arr[6]: " + myString.getIndex(6));
		
		
	}//end main
	
	
}