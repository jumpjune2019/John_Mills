package matrixcustomhandlers;

public class InvalidValueException extends Exception{

	public InvalidValueException() {
		super();
	}
	
	public String getMessage() {
		return "That is  not 1-6 for the matrix";
	}
	
}