package daos;

import java.sql.SQLException;

public interface IDaoUsuario {

	private static void conectar();

	public static void doCreateUser(Usuarios usuarios);

	public static void createUser();

	public static void Erro();

}
