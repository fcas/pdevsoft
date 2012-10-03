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

public class Application extends Controller {

	private static Connection con;
	private static Statement comando;

	private static void conectar() {

		try {
			con = ConFactory.conexao("jdbc:mysql://localhost/eplay", "eplay",
					"eplay", ConFactory.MYSQL);
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

	public static void logout() {
		session.remove("login");
		index();
	}


	public static void doCreateUser(Usuarios usuarios) {

		conectar();
		String insert_usuario = "INSERT INTO Usuarios VALUES ('"
				+ usuarios.username + "','" + usuarios.password + "')";
		try {
			comando.executeUpdate(insert_usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
		
	
	
	public static void showExame() {

		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM Exame ORDER BY dataentrega");
			while (result.next()) {
				Exame le = new Exame();
				le.setID(result.getInt("ID"));
				le.setID_material(result.getInt("ID_material"));
				le.setSituacao(result.getString("situacao"));
				le.setDatarec(result.getString("datarec"));
				le.setDataentrega(result.getString("dataentrega"));
				le.setID_paciente(result.getInt("ID_paciente"));
				le.setCRMR(result.getInt("CRMR"));
				le.setCRML(result.getInt("CRML"));
				le.setResultado(result.getString("resultado"));
				le.setAnalise_macro(result.getString("analise_macro"));
				le.setAnalise_micro(result.getString("analise_micro"));
				le.setObservacoes(result.getString("observacoes"));
				list_exame.add(le);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		render(list_exame);

	}

	// public static void showLaudo() {
	// conectar();
	// List<Laudo> list_laudo = new ArrayList<Laudo>();
	// ResultSet result;
	//
	// try {
	// result = comando.executeQuery("SELECT * FROM MedicoLab ORDER BY nome");
	// while (result.next()) {
	// Laudo le = new Laudo();
	// le.setID(result.getInt("ID"));
	// le.setAnalise_macro(result.getString("analise_macro"));
	// le.setAnalise_micro(result.getString("analise_micro"));
	// le.setResultado(result.getString("resultado"));
	// le.setID_paciente(result.getInt("ID_paciente"));
	// le.setCRML(result.getInt("CRML"));
	// }
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// render(list_laudo);
	// }

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

		render(list_medico);
	}

	public static void showExame_DataPrometida(String date) {
		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM examelaudo WHERE dataentrega = "
							+ date);
			while (result.next()) {
				Exame le = new Exame();
				le.setID(result.getInt("ID"));
				le.setID_material(result.getInt("ID_material"));
				le.setSituacao(result.getString("situacao"));
				le.setDatarec(result.getString("datarec"));
				le.setDataentrega(result.getString("dataentrega"));
				le.setID_paciente(result.getInt("ID_paciente"));
				le.setCRMR(result.getInt("CRMR"));
				le.setCRML(result.getInt("CRML"));
				le.setResultado(result.getString("resultado"));
				le.setAnalise_macro(result.getString("analise_macro"));
				le.setAnalise_micro(result.getString("analise_micro"));
				le.setObservacoes(result.getString("observacoes"));
				list_exame.add(le);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		render(list_exame);
	}

	public static void showExame_Situacao(String situacao) {
		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM examelaudo WHERE situacao = "
							+ situacao);
			while (result.next()) {
				Exame le = new Exame();
				le.setID(result.getInt("ID"));
				le.setID_material(result.getInt("ID_material"));
				le.setSituacao(result.getString("situacao"));
				le.setDatarec(result.getString("datarec"));
				le.setDataentrega(result.getString("dataentrega"));
				le.setID_paciente(result.getInt("ID_paciente"));
				le.setCRMR(result.getInt("CRMR"));
				le.setCRML(result.getInt("CRML"));
				le.setResultado(result.getString("resultado"));
				le.setAnalise_macro(result.getString("analise_macro"));
				le.setAnalise_micro(result.getString("analise_micro"));
				le.setObservacoes(result.getString("observacoes"));
				list_exame.add(le);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		render(list_exame);
	}

	public static void showMedreq_Exame(int ID) {
		conectar();
		List<MedicoReq> list_medico = new ArrayList<MedicoReq>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT m.CRMR, m.nome nome, m.email email, m.telefone telefone "
							+ "FROM medicoreq m INNER JOIN examelaudo e "
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

	public static void showExame_ID(int ID) {

		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando.executeQuery("SELECT * FROM Exame WHERE ID = "
					+ ID);
			while (result.next()) {
				Exame le = new Exame();
				le.setID(result.getInt("ID"));
				le.setID_material(result.getInt("ID_material"));
				le.setSituacao(result.getString("situacao"));
				le.setDatarec(result.getString("datarec"));
				le.setDataentrega(result.getString("dataentrega"));
				le.setID_paciente(result.getInt("ID_paciente"));
				le.setCRMR(result.getInt("CRMR"));
				le.setCRML(result.getInt("CRML"));
				le.setResultado(result.getString("resultado"));
				le.setAnalise_macro(result.getString("analise_macro"));
				le.setAnalise_micro(result.getString("analise_micro"));
				le.setObservacoes(result.getString("observacoes"));
				list_exame.add(le);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		render(list_exame);

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

	public static void showPaciente_CPF(Paciente paciente) {
		conectar();
		List<Paciente> list_paciente = new ArrayList<Paciente>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("select * from Paciente WHERE cpf = '"
							+ paciente.cpf + "'");
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


	public static void doCreateExame(Exame exame) {
		conectar();
		String insert_exame = "INSERT INTO examelaudo VALUES (" + exame.ID
				+ "," + exame.ID_material + ",'" + exame.situacao + "','"
				+ exame.datarec + "','" + exame.dataentrega + "',"
				+ exame.ID_paciente + "," + exame.CRMR + "," + exame.CRML + ","
				+ "NULL, NULL, NULL,'" + exame.observacoes + "')";
		try {
			comando.executeUpdate(insert_exame);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		showExame();
	}


	// public static void doCreateLaudo(Laudo laudo) {
	// conectar();
	// String insert_laudo = "INSERT INTO Laudo VALUES ("
	// + laudo.ID + ",'" + laudo.analise_macro + "','"
	// + laudo.analise_micro + "','" + laudo.resultado + "','"
	// + laudo.
	// + laudo.ID_paciente + "," + laudo.CRML + ")";
	// try {
	// comando.executeUpdate(insert_laudo);
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// createLaudo();
	// showLaudo();
	// }

	public static void doCreateMedlab(MedicoLab medicolab) {
		conectar();
		String insert_medico = "INSERT INTO MedicoLab VALUES ("
				+ medicolab.CRML + ",'" + medicolab.nome + "','"
				+ medicolab.email + "','" + medicolab.telefone + "')";

		try {
			comando.executeUpdate(insert_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}

		showMedlab();
	}

	public static void doCreateMedreq(MedicoReq medicoreq) {
		conectar();
		String insert_medico = "INSERT INTO MedicoReq VALUES ("
				+ medicoreq.CRMR + ",'" + medicoreq.nome + "','"
				+ medicoreq.email + "','" + medicoreq.telefone + "')";

		try {
			comando.executeUpdate(insert_medico);
		} catch (Exception e) {
			e.printStackTrace();
		}

		showMedreq();
	}

	public static void createPaciente() {
		render();
	}

	public static void createExame() {
		render();
	}

	public static void createLaudo() {
		render();
	}

	public static void createMedlab() {
		render();
	}

	public static void createMedreq() {
		render();
	}

	public static void createUser() {
		render();
	}


	public static void searchByCpf() {
		render();
	}

	

	public static void index_autenticado() {
		render();
	}

	public static void login(Usuarios usuarios) {
		index_autenticado();
	}



	public static void index() {
		render();
	}

	public static void main() {
		render();
	}
}