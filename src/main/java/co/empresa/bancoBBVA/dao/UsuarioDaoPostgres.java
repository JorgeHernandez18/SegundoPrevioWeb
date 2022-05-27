package co.empresa.bancoBBVA.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.empresa.bancoBBVA.modelo.Usuario;
import co.empresa.bancoBBVA.util.Conexion;

public class UsuarioDaoPostgres implements UsuarioDao{

	private Conexion conexion;
	
	private static final String SELECT_USUARIO_SQL_BY_CREDENTIAL = "SELECT username,pass FROM user WHERE username = ? AND pass = ?;";
	
	public UsuarioDaoPostgres() {
		this.conexion = Conexion.getConexion();
	}
	
	
	@Override
	public void login(String username, String pass) throws SQLException {
		Usuario usuario = null;
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_USUARIO_SQL_BY_CREDENTIAL);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				username = rs.getString("username");
				pass = rs.getString("pass");
				usuario = (new Usuario(username, pass));
			}
			
		} catch (SQLException e) {
			
		}		
	}
	
}
