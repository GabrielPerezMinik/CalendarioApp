package dad.calendario;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class GeneradorDeDias {

	public static int conseguirPrimerDia(int anio, int mes) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(anio, mes-1, 1);
		int dia = calendario.get(Calendar.DAY_OF_WEEK);
		if (dia == 1) {
			return 7;
		}
		return dia-1;
	}
	
	public static int conseguirUltimoDia(int anio, int mes) {
		LocalDate primero = LocalDate.of(anio, mes, 1);
		return primero.plusMonths(1).minusDays(1).getDayOfMonth();
	}
	
	public static Date Fecha(int anio, int mes, int dia) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(anio, mes-1, 1);
		return calendario.getTime();
	}

	
}
