package com.mycompany.pico_y_placa;
//paquetes auxiliares
import Soporte.Entidades.Picoplaca;
import Soporte.Entidades.Operator_Pre;
import Soporte.Entidades.Time_Str;
import Soporte.Entidades.Calendario.licDay;
//recursos nativos
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author AlexeiRamos
 */
public class Aplicativo {
    public void auth_PP(Operator_Pre prediccion) {
	System.out.println(prediccion.toString());
	Picoplaca picoPlacaValidacion = check_PP(prediccion);
	System.out.println(prediccion.result_build());
	if (picoPlacaValidacion != null) {
            System.out.println("\nEl horario " + picoPlacaValidacion.toString());
	}
    }

    private Picoplaca check_PP(Operator_Pre prediccion) {
        Picoplaca picoPlacaValidacion = null;
        for (Picoplaca picoPlaca : schedule_Hour_PP()) {
            picoPlacaValidacion = picoPlaca.estaEnPicoPlaca(prediccion.getW_Day(), prediccion.getDate_Hour(),
            prediccion.last_lic_num());
            if (picoPlacaValidacion == null) {
                prediccion.setDrive_allow(Boolean.TRUE);
            } else {
                prediccion.setDrive_allow(Boolean.FALSE);
                break;
            }
	}
	return picoPlacaValidacion;
    }

    private static List<Picoplaca> schedule_Hour_PP() {
	Time_Str horario = new Time_Str();
	List<Picoplaca> PP_day_l = new ArrayList<>();
	PP_day_l.add(new Picoplaca(1, licDay.L, horario.getDay_time(), "1"));
	PP_day_l.add(new Picoplaca(2, licDay.L, horario.getNight_time(), "1"));
	PP_day_l.add(new Picoplaca(3, licDay.L, horario.getDay_time(), "2"));
	PP_day_l.add(new Picoplaca(4, licDay.L, horario.getNight_time(), "2"));

	PP_day_l.add(new Picoplaca(5, licDay.M, horario.getDay_time(), "3"));
	PP_day_l.add(new Picoplaca(6, licDay.M, horario.getNight_time(), "3"));
	PP_day_l.add(new Picoplaca(7, licDay.M, horario.getDay_time(), "4"));
	PP_day_l.add(new Picoplaca(8, licDay.M, horario.getNight_time(), "4"));

	PP_day_l.add(new Picoplaca(9, licDay.MI, horario.getDay_time(), "5"));
	PP_day_l.add(new Picoplaca(10, licDay.MI, horario.getNight_time(), "5"));
	PP_day_l.add(new Picoplaca(11, licDay.MI, horario.getDay_time(), "6"));
	PP_day_l.add(new Picoplaca(12, licDay.MI, horario.getNight_time(), "6"));

	PP_day_l.add(new Picoplaca(13, licDay.J, horario.getDay_time(), "7"));
	PP_day_l.add(new Picoplaca(14, licDay.J, horario.getNight_time(), "7"));
	PP_day_l.add(new Picoplaca(15, licDay.J, horario.getDay_time(), "8"));
	PP_day_l.add(new Picoplaca(16, licDay.J, horario.getNight_time(), "8"));

	PP_day_l.add(new Picoplaca(17, licDay.V, horario.getDay_time(), "9"));
	PP_day_l.add(new Picoplaca(18, licDay.V, horario.getNight_time(), "9"));
	PP_day_l.add(new Picoplaca(19, licDay.V, horario.getDay_time(), "0"));
	PP_day_l.add(new Picoplaca(20, licDay.V, horario.getNight_time(), "0"));

	return PP_day_l;
    }

	/**
	 * 
	 */
    public Aplicativo() {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String license;
	String date_u;
	String hour_u;
        //lectura de datos ingresados por interfaz
	Scanner sc = new Scanner(System.in);
	System.out.println("Predictor Pico y Placa");
	System.out.println("Por favor ingrese los datos solicitados y presione enter para continuar.");
        System.out.println("IMPORTANTE: Seguir el formato presentado en los ejemplos de cada campo.");
	System.out.println("Formato: letras-números\nEjemplo: PCB-1234\nNúmero de Placa: ");
	license = sc.nextLine();
	System.out.println("Formato: día-mes-año\nEjemplo N°1: 26-05-2021\nEjemplo N°2: 05-06-2021\nFecha de circulación: ");
	date_u = sc.nextLine();
	System.out.println("Formato: hora-minutos\nEjemplo N°1: 08:45\nEjemplo N°2: 17:35\nHora de circulación: ");
	hour_u = sc.nextLine();
	sc.close();
        //llamada a predictor y envio de datos
	Operator_Pre prediccion = new Operator_Pre();
	prediccion.setLicense(license);
	prediccion.setDate_check(date_u);
	prediccion.setHour_check(hour_u);
	//llamada a nueva instancia de aplicativo y verificacion pico y placa
	Aplicativo app = new Aplicativo();
	app.auth_PP(prediccion);
    }
}
