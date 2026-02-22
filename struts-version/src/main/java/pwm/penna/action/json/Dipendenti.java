package pwm.penna.action.json;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cassiere.CassiereDAOFactory;
import pwm.penna.pojo.dirigente.DirigenteDAOFactory;
import pwm.penna.pojo.tecnico.TecnicoDAOFactory;

@SuppressWarnings("unchecked")
public class Dipendenti<T> extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<T> dipendenti;
	private String q;

	@Override
    public String execute() {
		List<T> res = new ArrayList<>();
		
    	if(q.equalsIgnoreCase("dirigenti")) {
    		res = (List<T>) DirigenteDAOFactory.getDAO().getLista();
    	} else if(q.equalsIgnoreCase("cassieri")) {
    		res = (List<T>) CassiereDAOFactory.getDAO().getLista();
    	} else if(q.equalsIgnoreCase("tecnici")) {
    		res = (List<T>) TecnicoDAOFactory.getDAO().getLista();
    	}

    	setDipendenti(res);
    	return SUCCESS;
    }

	public List<T> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<T> dipendenti) {
		this.dipendenti = dipendenti;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
}
