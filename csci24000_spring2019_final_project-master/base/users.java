public class users{
	private boolean programmer;
	
	private int password;

	private String userName;

	private boolean approved;
	
	private boolean referred;


	public users(String userName, int password, boolean programmer, boolean approved){
		super();
		this.userName = userName;
		this.password = password;
		this.programmer = programmer;
		this.approved = approved;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public void setReferred(boolean referred){
		this.referred = referred;
	}
	public void setPassword(int password){
		this.password = password;
	}
	public void setProgrammer(boolean programmer){
		this.programmer = programmer;
	}
	public void setApproved(boolean approved){
		this.approved = approved;
	}
	public String getUserName(){
		return userName;
	}
	public int getPassword(){
		return password;
	}
	public boolean getProgrammer(){
		return programmer;
	}
	public boolean getApproved(){
		return approved;	
	}
	public boolean getReferred(){
		return referred;
	}
}
				
