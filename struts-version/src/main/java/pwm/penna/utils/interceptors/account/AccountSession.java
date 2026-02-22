package pwm.penna.utils.interceptors.account;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import pwm.penna.pojo.account.Account;
import pwm.penna.pojo.account.AccountDAO;
import pwm.penna.pojo.account.AccountDAOFactory;

public class AccountSession {
	public static final String SESSION_ID = "account"; 
	
	private Account account;
	
	// metto i costruttori privati così non si può creare un account a meno che non si faccia da CheckCredentials
	private AccountSession() {}
	private AccountSession(Account account) { this.account = account; }

	// metodo statico per creare un Account se le credenziali sono corrette
	public static AccountSession checkCredentials(String email, String password) {
		AccountDAO dao = AccountDAOFactory.getDAO();
		Account account = dao.getAccount(email);
		if(account == null) return null; 							//se non esiste dà errore
		if(!account.getPassword().equals(password)) return null; 	//se non combacia la pass dà errore
		
		account.setUltimoLogin(new java.sql.Date(new Date().getTime()));
		dao.aggiornaAccount(account);
		
		return new AccountSession(account); //se combacia restituisce un account
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	private long cacheRefreshId = new Date().getTime();
	public void generateNewId() { //fatto perchè caricava i file salvati nella cache
		cacheRefreshId = new Date().getTime();
	}
	
	public String getFotoPath() {
	    String imgPath = "/assets/img/profilo/";
	    String imgName = "default";
	    String imgExtension = ".jpg";
	    
	    if(account != null) {
		    String id = account.getEmail() + "";
		    
	        try {
	            ServletContext context = ServletActionContext.getServletContext();
	            String destPath = context.getRealPath(imgPath);
	            File testFile = new File(destPath, id + imgExtension);
	
	            if (testFile.exists()) {
	                imgName = id;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return imgPath + imgName + imgExtension + "?e=" + cacheRefreshId;
	}
}
