package AOP;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class VueloAerolinea {
	public double calcularGananciaTotal(List<Vuelo> vuelos) {
		double gananciaTotal = 0;
		
		for(int i=0; i<vuelos.size(); i++) {
			gananciaTotal += vuelos.get(i).calcularAsistenciaPasajeros();
		}
		
		return gananciaTotal;
	}
}
