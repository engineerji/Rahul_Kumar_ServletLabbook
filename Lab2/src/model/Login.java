package model;

public class Login {
	private String username;
	private String password;
	
	
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUserName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
