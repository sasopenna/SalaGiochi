package pwm.penna.action.account.profilo;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import pwm.penna.utils.interceptors.account.AccountAware;
import pwm.penna.utils.interceptors.account.AccountSession;

public class CambiaFoto extends ActionSupport implements AccountAware {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LogManager.getLogger(CambiaFoto.class);
	
	private File file;
    private String fileContentType;
    private String fileFileName;
    private AccountSession account;
    private String token;

    @Override
    public String execute() {
        if (file != null) {
        	setFileFileName(account.getAccount().getEmail() + ".jpg");
        	
            try {
            	ServletContext context = ServletActionContext.getServletContext(); 
            	String destPath = context.getRealPath("/assets/img/profilo/");
                File destFile = new File(destPath, getFileFileName());
                
                FileUtils.copyFile(file, destFile);

                account.generateNewId();
                logger.info("File caricato: " + destFile.getAbsolutePath());
                this.addActionMessage(getText("action.changefoto_successfull"));
                return SUCCESS;
            } catch (Exception e) {
                logger.error(e);
            }
        }
        
        this.addActionError(getText("action.changefoto_error"));
        return SUCCESS;
    }
    
    @Override
    public void validate() {
    	if(getFileContentType() != null && !getFileContentType().equals("image/jpeg")) {
    		this.addActionError(getText("action.filetype_error"));
    	}
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public AccountSession getAccount() {
		return account;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public void setAccount(AccountSession account) {
		this.account = account;
	}
}
