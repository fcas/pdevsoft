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


public class DaoMedicoRequisitante extends Controller {

	private static Connection con;
	private static Statement comando;

	public static void conectar() {

		DAOFactory factory;
		
		try {
			con = MySQLDAOFactory.conexao("jdbc:mysql://localhost/eplay", "eplay",
					"eplay", MySQLDAOFactory.MYSQL);
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
	
	public static void showMedreq() {

		conectar();
		List<MedicoReq> list_medico = new ArrayList<MedicoReq>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM MedicoReq ORDER BY nome");
			while (result.next()) {
				MedicoReq le = new MedicoReq();
				le.setCRMR(result.getInt("CRMR"));
				le.setNome(result.getString("observacoes"));
				le.setEmail(result.getString("situacao"));
				le.setTelefone(result.getString("datarec"));
				list_medico.add(le);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//render(list_medico);
		
	}

	public static void showMedreq_Exame(int ID) {
		conectar();
		List<MedicoReq> list_medico = new ArrayList<MedicoReq>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT m.CRMR, m.nome nome, m.email email, m.telefone telefone "
							+ "FROM medicoreq m INNER JOIN ExameLaudo e "
							+ "ON m.CRMR = e.CRMR " + "WHERE e.ID = " + ID);
			while (result.next()) {
				MedicoReq le = new MedicoReq();
				le.setCRMR(result.getInt("CRMR"));
				le.setNome(result.getString("observacoes"));
				le.setEmail(result.getString("situacao"));
				le.setTelefone(result.getString("datarec"));
				list_medico.add(le);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		render(list_medico);
	}
	
	public static void showMedico_Paciente(int ID) {
		conectar();
		List<MedicoReq> list_medico = new ArrayList<MedicoReq>();
		ResultSet result;
		
		try {
			result = comando
					.executeQuery("SELECT m.CRMR, m.nome, m.email, m.telefone"
							+ "FROM MedicoReq" + "WHERE CRMR IN("
							+ "SELECT e.CRMR"
							+ "FROM Exame e INNER JOIN Paciente p"
							+ "ON e.ID_paciente = p.ID" + "WHERE p.ID = " + ID);
			while (result.next()) {
				MedicoReq le = new MedicoReq();
				le.setCRMR(result.getInt("CRMR"));
				le.setNome(result.getString("observacoes"));
				le.setEmail(result.getString("situacao"));
				le.setTelefone(result.getString("datarec"));
				list_medico.add(le);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		render(list_medico);

	}
	
	public static void doCreateMedreq(MedicoReq medicoreq) {
		conectar();
		ResultSet result1 = null;
		try {
			
		result1 = comando.executeQuery("SELECT * FROM MedicoReq WHERE CRMR = "
					+ medicoreq.CRMR);
		String insert_medico = "INSERT INTO MedicoReq VALUES ("
				+ medicoreq.CRMR + ",'" + medicoreq.nome + "','"
				+ medicoreq.email + "','" + medicoreq.telefone + "')";

		if (medicoreq.CRMR != 0 && !result1.next()) {
			System.out.println("entrou aqui");
			conectar();
			comando.executeUpdate(insert_medico);
			showMedreq();
		} else {
			System.out.println("entrou erro");
			Erro();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void createMedreq() {
		render();
	}
	
	public static void buscarMedPacienteID() {
		render();
	}
	
	public static void buscarMedicoReqExameId() {
		  render ();
		 }
	
	public static void Erro() {
		render();
	}
	
}
