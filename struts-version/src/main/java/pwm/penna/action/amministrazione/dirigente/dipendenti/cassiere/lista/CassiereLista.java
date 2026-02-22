package pwm.penna.action.amministrazione.dirigente.dipendenti.cassiere.lista;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.pojo.cassiere.Cassiere;
import pwm.penna.pojo.cassiere.CassiereDAOFactory;

public class CassiereLista extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Cassiere> cassieri;

    @Override
    public String execute() {
    	setCassieri(CassiereDAOFactory.getDAO().getLista());
    	return SUCCESS;
    }

	public List<Cassiere> getCassieri() {
		return cassieri;
	}

	public void setCassieri(List<Cassiere> cassieri) {
		this.cassieri = cassieri;
	}
}