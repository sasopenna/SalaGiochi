package pwm.penna.utils.validators;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

//Preso qui: https://www.archety.dev/regex/esempio-di-regex-validazione-del-codice-fiscale

public class CodiceFiscaleValidator extends FieldValidatorSupport {
  private static final Pattern CF_PATTERN = Pattern.compile("^[A-Z]{6}\\d{1,2}[A-Z]\\d{1,2}[A-Z]\\d{3}[A-Z]$");
	@Override
	public void validate(Object arg0) throws ValidationException {
		final String field = this.getFieldName();
		final String codiceFiscale = (String) this.getFieldValue(field, arg0);
		
		if(!CF_PATTERN.matcher(codiceFiscale).matches()) {
			addFieldError(field, arg0);
		}
	}
}
