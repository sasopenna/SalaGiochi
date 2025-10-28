package pwm.penna.utils.validators.ddg;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class XboxValidator extends FieldChecker {
	public XboxValidator() {
		super();
		super.setLista(new ArrayList<String>() {{
		    add("Series X");
		    add("Series S");
		    add("One X");
		    add("One S");
		    add("One");
		    add("360");
		}});
	}
}
