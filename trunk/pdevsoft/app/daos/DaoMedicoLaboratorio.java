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


public class DaoMedicoLaboratorio implements IDaoMedLab {
	/*TANTO AQUI QUANTO EM MEDICO REQUISITANTE ESTA FALTANDO
	 * IMPLEMENTAR OS METODOS LISTAR E BUSCAR. 
	 * POR FAVOR, FACAM ISSO! Deve ter o código SQL
	 * naquele DOCS que a gente tinha. Anderson sabe qual é
	 * 
	 */
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

	public void criarMedLab (MedicoLab medicolab) {

		try {
		
			String insert_medico = "INSERT INTO MedicoLab VALUES ("
					+ medicolab.CRML + ",'" + medicolab.nome + "','"
					+ medicolab.email + "','" + medicolab.telefone + "')";

			conectar();
			comando.executeUpdate(insert_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void apagarMedLab (MedicoLab medicolab) {

		String apagar_medico = "DELETE FROM MedicoLab WHERE CRML = "
				+ medicolab.CRML + ";";
		try {
			conectar();
			comando.executeUpdate(apagar_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarMedLab (MedicoLab medicolab) {//AJEITAR O UPDATE AQUI E EM MEDICOREQ

		String apagar_medico = "UPDATE FROM MedicoLab WHERE CRML = "
				+ medicolab.CRML + ";";
		try {
			conectar();
			comando.executeUpdate(apagar_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MedicoLab> listarMedicosLab() {
		
		conectar();
		List<MedicoLab> list_medlab = new ArrayList<MedicoLab>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM MedicoLab;");
			
			while (result.next()) {
				MedicoLab le = new MedicoLab();
				le.setCRML(result.getInt("CRM"));
				le.setNome(result.getString("nome"));
				le.setEmail(result.getString("email"));
				le.setTelefone(result.getString("telefone"));
				list_medlab.add(le);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list_medlab;
	}
	
	public MedicoLab buscarMedicoLab(int CRML) {
		
		ResultSet result = null;
		MedicoLab le = new MedicoLab();
		
		try {
			conectar();
			result = comando.executeQuery("SELECT * FROM MedicoLab WHERE CRML = "
					+ CRML + ";");
			
			if (result.next()) { 
				le.setCRML(result.getInt("CRML"));
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
	
}
