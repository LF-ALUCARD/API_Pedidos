package luiz.dev.lojinha.services.exceptions;

public class InsertException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InsertException(String msg) {
		super(msg);
	}
}
