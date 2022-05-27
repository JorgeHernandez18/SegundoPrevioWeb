package co.empresa.bancoBBVA.modelo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

	private Integer id;
	private Date date_bill;
	private Usuario user_Id;
	
	
}
