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
import controllers; 

public class DaoPaciente extends Controller {
	
	private static Connection con;
	private static Statement comando;

	private static void conectar() {

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
	
	public static void doCreatePaciente(Paciente paciente) {
		conectar();
		ResultSet result1 = null;
		try {
			
		result1 = comando.executeQuery("SELECT * FROM Paciente WHERE ID = "
					+ paciente.ID);
		
		String insert_paciente = "INSERT INTO Paciente VALUES (" + paciente.ID
				+ ",'" + paciente.nome + "','" + paciente.endereco + "','"
				+ paciente.email + "','" + paciente.telefone + "','"
				+ paciente.sexo + "','" + paciente.datanasc + "','"
				+ paciente.estadocivil + "','" + paciente.cpf + "','"
				+ paciente.rg + "','" + paciente.observacoes + "')";

			if (paciente.ID != 0 && !result1.next()) {
				System.out.println("entrou aqui");
				conectar();
				comando.executeUpdate(insert_paciente);
				showPaciente();
			} else {
				System.out.println("entrou erro");
				Erro();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void createPaciente() {
		render();
	}
	
	public static void doDeletePaciente(Paciente paciente) {
		conectar();
		String remove_paciente = "DELETE FROM Paciente WHERE ID = " + paciente.ID + ";";
		try {
			comando.executeUpdate(remove_paciente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		showPaciente();
	}
	
	public static void deletePaciente() {
		render();
	}

	public static void doEditPaciente(Paciente paciente) {
		conectar();
		ResultSet result1 = null;
		try {
			
		result1 = comando.executeQuery("SELECT * FROM Paciente WHERE ID = "
					+ paciente.ID);
		
		String insert_paciente = "UPDATE Paciente SET nome='" + paciente.nome
				+ "',endereco='" + paciente.endereco + "',email='"
				+ paciente.email + "',telefone='" + paciente.telefone
				+ "',sexo='" + paciente.sexo + "',datanasc='"
				+ paciente.datanasc + "',estadocivil='" + paciente.estadocivil
				+ "',cpf=" + paciente.cpf + ",rg=" + paciente.rg
				+ ",observacoes='" + paciente.observacoes + "' WHERE ID="
				+ paciente.ID + "";
			if (paciente.ID != 0 && !result1.next()) {
				System.out.println("entrou aqui");
				conectar();
				comando.executeUpdate(insert_paciente);
				showPaciente();
			} else {
				System.out.println("entrou erro");
				Erro();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		showPaciente();
	}

	public static void editPaciente() {
		render();
	}
	
	public static void showPaciente() {

		conectar();
		List<Paciente> list_paciente = new ArrayList<Paciente>();
		ResultSet result;

		try {
			result = comando.executeQuery("select * from Paciente");
			while (result.next()) {
				Paciente le = new Paciente();
				le.setID(result.getInt("ID"));
				le.setNome(result.getString("nome"));
				le.setEndereco(result.getString("endereco"));
				le.setEmail(result.getString("email"));
				le.setTelefone(result.getString("telefone"));
				le.setSexo(result.getString("sexo"));
				le.setDatanasc(result.getString("datanasc"));
				le.setEstadocivil(result.getString("estadocivil"));
				le.setCpf(result.getInt("cpf"));
				le.setRg(result.getInt("rg"));
				le.setObservacoes(result.getString("observacoes"));
				list_paciente.add(le);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		render(list_paciente);

	}
	
	public static void Erro() {
		render();
	}

	public static void showPaciente_RG(String RG) {
		conectar();
		List<Paciente> list_paciente = new ArrayList<Paciente>();
		ResultSet result;
	
		try {
			result = comando.executeQuery("SELECT * FROM Paciente WHERE RG = '"
					+ RG + "'");
			while (result.next()) {
				Paciente le = new Paciente();
				le.setID(result.getInt("ID"));
				le.setNome(result.getString("nome"));
				le.setEndereco(result.getString("endereco"));
				le.setEmail(result.getString("email"));
				le.setTelefone(result.getString("telefone"));
				le.setSexo(result.getString("sexo"));
				le.setDatanasc(result.getString("datanasc"));
				le.setEstadocivil(result.getString("estadocivil"));
				le.setCpf(result.getInt("cpf"));
				le.setRg(result.getInt("rg"));
				le.setObservacoes(result.getString("observacoes"));
				list_paciente.add(le);
	
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		render(list_paciente);
	}
	
	public static void showPaciente_CPF(String CPF) {
		conectar();
		List<Paciente> list_paciente = new ArrayList<Paciente>();
		ResultSet result;
		
		try {
			result = comando.executeQuery("SELECT * FROM Paciente WHERE CPF = '"
					+ CPF + "'");
			while (result.next()) {
				Paciente le = new Paciente();
				le.setID(result.getInt("ID"));
				le.setNome(result.getString("nome"));
				le.setEndereco(result.getString("endereco"));
				le.setEmail(result.getString("email"));
				le.setTelefone(result.getString("telefone"));
				le.setSexo(result.getString("sexo"));
				le.setDatanasc(result.getString("datanasc"));
				le.setEstadocivil(result.getString("estadocivil"));
				le.setCpf(result.getInt("cpf"));
				le.setRg(result.getInt("rg"));
				le.setObservacoes(result.getString("observacoes"));
				list_paciente.add(le);
	
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		render(list_paciente);
	}
	
	public static void showEmail_Paciente(int ID) {

		conectar();
		List<String> list_email = new ArrayList<String>();
		ResultSet result;
	
		try {
			result = comando
					.executeQuery("SELECT email FROM Paciente WHERE ID = " + ID);
			while (result.next()) {
				String le = new String();
				le = (result.getString("email"));
				list_email.add(le);
	
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		render(list_email);
	}

	public static void buscarPacienteCPF() {
		render();
	}
	
	public static void buscarPacienteRG() {
		  render ();
	}
	
	public static void buscarEmailPaciente() {
		  render();
	}
}