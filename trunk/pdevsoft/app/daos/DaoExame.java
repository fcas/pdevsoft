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


public class DaoExame implements IDaoExame {
	private static Connection con;
	private static Statement comando;

	private void conectar() {
		
		try {
			con = ConnectMySQL.conexao("jdbc:mysql://localhost/eplay", "eplay",
					"eplay", MySQLDAOFactory.MYSQL);
			comando = con.createStatement();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarExame (Exame exame) {
	
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
		try {
					
			conectar();
			comando.executeUpdate(insert_exame);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void editarExame(Exame exame) {
		
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
		try {	
			conectar();
			comando.executeUpdate(insert_exame);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void apagarExame(int ID) {
		
		String remove_exame = "DELETE FROM ExameLaudo WHERE ID = "
				+ ID + ";";
		try {	
			conectar();
			comando.executeUpdate(remove_exame);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Exame> listarExames() {

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
			e.printStackTrace();
		}

		return list_exame;

	}

	public List<Exame> buscarExame_DataPrometida(String data) {
		
		List<Exame> list = new ArrayList<Exame>();
		ResultSet result = null;

		try {
			conectar();
			result = comando.executeQuery("SELECT * FROM ExameLaudo WHERE dataentrega = "
							+ data+";");
			System.out.println("FIZ A CONSULTA DE DATA");
		
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
				System.out.println("ID DE UM DOS ITENS DA LISTA: " + le.getID());
				list.add(le);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Exame> buscarExame_Situacao(String situacao) {
		
		ResultSet result = null;
		List<Exame> list = new ArrayList<Exame>();
		
		try {
			conectar();
			result = comando
					.executeQuery("SELECT * FROM ExameLaudo WHERE situacao = "
							+ "'"+situacao+"'"+";");

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
				list.add(le);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Exame buscarExame_ID(int ID) {
		System.out.println("ENTREI NA BUSCA!!!!!! ID = " + ID);
		ResultSet result = null;
		Exame le = new Exame();
		
		try {
			conectar();
			result = comando
					.executeQuery("SELECT * FROM ExameLaudo WHERE ID = "
							+ ID+ ";");
			if (result.next()) {
				System.out.println("SETANDO EXAME NA BUSCA");
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
				System.out.println("ID SETADO = "+le.getID());
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return le;
	}
	
	public List<Exame> buscarUltimosExames () {

		List<Exame> list_exame = new ArrayList<Exame>();
		ResultSet result = null;

		try {
			conectar();
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
			e.printStackTrace();
		}

		return list_exame;
		
	}
	
//	public List<Exame> showExamesEntregues () {
//
//		List<Exame> list_exame = new ArrayList<Exame>();
//		ResultSet result = null;
//
//		try {
//			conectar();
//			result = comando.executeQuery("select * from examesEntregues");
//			while (result.next()) {
//				Exame le = new Exame();
//				le.setID(result.getInt("ID"));
//				System.out.println(result.getInt("ID"));
//				le.setID_material(result.getInt("ID_material"));
//				le.setSituacao(result.getString("situacao"));
//				le.setDatarec(result.getString("datarec"));
//				le.setDataentrega(result.getString("dataentrega"));
//				le.setID_paciente(result.getInt("ID_paciente"));
//				le.setCRMR(result.getInt("CRMR"));
//				le.setCRML(result.getInt("CRML"));
//				le.setResultado(result.getString("resultado"));
//				le.setAnalise_macro(result.getString("analise_macro"));
//				le.setObservacoes(result.getString("observacoes"));
//				list_exame.add(le);
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return list_exame;
//		
//	}
//	
//	public List<Exame> showExamesNaoEntregues () {
//
//		List<Exame> list_exame = new ArrayList<Exame>();
//		ResultSet result = null;
//
//		try {
//			conectar();
//			result = comando.executeQuery("select * from examesNaoEntregues");
//			while (result.next()) {
//				Exame le = new Exame();
//				le.setID(result.getInt("ID"));
//				System.out.println(result.getInt("ID"));
//				le.setID_material(result.getInt("ID_material"));
//				le.setSituacao(result.getString("situacao"));
//				le.setDatarec(result.getString("datarec"));
//				le.setDataentrega(result.getString("dataentrega"));
//				le.setID_paciente(result.getInt("ID_paciente"));
//				le.setCRMR(result.getInt("CRMR"));
//				le.setCRML(result.getInt("CRML"));
//				le.setResultado(result.getString("resultado"));
//				le.setAnalise_macro(result.getString("analise_macro"));
//				le.setObservacoes(result.getString("observacoes"));
//				list_exame.add(le);
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return list_exame;
//		
//	}
	
}
