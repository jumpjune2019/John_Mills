public class Main {
	
	public static void main(String[] args) {
		
		startApp();				
		
	}//end main
	
	
	public static void startApp() {
		
		System.out.println("startApp()");
		ClientStore myStore = getInput();
		
		
		Room firstRoom = new Room(1, myStore.getClientStore());
		firstRoom.printSeats();
		System.out.println();
		firstRoom.printAssignments();
		
	}//end startApp
	
	public static ClientStore getInput() {

		// quick test of the client data structure
		System.out.println("getInput()\n");
		System.out.println("- We are going to create a Client class that will hold data and return itself or some info about it");

		// quick test to see if we can load data from a CSV file
		// and at least get an accurate count of the rows loaded in
		System.out.println("- Testing the ClientStore class\n");
		ClientStore myStore = new ClientStore("clients_list.csv");

		
		return myStore;
		
	}//end getInput
	
	
	//credit goes to stackoverflow for the simple
	//way to convert '1' to A, '1' to B...etc
	public static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}


}//end Main class