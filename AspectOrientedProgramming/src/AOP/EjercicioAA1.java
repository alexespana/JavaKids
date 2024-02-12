package AOP;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EjercicioAA1 {

	public static void main(String[] args) throws IOException, ParseException {
		AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext(Configurator.class);
		Servicio servicio = ca.getBean(Servicio.class);
		servicio.informarTiempoBarcelona();
	}

}
