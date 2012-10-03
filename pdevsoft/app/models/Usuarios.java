package models;
import play.db.jpa.Model;
import javax.persistence.*;
import java.util.*;

public class Usuarios extends Model {

	public String username;
	public String password; 
	
	
	//getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
