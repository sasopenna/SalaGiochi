package pwm.penna.utils.validators.ddg;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class DispositivoDiGiocoValidator extends FieldChecker {
	public DispositivoDiGiocoValidator() {
		super();
		super.setLista(new ArrayList<String>() {{
			add("PC");
			add("Xbox");
			add("PlayStation");
		}});
	}
}
