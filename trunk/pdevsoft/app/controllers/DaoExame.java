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


public class DaoExame extends Controller {
	
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

	public static void showExame() {

		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM ExameLaudo ORDER BY dataentrega");
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

	public static void showExame_DataPrometida(String date) {
		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando
					.executeQuery("SELECT * FROM ExameLaudo WHERE dataentrega = "
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
					.executeQuery("SELECT * FROM ExameLaudo WHERE situacao = "
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
	
	public static void doCreateExame(Exame exame) {
		conectar();
		ResultSet result1 = null;
		ResultSet result2 = null;
		ResultSet result3 = null;
		ResultSet result4 = null;
		
		try {
			
		result1 = comando.executeQuery("SELECT * FROM ExameLaudo WHERE ID = "
					+ exame.ID);
		conectar();
		result2 = comando.executeQuery("SELECT * FROM Paciente WHERE ID = "
				+ exame.ID_paciente);
		conectar();
		result3 = comando.executeQuery("SELECT * FROM MedicoLab WHERE CRML = "
				+ exame.CRML);
		conectar();
		result4 = comando.executeQuery("SELECT * FROM MedicoReq WHERE CRMR = "
				+ exame.CRMR);
		
		String insert_exame = "INSERT INTO ExameLaudo VALUES ("
				+ exame.ID + "," 
				+ exame.ID_material + ",'" 
				+ exame.situacao + "','"
				+ exame.datarec + "','" 
				+ exame.dataentrega + "',"
				+ exame.ID_paciente + "," 
				+ exame.CRMR + "," 
				+ exame.CRML + ",'"
				+ exame.Resultado + "','"
				+ exame.Analise_macro + "','"
				+ exame.Analise_micro + "','"
				+ exame.observacoes + "')";
		
		
		if (exame.ID != 0 && !result1.next() && result2.next() && result3.next() && result4.next()) {
			System.out.println("entrou aqui");
			conectar();
			comando.executeUpdate(insert_exame);
			showExame();
		} else {
			System.out.println("entrou erro");
			Erro();
		}
		
			
	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void doEditExame(Exame exame) {
		conectar();
		ResultSet result1 = null;
		ResultSet result2 = null;
		ResultSet result3 = null;
		ResultSet result4 = null;
		
		try {
			
		result1 = comando.executeQuery("SELECT * FROM ExameLaudo WHERE ID = "
					+ exame.ID);
		conectar();
		result2 = comando.executeQuery("SELECT * FROM Paciente WHERE ID = "
				+ exame.ID_paciente);
		conectar();
		result3 = comando.executeQuery("SELECT * FROM MedicoLab WHERE CRML = "
				+ exame.CRML);
		conectar();
		result4 = comando.executeQuery("SELECT * FROM MedicoReq WHERE CRMR = "
				+ exame.CRMR);
		
		String insert_exame = "UPDATE ExameLaudo SET "
				+ "ID_material=" + exame.ID_material
				+ ",situacao='" + exame.situacao
				+ "',datarec='" + exame.datarec
				+ "',dataentrega='" + exame.dataentrega
				+ "',ID_paciente=" + exame.ID_paciente
				+ ",CRMR=" + exame.CRMR
				+ ",CRML=" + exame.CRML
				+ ",resultado='" + exame.Resultado
				+ "',analise_macro='" + exame.Analise_macro
				+ "',analise_micro='" + exame.Analise_micro
				+ "',observacoes='" + exame.observacoes
				+ "' WHERE ID=" + exame.ID;
		
		
		if (exame.ID != 0 && !result1.next() && result2.next() && result3.next() && result4.next()) {
			System.out.println("entrou aqui");
			conectar();
			comando.executeUpdate(insert_exame);
			showExame();
		} else {
			System.out.println("entrou erro");
			Erro();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createExame() {
		render();
	}
	
	public static void buscarExameID() {
		  render ();
		 }
	
	public static void buscarExameSituacao() {
		  render();
		 }
	
	public static void buscarexameDataEntrega () {
		  render();
		 }
	
	public static void editExame() {
		render();
	}
	
	public static void showUltimosExames () {

		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando.executeQuery("select * from ultimoExame");
			while (result.next()) {
				Exame le = new Exame();
				le.setID(result.getInt("ID"));
				System.out.println(result.getInt("ID"));
				le.setID_material(result.getInt("ID_material"));
				le.setSituacao(result.getString("situacao"));
				le.setDatarec(result.getString("datarec"));
				le.setDataentrega(result.getString("dataentrega"));
				le.setID_paciente(result.getInt("ID_paciente"));
				le.setCRMR(result.getInt("CRMR"));
				le.setCRML(result.getInt("CRML"));
				le.setResultado(result.getString("resultado"));
				le.setAnalise_macro(result.getString("analise_macro"));
				le.setObservacoes(result.getString("observacoes"));
				list_exame.add(le);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		render(list_exame);
		
	}
	
	public static void showExamesEntregues () {

		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando.executeQuery("select * from examesEntregues");
			while (result.next()) {
				Exame le = new Exame();
				le.setID(result.getInt("ID"));
				System.out.println(result.getInt("ID"));
				le.setID_material(result.getInt("ID_material"));
				le.setSituacao(result.getString("situacao"));
				le.setDatarec(result.getString("datarec"));
				le.setDataentrega(result.getString("dataentrega"));
				le.setID_paciente(result.getInt("ID_paciente"));
				le.setCRMR(result.getInt("CRMR"));
				le.setCRML(result.getInt("CRML"));
				le.setResultado(result.getString("resultado"));
				le.setAnalise_macro(result.getString("analise_macro"));
				le.setObservacoes(result.getString("observacoes"));
				list_exame.add(le);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		render(list_exame);
		
	}
	
	public static void showExamesNaoEntregues () {

		conectar();
		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result;

		try {
			result = comando.executeQuery("select * from examesNaoEntregues");
			while (result.next()) {
				Exame le = new Exame();
				le.setID(result.getInt("ID"));
				System.out.println(result.getInt("ID"));
				le.setID_material(result.getInt("ID_material"));
				le.setSituacao(result.getString("situacao"));
				le.setDatarec(result.getString("datarec"));
				le.setDataentrega(result.getString("dataentrega"));
				le.setID_paciente(result.getInt("ID_paciente"));
				le.setCRMR(result.getInt("CRMR"));
				le.setCRML(result.getInt("CRML"));
				le.setResultado(result.getString("resultado"));
				le.setAnalise_macro(result.getString("analise_macro"));
				le.setObservacoes(result.getString("observacoes"));
				list_exame.add(le);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		render(list_exame);
		
	}
	
	public static void Erro() {
		render();
	}
	
}
