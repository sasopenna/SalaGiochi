package pwm.penna.utils.validators.ddg;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class WindowsValidator extends FieldChecker {
	public WindowsValidator() {
		super();
		super.setLista(new ArrayList<String>() {{
			add("11");
			add("10");
			add("8");
			add("7");
			add("Vista");
			add("XP");
		}});
	}
}
