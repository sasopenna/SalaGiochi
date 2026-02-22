package pwm.penna.utils.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class GenderValidator extends FieldValidatorSupport {
	@Override
	public void validate(Object arg0) throws ValidationException {
		final String field = this.getFieldName();
		final String str = ((String) this.getFieldValue(field, arg0)).toLowerCase();
		
		boolean isUomo = str.equals("uomo");
		boolean isDonna = str.equals("donna");
		
		if(!isUomo && !isDonna) {
			addFieldError(field, arg0);
		}
	}
}
