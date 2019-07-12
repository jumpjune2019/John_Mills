

public class MyThread implements Runnable{
	Thread thrd;
	boolean suspended;
	boolean stopped;
	
	MyThread(String name){
		thrd = new Thread(this, name);
		suspended = false;
		stopped = false;
		thrd.start();
	}
	
	
	public void run(){
		
		System.out.println(thrd.getName() + " starting execution.");
		try {
			
			while(true) {
				
				Thread.sleep(1000);

				
				synchronized (this) {
					
					while(suspended) {
						//System.out.println("Thread " + thrd.getName() + " suspended from running");
						wait();
					}
					System.out.println("Executing " + thrd.getName() + " thread");
					
					//terminates thread
					if(stopped) {
						break;
					} 
					
					
					
				}//end synchronized
				
				
			}//end while
			
			
		} catch(InterruptedException exc) {
			
		}
				
	}//end run

	public boolean isMyThreadAlive() {
		
		return thrd.isAlive();
		
	}
	
	synchronized void myStop() {
		stopped = true;
		// The following ensures that a suspended thread can be stopped.
		suspended = false;
		

		notify();
	}
	// Suspend the thread.
	synchronized void mySuspend() {
		System.out.println("Pausing thread " + this.getMyName());
		suspended = true;
	}
	// Resume the thread.
	synchronized void myResume() {
		System.out.println("Resuming thread " + this.getMyName());
		suspended = false;
		notify();
	}
	
	
	public void setMyThreadPriority(String input) {
		

		if(input.equals("T")) {
			thrd.setPriority(10);
		}else if(input.equals("N")) {
			thrd.setPriority(5);
		}else if(input.equals("L")){
			thrd.setPriority(1);
		}
		
		System.out.println("Priority for " + thrd.getName() + " set to: " + thrd.getPriority());
				
	}
	
	public int getMyThreadPriority() {
		
		return thrd.getPriority();
	}
	
	public String getMyName() {
		return thrd.getName();
	}
	
	public Thread.State getMyThreadState(){
		
		return thrd.getState();
	}
	
	public boolean isSuspended() {
		return suspended;
	}
	
	
}//end class
