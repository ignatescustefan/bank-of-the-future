package com.ripbank.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ripbank.core.User;
import com.ripbank.core.UserDAO;

public class DBManager implements UserDAO{
	private static final DBManager instance = new DBManager();
	
	public static DBManager getInstance() {
		return instance;
	}
	
	//foloseste un obiect de tip conexiune bd
	@Override
	public List<User> findUserByCNP(String cnp) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()){
			List<User> userList=new ArrayList<>();
			st.execute("SELECT * FROM utilizator WHERE cnp="+cnp);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				User user=new User(rs.getString("nume"), rs.getString("prenume"),
						rs.getString("email"), rs.getString("parola"), rs.getString("cnp"),
						rs.getString("telefon"));
				userList.add(user);
				return userList;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findUserByEmail(String email) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()){
			List<User> userList=new ArrayList<>();
			st.execute("SELECT * FROM utilizator WHERE email="+email);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				User user=new User(rs.getString("nume"), rs.getString("prenume"),
						rs.getString("email"), rs.getString("parola"), rs.getString("cnp"),
						rs.getString("telefon"));
				userList.add(user);
				return userList;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findUserByEmailAndPassword(String email, String password) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()){
			List<User> userList=new ArrayList<>();
			st.execute("SELECT * FROM utilizator WHERE email="+"\""+email+"\"" +" AND parola="+"\""+password+"\"");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				User user=new User(rs.getString("nume"), rs.getString("prenume"),
						rs.getString("email"), rs.getString("parola"), rs.getString("cnp"),
						rs.getString("telefon"));
				userList.add(user);
				return userList;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
