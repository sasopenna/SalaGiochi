package pwm.penna.utils.validators.ddg;

import java.util.List;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/*
 * ho creato questa classe apposita perchè avevo 4 validator che facevano la stessa cosa
 * e l'unica cosa che cambiava era la lista, quindi con questo faccio che varia solo la 
 * lista e implemento la validazione/check che è uguale per tutte  
 */

public class FieldChecker extends FieldValidatorSupport {
	private List<String> lista;
	
	public FieldChecker() {
	}

	@Override
	public void validate(Object arg0) throws ValidationException {
		final String field = this.getFieldName();
		final String str = (String) this.getFieldValue(field, arg0);

        if (!check(str)) {
            addFieldError(field, arg0);
        }
	}
	
	public boolean check(String str) {
		if(str == null) return false;
		
		boolean ok = false;
        for (String l : lista) {
            if (l.toLowerCase().equals(str.toLowerCase())) { //metto entrambe lowercase
                ok = true;
                break;
            }
        }
        return ok;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}
}
