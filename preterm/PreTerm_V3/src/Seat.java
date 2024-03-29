
public class Seat {

	String rowIndex;
	int seatIndex;
	Client currentClient;
	
	
	public Seat(String rowIndex, int seatIndex, Client currentClient) {
		this.rowIndex = rowIndex;
		this.seatIndex = seatIndex;
		this.currentClient = currentClient;
	}
	
	public void setRowIndex(String str) {
		rowIndex = str;
	}
	
	public String getRowIndex() {
		return rowIndex;
	}
	
	public void setSeatIndex(int num) {
		seatIndex = num;
	}
	
	public int getSeatIndex() {
		return seatIndex;
	}
	
	public Client getClient() {
		return currentClient;
	}
	
	public void setClient(Client currentClient) {
		this.currentClient = currentClient;
	}
	
	String getSeatId() {
		return rowIndex + "-" + seatIndex;
	}
	
}//end Seat class