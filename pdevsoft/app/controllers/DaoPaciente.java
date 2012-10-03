package controllers;

import play.*;
import play.mvc.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.persistence.Id;

import models.*;

public class DaoPaciente extends Controller {

	public static void doCreatePaciente(Paciente paciente) {
		conectar();
		String insert_paciente = "INSERT INTO Paciente VALUES (" + paciente.ID
				+ ",'" + paciente.nome + "','" + paciente.endereco + "','"
				+ paciente.email + "','" + paciente.telefone + "','"
				+ paciente.sexo + "','" + paciente.datanasc + "','"
				+ paciente.estadocivil + "','" + paciente.cpf + "','"
				+ paciente.rg + "','" + paciente.observacoes + "')";
		try {
			comando.executeUpdate(insert_paciente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		showPaciente();
	}

	public static void doDeletePaciente(Paciente paciente) {
		conectar();
		String remove_paciente = "DELETE FROM Paciente WHERE ID = "
				+ paciente.ID + ";";
		try {
			comando.executeUpdate(remove_paciente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		showPaciente();
	}

	public static void doEditPaciente(Paciente paciente) {
		conectar();
		String insert_paciente = "UPDATE Paciente SET nome='" + paciente.nome
				+ "',endereco='" + paciente.endereco + "',email='"
				+ paciente.email + "',telefone='" + paciente.telefone
				+ "',sexo='" + paciente.sexo + "',datanasc='"
				+ paciente.datanasc + "',estadocivil='" + paciente.estadocivil
				+ "',cpf=" + paciente.cpf + ",rg=" + paciente.rg
				+ ",observacoes='" + paciente.observacoes + "' WHERE ID="
				+ paciente.ID + "";
		try {
			comando.executeUpdate(insert_paciente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		showPaciente();
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

	public static void editPaciente() {
		render();
	}
	
	public static void deletePaciente() {
		render();
	}

}
