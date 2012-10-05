package daos;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactory {

	public static final int MYSQL = 0;
	public abstract Connection conexao(String url, String nome, String senha,
			int banco) throws ClassNotFoundException, SQLException;
	
	public static DAOFactory getDAOFactory(int whichFactory) {
	
		 switch (whichFactory) {
		    case MYSQL: 
		        return new MySQLDAOFactory();
		 }
		 
		 return null;

	}

}