/**
 * 
 */
package carpool.reports.ridesreports.model;

/**
 * @author wizar
 *
 */
public class DataReportList {

	
	private String nick;
	
	private String name;
	
	private String email;

	
	public DataReportList(String nick,String name, String email) {
		super();
		this.nick = nick;
		this.name =name;
		this.email = email;
	}
	
	
	public DataReportList() {
		super();
	}
	
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
