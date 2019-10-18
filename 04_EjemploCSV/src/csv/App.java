package csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Inspirado en el ejemplo de https://dzone.com/articles/how-to-read-a-big-csv-file-with-java-8-and-stream
 * 
 * @author luismi
 *
 */
public class App {
	
	private static final  String DELIMITADOR = ",";
	private static final  int C_ID = 0;
	private static final  int C_NOMBRE = 1;
	private static final  int C_APELLIDOS = 2;
	private static final  int C_EMAIL = 3;
	

	public static void main(String[] args) {
		
		try {
			List<Persona> resultado = procesaCsvPersonas("MOCK_DATA.csv", true);
			
			resultado.stream()
				.limit(100)
				.forEach(System.out::println);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static List<Persona> procesaCsvPersonas(String fichero, boolean skipHeaders) throws IOException {
		return Files
			.lines(Paths.get(fichero))
			.skip(skipHeaders ? 1 : 0)
			.map(App::mapToPersona)
			.collect(Collectors.toList());
	}
	
	public static Persona mapToPersona(String linea) {
		String[] datos = linea.split(DELIMITADOR);
		
		return Persona.builder()
				.id(Integer.valueOf(datos[C_ID]))
				.nombre(datos[C_NOMBRE])
				.apellidos(datos[C_APELLIDOS])
				.email(datos[C_EMAIL])
				.build();
		
	}
}
