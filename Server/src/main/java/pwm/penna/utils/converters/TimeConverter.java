package pwm.penna.utils.converters;

import java.util.Map;

import org.apache.struts2.conversion.TypeConversionException;
import org.apache.struts2.util.StrutsTypeConverter;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * l'ho creato perchè hibernate converte "hh:mm:ss" in tipo Time e la conversione di tipo non avviene
 * in modo "automatico" in struts, ovvero viene restituta una stringa invece che un tipo Time nei campi
 * al cui interno c'è un tempo, quindi con questo faccio la conversione
 * 
 * documentazione su: https://struts.apache.org/core-developers/type-conversion
 */

@SuppressWarnings("rawtypes")
public class TimeConverter extends StrutsTypeConverter {
    private static final String TIME_FORMAT = "HH:mm";
    
    //da una stringa "hh:mm" prende e la converte in Time
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
        String timeString = values[0];
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        try {
            long ms = sdf.parse(timeString).getTime();
            return new Time(ms);
        } catch (ParseException e) {
            throw new TypeConversionException("Invalid time format");
        }
	}

    //da un Time prende e lo converte in stringa "hh:mm"
	@Override
	public String convertToString(Map context, Object o) {
        if (o instanceof Time) {
            Time time = (Time) o;
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
            return sdf.format(time);
        }
		return null;
	}
}
