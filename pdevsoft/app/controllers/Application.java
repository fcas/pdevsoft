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
public class Application extends Controller {

	private static Connection con;
	private static Statement comando;

	private static void conectar() {

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

	@Before(unless = {"index", "doCreateUser", "login"})
	static void checkAutenticacao() throws SQLException {
		if (!session.contains("login")) {
			index();
		}
	}
	
	public static void login (Usuarios usuarios) {
		
		conectar();
		ResultSet rs = null;
		System.out.println(usuarios.username + ", " + usuarios.password);
		try {
			rs = comando.executeQuery("SELECT * FROM Usuarios WHERE username = '"
					+ usuarios.username + "' AND password = '" + usuarios.password
					+ "'");

			
			if (rs.next()) {
				session.put("login", "ola");
				System.out.println("ENTROU");
			}
			bemVindo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void bemVindo () {
		render();
	}

	public static void logout() {
		session.remove("login");
		index();
	}

	public static void Erro() {
		render();
	}
	
	public static void index() {
		DaoFactory factory = factory.createDaoFactory(0);
		ControllerPaciente cpaciente = new ControllerPaciente(factory.createDaoPaciente());
		ControllerExame cexame = new ControllerExame(factory.createDaoExame());
		ControllerMedico cmedico = new ControllerMecido (factory.createDaoMedicoLaboratorio(), factory.createDaoMedicoRequisitante());
		ControllerUsuario cusuario = new ControllerUsuario(factory.createDaoUsuario());
				
		render();
	}

	public static void main() {
		render();
	}
	
}