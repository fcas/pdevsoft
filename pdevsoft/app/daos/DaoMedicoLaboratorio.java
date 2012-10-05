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


public class DaoMedicoLaboratorio extends Controller {
	
	private static Connection con;
	private static Statement comando;
	public static final int MYSQL = 0;

	private static void conectar() {

		MySQLDAOFactory factory = DAOFactory.getDAOFactory(MYSQL);
		
		try {
			con = factory.conexao("jdbc:mysql://localhost/eplay", "eplay",
					"eplay", factory.MYSQL);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			comando = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Conectado!");

	}
	
	public static void showMedlab() {

		conectar();
		List<MedicoLab> list_medico = new ArrayList<MedicoLab>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM MedicoLab ORDER BY nome");
			while (result.next()) {
				MedicoLab le = new MedicoLab();
				le.setCRML(result.getInt("CRML"));
				le.setNome(result.getString("observacoes"));
				le.setEmail(result.getString("situacao"));
				le.setTelefone(result.getString("datarec"));
				list_medico.add(le);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		render(list_medico);
	}

	public static void doCreateMedlab(MedicoLab medicolab) {
		conectar();
		ResultSet result1 = null;
		try {
			
		result1 = comando.executeQuery("SELECT * FROM MedicoLab WHERE CRML = "
					+ medicolab.CRML);
		
		String insert_medico = "INSERT INTO MedicoLab VALUES ("
				+ medicolab.CRML + ",'" + medicolab.nome + "','"
				+ medicolab.email + "','" + medicolab.telefone + "')";

		if (medicolab.CRML != 0 && !result1.next()) {
			System.out.println("entrou aqui");
			conectar();
			comando.executeUpdate(insert_medico);
			showMedlab();
		} else {
			System.out.println("entrou erro");
			Erro();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void createMedlab() {
		render();
	}

	public static void Erro() {
		render();
	}
	
}
