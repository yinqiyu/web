package vo;

public class User {

	private String userName;
	private String password;
	private static String chrName;
	
	
	
	public User(String userName, String password, String chrName) {
		this.userName = userName;
		this.password = password;
		this.chrName = chrName;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static String getChrName() {
		return chrName;
	}
	public void setChrName(String chrName) {
		this.chrName = chrName;
	}

}
	
	
	
