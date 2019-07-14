package trafficlight;
import java.io.*;

public class TrafficLight {

	public static void main(String[] args) throws IOException{

		boolean flag = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Lights myLight = Lights.Green;
		MyThread firstThread = null;
		MyThread secondThread = null;
		MyThread thirdThread = null;
		
		System.out.println("Traffic Light Simulator is a Go!");
		
		while(true) {
			

			firstThread = new MyThread(myLight.getNext());
			try {
				firstThread.thrd.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//each break statement is set so that the user does not have
			//to wait until all 3 threads execute to finish the program
			//the program can break after any one thread finishes execeuting
			if(br.ready()){
				break;
			}
			
			secondThread = new MyThread(myLight.getNext());
			try {
				secondThread.thrd.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(br.ready()){
				break;
			}
			
			thirdThread = new MyThread(myLight.getNext());
			try {
				thirdThread.thrd.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(br.ready()){
				break;
			}
					
								
		}//end while loop
		
		System.out.println("Traffic Light Simulator is Done!");
		
		//if user ends program before reaching creation of
		//any of the threads
		if(firstThread.isMyAlive()) {
			firstThread.myStop();
		}
		if(secondThread.isMyAlive()) {
			secondThread.myStop();
		}
		if(thirdThread.isMyAlive()) {
			thirdThread.myStop();
		}
		
	}//end main

		
}//end class TrafficLights