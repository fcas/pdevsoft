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
import daos.*;

//LOGIN NÃO ESTÁ FUNCIONANDO
// A CRIACAO DO FACTORY E DOS DAO ESTÃO SENDO FEITOS EM INDEX
//NAO VAI DA PRA TESTAR USANDO O MENU PORQUE OS HTML TAO SEM REFERENCIA
//E SEM RENDER. FACAM ISSO DEPOIS DE AJEITAR AS OUTRAS COISAS QUE PRECISAREM
//NO CODIGO (ACHO QUE SO AS BUSCAS DOS MEDICOS), PORQUE A GENTE PRECISA TESTAR. 
//A PARTE DE USUARIO POR ENQUANTO NEM TA AQUI, PORQUE É O DE MENOS E É BEM
//MENOR QUE AS OUTRAS. ATENTEM PARA AS PASTAS DE VIEW, QUE TIVE QUE MUDAR O NOME
//PARA CONTROLLER PORQUE SE NÃO, NÃO FUNCIONA OS RENDER QUE VÃO ESTA NAS CLASSES CONTROLLER

public class Application extends Controller {
//
//	private static Connection con;
//	private static Statement comando;
//
//	private static void conectar() {
//
//		try {
//			con = MySQLDAOFactory.conexao("jdbc:mysql://localhost/eplay", "eplay",
//					"eplay", MySQLDAOFactory.MYSQL);
//			comando = con.createStatement();
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}	
////		System.out.println("Conectado!");
//
//	}

//	@Before(unless = {"index", "doCreateUser", "login"})
//	static void checkAutenticacao() throws SQLException {
//		if (!session.contains("login")) {
//			index();
//		}
//	}
//	
//	public static void login (Usuarios usuarios) {
//		
//		conectar();
//		ResultSet rs = null;
//		System.out.println(usuarios.username + ", " + usuarios.password);
//		try {
//			rs = comando.executeQuery("SELECT * FROM Usuarios WHERE username = '"
//					+ usuarios.username + "' AND password = '" + usuarios.password
//					+ "'");
//
//			
//			if (rs.next()) {
//				session.put("login", "ola");
//				System.out.println("ENTROU");
//			}
//			bemVindo();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void bemVindo () {
//		render();
//	}
//
//	public static void logout() {
//		session.remove("login");
//		index();
//	}
	
	public static void index() {
		DAOFactory factory = DAOFactory.createDAOFactory(0);
		IDaoPaciente daoPaciente = factory.createDaoPaciente();
		IDaoExame daoExame = factory.createDaoExame();
		IDaoMedLab daoMedLab = factory.createDaoMedicoLaboratorio();
		IDaoMedReq daoMedReq = factory.createDaoMedicoRequisitante();
		
		ControllerPaciente cpaciente = new ControllerPaciente(daoPaciente);
		System.out.println("CRIOU FACTORY E CONTROLLER");
		if (daoPaciente == null) {
			System.out.println("DAO PACIENTE NULOOOOOOOO");
		}
		ControllerExame cexame = new ControllerExame(daoExame, daoPaciente, daoMedLab, daoMedReq);
		ControllerMedico cmedico = new ControllerMedico (daoMedLab, daoMedReq);
		//ControllerUsuario cusuario = new ControllerUsuario(factory.createDaoUsuario());
				
		render();
	}

	public static void main() {
		render();
	}
	
}