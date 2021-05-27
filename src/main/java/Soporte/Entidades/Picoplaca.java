package Soporte.Entidades;
//paquetes auxiliares
import Soporte.Entidades.Calendario.licDay;
//recursos nativos
import java.util.Calendar;
/**
 *
 * @author AlexeiRamos
 */
public class Picoplaca {
    private int id;
    private licDay lic_day;
    private Time_Str time_str;
    private String last_licnum;
        
    public Picoplaca(int id, licDay lic_day, Time_Str time_str, String last_licnum) {
	this.id = id;
	this.lic_day = lic_day;
	this.time_str = time_str;
	this.last_licnum = last_licnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public licDay getLic_day() {
        return lic_day;
    }

    public void setLic_day(licDay lic_day) {
	this.lic_day = lic_day;
    }

    public Time_Str getTime_str() {
	return time_str;
    }

    public void setTime_str(Time_Str time_str) {
	this.time_str = time_str;
    }

    public String getLast_licnum() {
	return last_licnum;
    }

    public void setLast_licnum(String last_licnum) {
	this.last_licnum = last_licnum;
    }

    @Override
    public String toString() {
	return "de pico y placa para el " + lic_day.getNameDay() + " es vigente " + time_str.getBody();
    }

    public Picoplaca estaEnPicoPlaca(int dia, Calendar hora, String ultimoDigito) {
	if (dia == this.getLic_day().getNumDay() && this.getLast_licnum().equals(ultimoDigito) && this.getTime_str().PP_bool(this.getTime_str(), hora)) {
            return this;
        }
        return null;
    }
}
