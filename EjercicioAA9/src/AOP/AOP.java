package AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOP {
	@Before("execution(* calcularGananciaTotal(..))")
	public void log()
	{
		System.out.println("Ejecutando antes de calcular la ganancia total.");
	}
}
