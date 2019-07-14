package trafficlight;

public enum Lights {
	Green(5000, "Green - Go!"), Yellow(2000, "Yellow - Beware!"), Red(3000, "Red - Stop!");
	private long seconds;
	private String myStr;
	private int current;
	String state;
	
	//current is set to -1 so I can call getNext
	//in main without a problem. The first thread
	//to call getNext will cycle it to 0, then 0-2 forever after
	private Lights(long seconds, String myStr) {
		this.seconds = seconds;
		this.myStr = myStr;
		current = -1;
	}
	
	public long getSeconds() {
		return seconds;
	}
	
	public String getString() {
		return myStr;
	}
	
	synchronized Lights getNext() {
		
		current++;
		if(current >= 3) {
			current = 0; 
		}
		
		return values()[current];
		
	}
	

}//end enum Lights