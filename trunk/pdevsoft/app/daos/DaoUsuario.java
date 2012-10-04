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

public class DaoUsuario extends Controller {
	
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

	public static void createUser() {
		render();
	}

	public static void Erro() {
		render();
	}
	
}
