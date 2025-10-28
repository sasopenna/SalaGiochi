package pwm.penna.utils.validators.ddg;

import java.util.ArrayList;

public class PlayStationValidator extends FieldChecker {
	@SuppressWarnings("serial")
	public PlayStationValidator() {
		super();
		super.setLista(new ArrayList<String>() {{
			add("5");
			add("4");
			add("3");
			add("2");
			add("1");
		}});
	}
}
