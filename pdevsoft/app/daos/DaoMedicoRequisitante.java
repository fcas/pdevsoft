package daos;

import play.*;
import play.mvc.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.persistence.Id;

import models.*;


public class DaoMedicoRequisitante implements IDaoMedReq {

	private static Connection con;
	private static Statement comando;

	private void conectar() {

		try {
			con = ConnectMySQL.conexao("jdbc:mysql://localhost/eplay", "eplay",
					"eplay", MySQLDAOFactory.MYSQL);
			comando = con.createStatement();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void criarMedReq (MedicoReq medicoreq) {

		try {
		
			String insert_medico = "INSERT INTO MedicoReq VALUES ("
					+ medicoreq.CRMR + ",'" + medicoreq.nome + "','"
					+ medicoreq.email + "','" + medicoreq.telefone + "')";

			conectar();
			comando.executeUpdate(insert_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void apagarMedReq (MedicoReq medicoreq) {

		String apagar_medico = "DELETE FROM MedicoReq WHERE CRMR = "
				+ medicoreq.CRMR + ";";
		try {
			conectar();
			comando.executeUpdate(apagar_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarMedReq (MedicoReq medicoreq) {//AJEITAR O UPDATE AQUI E EM MEDICOLAB

		String apagar_medico = "UPDATE FROM MedicoLab WHERE CRMR = "
				+ medicoreq.CRMR + ";";
		try {
			conectar();
			comando.executeUpdate(apagar_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MedicoReq> listarMedicosReq() {
		return null;
	}
	
	public MedicoReq buscarMedicoReq(int CRMR) {
		return null;
	}
	
}