import java.sql.Connection;

public abstract DAOFactory {
	
	// List of DAO types supported by the factory
	  public static final int MYSQL = 0;
	 
	  public static DAOFactory getDAOFactory(int whichFactory) {

	    switch (whichFactory) {
	      case MYSQL: 
	          return new MySQLDAOFactory();
	    }
	    
	  }

}
