import java.util.*;
public class Room {

	private Seat[][] mySeats;
	private int roomNumber;
	private Client[] clientList;
	

	public Room(int roomNumber, Client[] clientList) {
		this.roomNumber = roomNumber;
		mySeats = new Seat[10][10];
		this.clientList = clientList;
		//populateSeats();
	}
	
	int getRoomNumber() {
		return roomNumber;
	}
	
	Seat[][] getMySeats(){
		return mySeats;
	}
	
	void setMySeats(Seat[][] arr) {
		mySeats = arr;
	}
	
	//this should never be called
	void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	void populateSeats() {
		
		Random rand = new Random();
		int count = 0;
		int firstIndex = rand.nextInt(10);
		int secondIndex = rand.nextInt(10);
		String intToStr;
		Seat currentSeat;
		Client currentClient = clientList[0];
		
		
		for(int i=0; i < 25; i++) {
		
			while(mySeats[firstIndex][secondIndex] != null) {
				
				firstIndex = rand.nextInt(10);
				secondIndex = rand.nextInt(10);
				
			}//end while

			intToStr = getCharForNumber(firstIndex+1);
			currentSeat = new Seat(intToStr, secondIndex, currentClient);
			currentClient.setSeat(currentSeat);
			
			mySeats[firstIndex][secondIndex] = currentSeat;
			if(count < 24) {
				count++;
			}
			currentClient = clientList[count];
			
			
		}//end for loop
		
	}//end populateSeats
	

	void printSeats() {
		
		Client current;
		String vacant = "vacant";
		System.out.print("      ");
		for(int i=1; i < 11; i++) {
			System.out.format("%-12s", "| Seat " + i);
			//System.out.format(formatting, "| Seat " + i);
		}
		System.out.println("\n");
		
		for(int i=0; i < 10; i++) {
			
			System.out.format("%-5s", "Row " + getCharForNumber(i+1) + " ");

			for(int j=0; j < 10; j++) {

				if(mySeats[i][j] != null) {
					current = mySeats[i][j].getClient();
					System.out.format("%-12s", "| " + current.getClientIdandInit());
				}else {
					System.out.format("%-12s", "| " + vacant);
				}
				
			}//end inner loop
			
			System.out.println("\n");

		}//end outer for
		
	}//end printSeats
	
	
	void printAssignments() {
		
		System.out.format("%-30s", "Client");
		System.out.format("%-10s", "ID");
		System.out.format("%-5s", "Seat Number");
		System.out.println();
		for(int i=0; i < 25; i++) {
			
			System.out.format("%-30s", clientList[i].getClientName(), clientList[i].getClientSeatId());
			System.out.format("%-10s", clientList[i].getClientId());
			System.out.format("%-10s", clientList[i].getClientSeatId());
			System.out.println();
			
		}
		
	}
	
	public static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}

}//end Room