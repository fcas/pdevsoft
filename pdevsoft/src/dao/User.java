package dao;

import java.util.List;

public class User implements UserDAO {
	private String name, password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(String name) {
		// TODO Auto-generated method stub
		return null;
	} 
}
