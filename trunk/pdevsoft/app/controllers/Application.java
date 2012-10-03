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
//LOGIN NÃO ESTÁ FUNCIONANDO
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

	public static void doCreateUser (Usuarios usuarios) {
		
		conectar();
		String insert_usuario = "INSERT INTO Usuarios VALUES ('" +usuarios.username + "','"
				+ usuarios.password + "')";
		try {
			comando.executeUpdate(insert_usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		render();
	}

	public static void createLaudo() {
		render();
	}

	public static void createUser() {
		render();
	}
	
	public static void buscarMedPacienteID() {
		  render();
		 }

	public static void Erro() {
		render();
	}
	
	public static void index() {
		render();
	}

	public static void main() {
		render();
	}
	
}