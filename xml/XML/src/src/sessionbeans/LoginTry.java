package src.sessionbeans;

public class LoginTry {
	
	private String email;
	private String pass;
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	public LoginTry(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
	public LoginTry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
