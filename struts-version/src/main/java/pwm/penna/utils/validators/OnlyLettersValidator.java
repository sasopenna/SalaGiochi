package pwm.penna.utils.validators;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class OnlyLettersValidator extends FieldValidatorSupport {
	static Pattern soloLettere = Pattern.compile("^[a-zA-Z ]+$");
	
	@Override
	public void validate(Object arg0) throws ValidationException {
		final String field = this.getFieldName();
		final String str = (String) this.getFieldValue(field, arg0);
		
		if(!soloLettere.matcher(str).find()) {
			addFieldError(field, arg0);
		}
	}
}
