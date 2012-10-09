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

	public void criarMedicoReq (MedicoReq medicoreq) {

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
	
	public void apagarMedicoReq (int CRMR) {

		String apagar_medico = "DELETE FROM MedicoReq WHERE CRMR = "
				+ CRMR + ";";
		try {
			conectar();
			comando.executeUpdate(apagar_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarMedicoReq (MedicoReq medicoreq) {//AJEITAR O UPDATE AQUI E EM MedicoReq

		String apagar_medico = "UPDATE FROM MedicoReq WHERE CRMR = "
				+ medicoreq.CRMR + ";";
		try {
			conectar();
			comando.executeUpdate(apagar_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MedicoReq> listarMedicosReq() {
		
		conectar();
		List<MedicoReq> list_medreq = new ArrayList<MedicoReq>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM MedicoReq;");
			
			while (result.next()) {
				MedicoReq le = new MedicoReq();
				le.setCRMR(result.getInt("CRMR"));
				le.setNome(result.getString("nome"));
				le.setEmail(result.getString("email"));
				le.setTelefone(result.getString("telefone"));
				list_medreq.add(le);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list_medreq;
	}
	
	public MedicoReq buscarMedicoReq(int CRMR) {
		
		ResultSet result = null;
		MedicoReq le = new MedicoReq();
		
		try {
			conectar();
			result = comando.executeQuery("SELECT * FROM MedicoReq WHERE CRMR = "
					+ CRMR + ";");
			
			if (result.next()) { 
				le.setCRMR(result.getInt("CRMR"));
				le.setNome(result.getString("nome"));
				le.setEmail(result.getString("email"));
				le.setTelefone(result.getString("telefone"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return le;
	}
	
	public boolean verificarCRM (int CRMR) {
		ResultSet result = null;
		
		try {
			conectar();
			result = comando.executeQuery("SELECT * FROM ExameLaudo WHERE CRMR = "
					+ CRMR + ";");
			
			if (result.next()) 
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}