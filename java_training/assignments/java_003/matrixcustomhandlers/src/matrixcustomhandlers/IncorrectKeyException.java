package matrixcustomhandlers;

public class IncorrectKeyException extends Exception {

	public IncorrectKeyException() {
		super();
	}
		
	public String getMessage() {
		return "THAT ISNT 1, 2, OR 3";
	}
	
}