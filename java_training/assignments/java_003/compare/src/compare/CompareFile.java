package compare;
import java.io.*;


public class CompareFile {

	public static void main(String[] args) {
	
		String file1 = args[0];
		String file2 = args[1];
		int charCount1 = 0;
		int charCount2 = 0;
		int firstFileInput;
		int secondFileInput;
		FileInputStream f1 = null;
		FileInputStream f2 = null;
		boolean flag = true;		//assume the files start out the same
		
		try {
			
			f1 = new FileInputStream(file1);
			f2 = new FileInputStream(file2);
			
			do {
				
				firstFileInput = f1.read();
				secondFileInput = f2.read();
				
				//files differ if flag ever becomes false
				if(firstFileInput != secondFileInput) {
					flag = false;
				}
				
				if(firstFileInput != -1) {
					charCount1++;
				}
				
				if(secondFileInput != -1) {
					charCount2++;
				}
				
			} while(firstFileInput != -1 || secondFileInput != -1);
			
			System.out.println("Output: " + file1 + " " + file2);
			System.out.println();
			
			if(flag){
				System.out.println("Result: identical content");
				System.out.println("character length for both: " + charCount1);
			}else{
				System.out.println("Result: different content");
				System.out.println("character length for file1.txt: " + charCount1);
				System.out.println("character length for file1.txt: " + charCount2);	
			}
					
		} catch (IOException e) {
			System.out.println("I/O Error: " + e);
		} finally {
			try {
				if(f1 != null) {
					f1.close();
				}
				if(f2 != null) {
					f2.close();
				}
			} catch(IOException exc) {
				System.out.println("Error closing file.");	
			}
		}
		
		
	}//end main
	
	
}//end CompareFile