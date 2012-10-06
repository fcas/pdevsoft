package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {

//	public static final int MYSQL = 0;
//	private static final String MySQLDriver = "com.mysql.jdbc.Driver";
//
//	public Connection conexao(String url, String nome, String senha,
//			int banco) throws ClassNotFoundException, SQLException {
//		
//		switch (banco) {
//			case MYSQL:
//				Class.forName(MySQLDriver);
//			break;
//		}
//		return DriverManager.getConnection(url, nome, senha);
//	}
	
	public IDaoPaciente createDaoPaciente() {
		return new DaoPaciente();
	}

	public IDaoExame createDaoExame() {
		return new DaoExame();
	}
	
	public IDaoMedLab createDaoMedicoLaboratorio() {
		return new DaoMedicoLaboratorio();
	}
	
	public IDaoMedReq createDaoMedicoRequisitante() {
		return new DaoMedicoRequisitante();
	}
	
//	public IDaoUsuario createDaoUsuario() {
//		return new DaoUsuario();
//	}
	

}