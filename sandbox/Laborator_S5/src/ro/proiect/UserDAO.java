package ro.proiect;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
	private Map<String, String> useri;
	private UserDAO() {
		useri=new HashMap<>();
		useri.put("ion","ana");
		useri.put("maria", "123");
	}
	private static UserDAO instance = new UserDAO();
	public static UserDAO instance() {
		return instance;
	}
	public boolean verifica(String u, String p) {
		return p.equals(useri.get(u));
	}
	public Map<String, String> getUseri() {
		return useri;
	}
}
