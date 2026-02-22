package pwm.penna.utils.converters;

import java.util.Map;

import org.apache.struts2.conversion.TypeConversionException;
import org.apache.struts2.util.StrutsTypeConverter;

import java.math.BigDecimal;

/*
 * le colonne con tipo DECIMAL hibernate le converte in BigDecimal però non supporta una vera e propria
 * conversione ad esempio 1234,56 lo converte in 123456,00
 * 
 * documentazione su: https://struts.apache.org/core-developers/type-conversion
 */

@SuppressWarnings("rawtypes")
public class BigDecimalConverter extends StrutsTypeConverter {
    
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        String value = values[0].replace(",", "."); //per qualche motivo mette la virgola sulla JSP
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            throw new TypeConversionException(e);
        }
    }

    @Override
    public String convertToString(Map context, Object o) {
        if (o instanceof BigDecimal) {
            return ((BigDecimal) o).toString();
        }
        return null;
    }
}

