package DTO;

public class UserDTO {
	private String email;
    private String password;
    
    public String getEmail() {
		return email;
	}
    public String getPassword() {
		return password;
	}
    public void setEmail(String newEmail) {
    	email=newEmail;
    }
    public void setPassword(String newPassword) {
    	password=newPassword;
    }
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", password=" + password + "]";
	}
    
}
