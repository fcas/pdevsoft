package daos;

import java.sql.Connection;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	
	public static DAOFactory getDAOFactory(int whichFactory) {
	
		 switch (whichFactory) {
		    case MYSQL: 
		        return new MySQLDAOFactory();
		 }

	}

}