package Soporte.Entidades;
//recursos nativos
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
/**
 *
 * @author AlexeiRamos
 */
public class Operator_Pre {
    private String license;
    private String date_check;
    private String hour_check;
    private boolean drive_allow;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getDate_check() {
        return date_check;
    }

    public void setDate_check(String date_check) {
        this.date_check = date_check;
    }

    public String getHour_check() {
        return hour_check;
    }

    public void setHour_check(String hour_check) {
        this.hour_check = hour_check;
    }

    public boolean isDrive_allow() {
        return drive_allow;
    }

    public void setDrive_allow(boolean drive_allow) {
        this.drive_allow = drive_allow;
    }

    public String last_lic_num() {
        if (license == null || license.isEmpty()) {
            return null;
        }
        final int lic_leng = license.length();
        return license.substring(lic_leng - 1, lic_leng);
    }

    public Calendar getDate_Hour() {
        SimpleDateFormat dt_format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Calendar date_cal = null;
        try {
            dt_format.parse(date_check + " " + hour_check);
            date_cal = Calendar.getInstance();
            date_cal.setTime(dt_format.parse(date_check + " " + hour_check));
        } catch (ParseException ex) {
            Logger.getLogger(Operator_Pre.class.getName()).log(Level.SEVERE, null, ex);
	}
        return date_cal;
    }

    public int getW_Day() {
        return getDate_Hour().get(Calendar.DAY_OF_WEEK);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nSe verifica si el vehículo con placa: ");
        builder.append(license);
        builder.append(" podrá circular en la fecha: ");
        builder.append(date_check);
        builder.append(" a las: ");
        builder.append(hour_check);
        builder.append(" horas");
        return builder.toString();
    }

    public String result_build() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nEl vehículo ");
        builder.append(drive_allow ? "si" : "no");
        builder.append(" puede circular.");
        return builder.toString();
    }
}
