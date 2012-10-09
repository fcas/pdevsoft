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

public class DaoPaciente implements IDaoPaciente {

	private static Connection con;
	private static Statement comando;
	
	private void conectar() {

		try {
			con = ConnectMySQL.conexao("jdbc:mysql://localhost/eplay",
					"eplay", "eplay", MySQLDAOFactory.MYSQL);
			comando = con.createStatement();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("Conectado!");
	}

	public void criarPaciente(Paciente paciente) {
		
		String insert_paciente = "INSERT INTO Paciente VALUES ("
			+ paciente.ID + ",'" + paciente.nome + "','"
			+ paciente.endereco + "','" + paciente.email + "','"
			+ paciente.telefone + "','" + paciente.sexo + "','"
			+ paciente.datanasc + "','" + paciente.estadocivil + "','"
			+ paciente.cpf + "','" + paciente.rg + "','"
			+ paciente.observacoes + "')";
		
		try {
			conectar();
			comando.executeUpdate(insert_paciente);		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void apagarPaciente(int ID) {
		
		String remove_paciente = "DELETE FROM Paciente WHERE ID = "
				+ ID + ";";
		try {
			conectar();
			comando.executeUpdate(remove_paciente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editarPaciente(Paciente paciente) {
		
		String insert_paciente = "UPDATE Paciente SET nome='"
			+ paciente.nome + "',endereco='" + paciente.endereco
			+ "',email='" + paciente.email + "',telefone='"
			+ paciente.telefone + "',sexo='" + paciente.sexo
			+ "',datanasc='" + paciente.datanasc + "',estadocivil='"
			+ paciente.estadocivil + "',cpf=" + paciente.cpf + ",rg="
			+ paciente.rg + ",observacoes='" + paciente.observacoes
			+ "' WHERE ID=" + paciente.ID + "";
		
		try {	
			conectar();
			comando.executeUpdate(insert_paciente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Paciente buscarPaciente(int ID) {
		System.out.println("ENTREI AQUIIIIIIIIII");
		ResultSet result = null;
		Paciente le = new Paciente();
		
		try {
			conectar();
			result = comando.executeQuery("SELECT * FROM Paciente WHERE ID = "
					+ ID + ";");
			
			if (result.next()) { 
				System.out.println("ENTREI NO RESULT.NEXT");
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
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return le;
	}

	public Paciente buscarPacienteRG(String RG) {

		ResultSet result = null;
		Paciente le = new Paciente();

		try {
			conectar();
			result = comando.executeQuery("SELECT * FROM Paciente WHERE RG = '"
					+ RG + "';");
		
			if (result.next()) {
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
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return le;
		
	}
	
	public Paciente buscarPacienteCPF(String CPF) {
		ResultSet result = null;
		Paciente le = new Paciente();

		try {
			conectar();
			result = comando.executeQuery("SELECT * FROM Paciente WHERE CPF = '" + CPF
							+ "';");
		
			if (result.next()) {
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
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return le;
	}
}