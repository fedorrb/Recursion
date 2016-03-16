package recursion;

public class DeleteException extends Exception {
	private String message;

	public DeleteException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage(){
		return "Error. " + message;
	}

}
