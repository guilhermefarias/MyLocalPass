package entity;

public class Account {
	String name;
	String login;
	String password;
	String description;
	
	public String getName() {
		return name;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getDescription() {
		return description;
	}
	
	public Account(String name, String login, String password,
			String description) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.description = description;
	}
}
