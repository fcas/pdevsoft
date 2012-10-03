package dao;

public class Factory {
	public static UserDAO createUserDAO() {
		return new JDBCUserDao();
	}

}
