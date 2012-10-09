package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory {

	DaoExame daoExame;
	DaoPaciente daoPaciente; 
	DaoMedicoLaboratorio daoMedicoLaboratorio; 
	DaoMedicoRequisitante daoMedicoRequisitante;

	public DaoMedicoRequisitante createDaoMedicoRequisitante() {
		daoMedicoRequisitante = new DaoMedicoRequisitante();
		return daoMedicoRequisitante;
	}
	
	public DaoExame createDaoExame() {
		daoExame = new DaoExame();
		return daoExame;
	}
	
	public DaoPaciente createDaoPaciente() {
		daoPaciente = new DaoPaciente();
		return daoPaciente;
	}
	
	public DaoMedicoLaboratorio createDaoMedicoLaboratorio() {
		daoMedicoLaboratorio = new DaoMedicoLaboratorio();
		return daoMedicoLaboratorio;
	}
	
	
//	public IDaoUsuario createDaoUsuario() {
//		return new DaoUsuario();
//	}
	

}