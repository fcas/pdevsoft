package dao;

import java.util.List;


public interface UserDAO {

	public void save (User user); 
	public void delete (User user); 
	public List<?> list();
	public User find (String name); 
	
}
