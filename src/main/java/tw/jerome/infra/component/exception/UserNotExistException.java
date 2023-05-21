package tw.jerome.infra.component.exception;

public class UserNotExistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8223658795001610466L;

	public UserNotExistException() {
		super("用戶不存在");
	}
}
