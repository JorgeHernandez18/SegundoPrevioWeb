package co.empresa.bancoBBVA.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	private Integer id;
	private String userName;
	private String pass;
	private String email;
	
	public Usuario(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}
	
	
}
