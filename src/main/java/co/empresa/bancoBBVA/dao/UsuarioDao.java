package co.empresa.bancoBBVA.dao;

import java.sql.SQLException;

import co.empresa.bancoBBVA.modelo.Usuario;

public interface UsuarioDao {

	public void login(String username, String pass) throws SQLException;
}
