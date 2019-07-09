package phone;
import java.io.*;

public class MyPhone{
	
	public static void main(String[] args) {
		
		String input;
		FileWriter fout = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String phoneBook[][] = new String[3][5];
		boolean keepGoing = true;
		
		
		try {
			
			fout = new FileWriter("C:\\java_training\\assignments\\java_003\\phone\\phone.txt");
			
			for(int i=0; i < 5; i++){
				
				System.out.println("Enter a name and press enter:");
				
				while(keepGoing) {
					
					try {
						
						phoneBook[0][i] = br.readLine();
						keepGoing = false;
						if(phoneBook[0][i].length() == 0) {
							throw new MyException();
						}
						
						
					} catch(MyException e) {
						System.out.println("ERR: Please enter a name");
						keepGoing = true;
					}
							
				}//end while
				
				keepGoing = true;
				
				System.out.println("Enter your phone number and press enter:");
				
				while(keepGoing) {
					
					try {

						phoneBook[1][i] = br.readLine();
						keepGoing = false;
						if(phoneBook[1][i].length() == 0) {
							throw new MyException();
						}
						
						
					} catch(MyException e) {
						System.out.println("ERR: Please enter a number");
						keepGoing = true;
					}
							
				}//end while
				
				keepGoing = true;
				
				System.out.println("Enter your city: ");
				
				while(keepGoing) {
					
					try {

						phoneBook[2][i] = br.readLine();
						keepGoing = false;
						if(phoneBook[2][i].length() == 0) {
							throw new MyException();
						}
						
						
					} catch(MyException e) {
						System.out.println("ERR: Please enter a city");
						keepGoing = true;
					}
							
				}//end while
				
				System.out.println("Data entered is:");
				System.out.println("Name: " + phoneBook[0][i]);
				System.out.println("Number: " + phoneBook[1][i]);
				System.out.println("City: " + phoneBook[2][i]);
				System.out.println("Is this correct? Press any key if correct, or (R or r) to restart this row.");
				input = br.readLine();
				if(input.equalsIgnoreCase("R")) {
					i--;
				}
				
				keepGoing = true;
				
			}//end for loop
			
			printToScreen(phoneBook);
			printToFile(fout, phoneBook);
			
			
		}catch(IOException e){
			System.out.println("ERR: " + e.getMessage());
		}
		
	}//end main
	
	public static void printToScreen(String[][] myArr) {

		System.out.format("%-20s", "Name");
		System.out.format("%-20s", "Phone");
		System.out.format("%-20s", "City");
		System.out.println();
		
		for(int i=0; i < 5; i++) {
			
			System.out.format("%-20s", myArr[0][i]);
			System.out.format("%-20s", myArr[1][i]);
			System.out.format("%-20s", myArr[2][i]);
			System.out.println();
			
		}//end for loop
		
	}//end displayArray
	
	public static void printToFile(FileWriter fw, String[][] myArr) throws IOException{

		fw.write(String.format("%-20s", "Name"));
		fw.write(String.format("%-20s", "Name"));		
		fw.write(String.format("%-20s", "Name"));
		
		fw.write("\n");
		
		for(int i=0; i < 5; i++) {
			
			fw.write(String.format("%-20s", myArr[0][i]));			
			fw.write(String.format("%-20s", myArr[1][i]));			
			fw.write(String.format("%-20s", myArr[2][i]));
			
			fw.write("\n");

			
		}//end for loop
		
		fw.flush();
		fw.close();
		
	}//end displayArray
	

}//end class MyPhone