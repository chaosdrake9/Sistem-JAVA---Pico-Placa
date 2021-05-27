package Soporte.Entidades;
//recursos nativos
import java.util.Calendar;
/**
 *
 * @author AlexeiRamos
 */
public class Time_Str {
    private int id;
    private String body;
    private Calendar start_hour;
    private Calendar end_hour;

    public Time_Str() {
	super();
    }

    public Time_Str(int id, String body, Calendar start_hour, Calendar end_hour) {
	this.id = id;
	this.body = body;
	this.start_hour = start_hour;
	this.end_hour = end_hour;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getBody() {
	return body;
    }

    public void setBody(String body) {
	this.body = body;
    }

    public Calendar getStart_hour() {
	return start_hour;
    }

    public void setStart_hour(Calendar start_hour) {
	this.start_hour = start_hour;
    }

    public Calendar getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(Calendar end_hour) {
	this.end_hour = end_hour;
    }

    public boolean PP_bool(Time_Str time_str, Calendar hour) {
	Calendar start_hour = Calendar.getInstance();
	start_hour.setTime(hour.getTime());
	start_hour.set(Calendar.HOUR_OF_DAY, time_str.getStart_hour().get(Calendar.HOUR_OF_DAY));
	start_hour.set(Calendar.MINUTE, time_str.getStart_hour().get(Calendar.MINUTE));
	start_hour.set(Calendar.SECOND, 0);

	Calendar end_hour = Calendar.getInstance();
	end_hour.setTime(hour.getTime());
	end_hour.set(Calendar.HOUR_OF_DAY, time_str.getEnd_hour().get(Calendar.HOUR_OF_DAY));
	end_hour.set(Calendar.MINUTE, time_str.getEnd_hour().get(Calendar.MINUTE));
	end_hour.set(Calendar.SECOND, 0);

	return (hour.compareTo(start_hour) >= 0 && hour.compareTo(end_hour) <= 0);
    }

    public Time_Str getNight_time() {
	Calendar start_hour = Calendar.getInstance();
	start_hour.set(Calendar.HOUR_OF_DAY, 16);
	start_hour.set(Calendar.MINUTE, 0);
	start_hour.set(Calendar.SECOND, 0);

	Calendar end_hour = Calendar.getInstance();
	end_hour.set(Calendar.HOUR_OF_DAY, 19);
	end_hour.set(Calendar.MINUTE, 30);
	end_hour.set(Calendar.SECOND, 0);

	return new Time_Str(1, "De 16:00 a 19:30", start_hour, end_hour);
    }

    public Time_Str getDay_time() {
	Calendar start_hour = Calendar.getInstance();
	start_hour.set(Calendar.HOUR_OF_DAY, 7);
	start_hour.set(Calendar.MINUTE, 0);
	start_hour.set(Calendar.SECOND, 0);

	Calendar end_hour = Calendar.getInstance();
	end_hour.set(Calendar.HOUR_OF_DAY, 9);
	end_hour.set(Calendar.MINUTE, 30);
	end_hour.set(Calendar.SECOND, 0);

	return new Time_Str(2, "De 07:00 a 09:30", start_hour, end_hour);
    }
}
