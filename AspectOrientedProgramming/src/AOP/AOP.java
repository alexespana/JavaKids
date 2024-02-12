package AOP;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOP {
	@Before("execution(* informarTiempoBarcelona())")
	public void informarFechaYHora()
	{
		// Format: AA/MM/DD Horas Minutos Segundos
		System.out.print("Informando de la fecha y hora =>");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
		System.out.println(fmt.format(LocalDateTime.now()) + ". ");
	}
}
