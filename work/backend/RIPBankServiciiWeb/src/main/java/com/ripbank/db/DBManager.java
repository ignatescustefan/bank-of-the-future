package com.ripbank.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ripbank.core.Account;
import com.ripbank.core.Employee;
import com.ripbank.core.User;
import com.ripbank.core.DAO.AccountDAO;
import com.ripbank.core.DAO.EmployeeDAO;
import com.ripbank.core.DAO.TransactionDAO;
import com.ripbank.core.DAO.UserDAO;
import com.ripbank.core.DTO.TransactionDTO;
import com.ripbank.core.TipCont;

public class DBManager implements UserDAO, AccountDAO, EmployeeDAO, TransactionDAO{
	private static final DBManager instance = new DBManager();

	public static DBManager getInstance() {
		return instance;
	}

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
			st.execute("SELECT * FROM utilizator WHERE email="+"\""+email+"\"");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				User user=new User(rs.getString("nume"), rs.getString("prenume"),
						rs.getString("email"), rs.getString("pa"
								+ "rola"), rs.getString("cnp"),
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
			st.execute("SELECT * FROM utilizator WHERE email="+"\""+email+ "\""+ "AND parola="+"\""+password+"\"");
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
	public List<Double> getBalanceForIBAN(String iban) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()){
			st.execute("SELECT * FROM cont WHERE iban="+ "\""+iban+"\"");
			List<Double> money=new ArrayList<>();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Double currentBalance=new Double(rs.getString("sold"));
				money.add(currentBalance);
			}
			return money;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List <Account> getClientAccounts(String cnp){
		try (Statement st = DBConnection.getInstance().conn.createStatement()){
			System.out.println("SELECT * FROM cont WHERE proprietar_cnp="+ "\""+cnp+"\"");
			st.execute("SELECT * FROM cont WHERE proprietar_cnp="+ "\""+cnp+"\"");
			List<Account> accounts=new ArrayList<>();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getString("tip_cont"));
				Account cont =new Account(TipCont.valueOf(rs.getString("tip_cont")), rs.getString("iban"), 
						rs.getString("proprietar_cnp"), rs.getString("pin"), 
						Double.parseDouble(rs.getString("sold")));
				accounts.add(cont);
			}
			return accounts;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertAuthCodeInDB(String cnp, String authCode) {
		try(Statement st = DBConnection.getInstance().conn.createStatement()){
			System.out.println(
					"INSERT INTO token (token_cnp, token_key, time_stamp) VALUES("
							+"\""+cnp+"\","
							+"\""+authCode+"\","
							+"CURRENT_TIMESTAMP)");
			st.execute("INSERT INTO token (token_cnp, token_key, time_stamp) VALUES("
					+"\""+cnp+"\","
					+"\""+authCode+"\","
					+"CURRENT_TIMESTAMP)");
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateUserInformation(String cnp, String nume, 
			String prenume, String telefon) {
		try(Statement st = DBConnection.getInstance().conn.createStatement()){
			System.out.println("UPDATE `utilizator` SET `nume`="+"\""+nume+"\""
					+ ", `prenume`="+"\""+prenume+"\""+
					",`telefon`="+ "\""+telefon+"\""+
					" WHERE cnp="+"\"" +cnp +"\"");
			st.execute("UPDATE `utilizator` SET `nume`="+"\""+nume+"\""
					+ ", `prenume`="+"\""+prenume+"\""+
					",`telefon`="+ "\""+telefon+"\""+
					" WHERE cnp="+"\"" +cnp +"\"");
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override		
	public List<Employee> findEmployeeByEmailAndPass(String email, String password) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()){
			List<Employee> employees=new ArrayList<>();
			st.execute("SELECT * FROM angajat WHERE email="+"\""+email+ "\""+ "AND parola="+"\""+password+"\"");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Employee employee=new Employee(rs.getString("nume"), rs.getString("prenume"),
						rs.getString("email"), null);
				employees.add(employee);
				return employees;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean makeTransaction(TransactionDTO transaction) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()){
			st.execute("SELECT IBAN, sold FROM cont WHERE IBAN="+"\""+transaction.getIbanDest()+"\"");
			ResultSet rs = st.getResultSet();
			if (null != rs) {
				int size= 0;  
				rs.beforeFirst();  
				rs.last();  
				size = rs.getRow();
				System.out.println("Size: "+size);
				if (1 == size) {
					double balanceAfterTransactionSource=rs.getDouble("sold")-transaction.getAmount();
					System.out.println("INSERT INTO tranzactie values"
							+ "(0, " +"\"" +transaction.getTipTranzactie() +"\","
							+ "\"" + transaction.getIbanSource() +"\","
							+"\" "+transaction.getIbanDest()+"\","
							+"\" "+transaction.getOperatorTranzactie()+"\","
							+"CURDATE(),"+ "CURRENT_TIME, "
							+transaction.getAmount()+")"
							);
					st.execute("INSERT INTO tranzactie values"
							+ "(0, " +"\"" +transaction.getTipTranzactie() +"\","
							+ "\"" + transaction.getIbanSource() +"\","
							+"\""+transaction.getIbanDest()+"\","
							+"\""+transaction.getOperatorTranzactie()+"\","
							+"CURDATE(),"+ "CURRENT_TIME, "
							+transaction.getAmount()+")"
							);
					System.out.println("UPDATE cont SET sold="+balanceAfterTransactionSource+" WHERE iban="+"\""+transaction.getIbanSource()+"\"");
					st.execute("UPDATE cont SET sold="+balanceAfterTransactionSource+" WHERE iban="+"\""+transaction.getIbanSource()+"\"");
					
					//TODO: need to add the amount to dest iban
					return true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}