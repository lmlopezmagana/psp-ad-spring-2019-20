package csv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Persona {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	
	

}
