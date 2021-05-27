package Soporte.Entidades.Calendario;
//recursos nativos
import java.util.Calendar;
/**
 *
 * @author AlexeiRamos
 */
public enum licDay {
    L(Calendar.MONDAY, "Lunes"), 
    M(Calendar.TUESDAY, "Martes"), 
    MI(Calendar.WEDNESDAY, "Miercoles"), 
    J(Calendar.THURSDAY, "Jueves"), 
    V(Calendar.FRIDAY, "Viernes");
    
    private int numDay;
    private String nameDay;

    public int getNumDay() {
        return numDay;
    }

    public void setNumDay(int numDay) {
        this.numDay = numDay;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    private licDay(int numDay, String nameDay) {
        this.numDay = numDay;
        this.nameDay = nameDay;
    }
}
