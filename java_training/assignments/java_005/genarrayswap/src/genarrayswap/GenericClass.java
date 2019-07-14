package genarrayswap;

public class GenericClass<T>{

	private T myArr[];
	
	public GenericClass(T[] myArr){
		
		this.myArr = myArr;
		
	}
	
	
	public void genSwap(int firstIndex, int secondIndex) {
		
		T[] temp = myArr;
		T tempObj = temp[firstIndex];
		temp[firstIndex] = temp[secondIndex];
		temp[secondIndex] = tempObj;
		
		
		myArr = temp;
		
	}//end genSwap
	
	public T getIndex(int i) {
		return myArr[i];
	}
	
	
	
}//end GenericClass