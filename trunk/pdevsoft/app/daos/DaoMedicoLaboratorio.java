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
		return null;
	}
	
	public MedicoLab buscarMedicoLab(int CRML) {
		return null;
	}
	
}
