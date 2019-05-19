package com.ripbank.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.logging.Log4J;
import com.ripbank.core.Account;
import com.ripbank.core.ClientStatus;
import com.ripbank.core.Employee;
import com.ripbank.core.User;
import com.ripbank.core.DAO.AccountDAO;
import com.ripbank.core.DAO.EmployeeDAO;
import com.ripbank.core.DAO.TransactionDAO;
import com.ripbank.core.DAO.UserDAO;
import com.ripbank.core.DTO.CompleteTransactionDetailsDTO;
import com.ripbank.core.DTO.TransactionDTO;
import com.ripbank.core.DTO.TransactionReportInformationDTO;
import com.ripbank.core.TipCont;
import com.ripbank.core.TipTranzactie;

public class DBManager implements UserDAO, AccountDAO, EmployeeDAO, TransactionDAO {
	private static final DBManager instance = new DBManager();

	public static DBManager getInstance() {
		return instance;
	}

	@Override
	public List<User> findUserByCNP(String cnp) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			List<User> userList = new ArrayList<>();
			st.execute("SELECT u.*,s.client_status FROM utilizator u, status_client s WHERE s.cnp=u.cnp and u.cnp=" + cnp);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				User user = createUserByResultSet(rs);
				userList.add(user);
				return userList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findUserByEmail(String email) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			List<User> userList = new ArrayList<>();
			st.execute("SELECT * FROM utilizator WHERE email=" + "\"" + email + "\"");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				User user = createUserByResultSet(rs);
				userList.add(user);
				return userList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findUserByEmailAndPassword(String email, String password) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			List<User> userList = new ArrayList<>();
			System.out.println("SELECT u.* s.client_status FROM utilizator u, status_client s WHERE s.cnp=u.cnp and email=" + "\"" + email + "\"" + "AND parola=" + "\"" + password
					+ "\"");
			st.execute("SELECT u.*,s.client_status FROM utilizator u, status_client s WHERE s.cnp=u.cnp and email=" + "\"" + email + "\"" + " AND parola=" + "\"" + password
					+ "\"");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				User user = createUserByResultSet(rs);
				userList.add(user);
				return userList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private User createUserByResultSet(ResultSet rs) throws SQLException {
		User user = new User(rs.getString("nume"), rs.getString("prenume"), rs.getString("email"),
				rs.getString("parola"), rs.getString("cnp"), rs.getString("telefon"),
				ClientStatus.valueOf(rs.getString("client_status")));
		return user;
	}

	@Override
	public List<Double> getBalanceForIBAN(String iban) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			st.execute("SELECT * FROM cont WHERE iban=" + "\"" + iban + "\"");
			List<Double> money = new ArrayList<>();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Double currentBalance = new Double(rs.getString("sold"));
				money.add(currentBalance);
			}
			return money;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Account> getClientAccounts(String cnp) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			System.out.println("SELECT * FROM cont WHERE proprietar_cnp=" + "\"" + cnp + "\"");
			st.execute("SELECT * FROM cont WHERE proprietar_cnp=" + "\"" + cnp + "\"");
			List<Account> accounts = new ArrayList<>();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getString("tip_cont"));
				Account cont = new Account(TipCont.valueOf(rs.getString("tip_cont")), rs.getString("iban"),
						rs.getString("proprietar_cnp"), rs.getString("pin"), Double.parseDouble(rs.getString("sold")));
				accounts.add(cont);
			}
			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertAuthCodeInDB(String cnp, String authCode) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			System.out.println("INSERT INTO token (token_cnp, token_key, time_stamp) VALUES(" + "\"" + cnp + "\","
					+ "\"" + authCode + "\"," + "CURRENT_TIMESTAMP)");
			st.execute("INSERT INTO token (token_cnp, token_key, time_stamp) VALUES(" + "\"" + cnp + "\"," + "\""
					+ authCode + "\"," + "CURRENT_TIMESTAMP)");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUserInformation(String cnp, String nume, String prenume, String telefon) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			System.out.println("UPDATE `utilizator` SET `nume`=" + "\"" + nume + "\"" + ", `prenume`=" + "\"" + prenume
					+ "\"" + ",`telefon`=" + "\"" + telefon + "\"" + " WHERE cnp=" + "\"" + cnp + "\"");
			st.execute("UPDATE `utilizator` SET `nume`=" + "\"" + nume + "\"" + ", `prenume`=" + "\"" + prenume + "\""
					+ ",`telefon`=" + "\"" + telefon + "\"" + " WHERE cnp=" + "\"" + cnp + "\"");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Employee> findEmployeeByEmailAndPass(String email, String password) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			List<Employee> employees = new ArrayList<>();
			st.execute("SELECT * FROM angajat WHERE email=" + "\"" + email + "\"" + "AND parola=" + "\"" + password
					+ "\"");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Employee employee = new Employee(rs.getString("nume"), rs.getString("prenume"), rs.getString("email"),
						null);
				employees.add(employee);
				return employees;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean makeTransaction(TransactionDTO transaction) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			st.execute("SELECT IBAN, sold FROM cont WHERE IBAN=" + "\"" + transaction.getIbanDest() + "\"");
			ResultSet rs = st.getResultSet();
			if (null != rs) {
				// check if destination IBAN exist
				int size = 0;
				rs.beforeFirst();
				rs.last();
				size = rs.getRow();
				System.out.println("Size: " + size);
				if (1 == size) {
					double balanceAfterTransactionDestination = rs.getDouble("sold") + transaction.getAmount();
					st.execute("INSERT INTO tranzactie values" + "(0, " + "\"" + transaction.getTipTranzactie() + "\","
							+ "\"" + transaction.getIbanSource() + "\"," + "\"" + transaction.getIbanDest() + "\","
							+ "\"" + transaction.getOperatorTranzactie() + "\"," + "CURDATE()," + "CURRENT_TIME, "
							+ transaction.getAmount() + ")");
					System.out.println("UPDATE cont SET sold=" + balanceAfterTransactionDestination + " WHERE iban="
							+ "\"" + transaction.getIbanDest() + "\"");
					st.execute("UPDATE cont SET sold=" + balanceAfterTransactionDestination + " WHERE iban=" + "\""
							+ transaction.getIbanDest() + "\"");
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try (Statement st1 = DBConnection.getInstance().conn.createStatement()) {
			st1.execute("SELECT IBAN, sold FROM cont WHERE IBAN=" + "\"" + transaction.getIbanSource() + "\"");
			ResultSet rs1 = st1.getResultSet();
			rs1.next();
			double balanceAfterTransactionSource = rs1.getDouble("sold") - transaction.getAmount();
			st1.execute("UPDATE cont SET sold=" + balanceAfterTransactionSource + " WHERE iban=" + "\""
					+ transaction.getIbanSource() + "\"");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getCNPByIBAN(String IBAN) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			st.execute("SELECT proprietar_cnp FROM cont WHERE iban=" + "\"" + IBAN + "\"");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				String cnp = rs.getString("proprietar_cnp");
				return cnp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteClient(String cnp) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			st.execute("UPDATE status_client SET client_status='inactiv' WHERE CNP=" + "\"" + cnp + "\"");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CompleteTransactionDetailsDTO> getTransactions(
			TransactionReportInformationDTO transactionReportInformationDTO) {
		List<String> IBANs = getIBANByCNP(transactionReportInformationDTO.getCnp());
		List<CompleteTransactionDetailsDTO> transactions = new ArrayList<>();
		StringBuilder query = new StringBuilder();
		query.append(
				"SELECT * FROM tranzactie WHERE data_tranzactie>='" + transactionReportInformationDTO.getStartDate()
						+ "' AND data_tranzactie<='" + transactionReportInformationDTO.getFinalDate() + "'");
		query.append("AND (");
		for (String iban : IBANs) {
			query.append("IBAN_sursa='" + iban + "'");
			query.append("OR ");
			query.append("IBAN_destinatie='" + iban + "'");
			if (IBANs.indexOf(iban) != IBANs.size() - 1) {
				query.append("OR ");
			}
		}
		query.append(")");
		System.out.println("Query: " + query.toString());
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			st.execute(query.toString());
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				CompleteTransactionDetailsDTO transaction = createCompleteTransactionDetailsDTOFromResultSet(rs);
				transactions.add(transaction);
			}
//			System.out.println(transactions.toString());
			return transactions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private CompleteTransactionDetailsDTO createCompleteTransactionDetailsDTOFromResultSet(ResultSet rs)
			throws SQLException {
		CompleteTransactionDetailsDTO transaction = new CompleteTransactionDetailsDTO();
		transaction.setIdTranzactie(rs.getInt("id_Tranzactie"));
		transaction.setTipTranzactie(TipTranzactie.valueOf(rs.getString("tip_Tranzactie")));
		transaction.setIbanSource(rs.getString("IBAN_sursa"));
		transaction.setIbanDest(rs.getString("IBAN_destinatie"));
		transaction.setOperatorTranzactie(rs.getString("operator_tranzactie"));
		transaction.setDataTranzactie(rs.getString("data_tranzactie"));
		transaction.setOraTranzactie(rs.getString("ora_tranzactie"));
		transaction.setAmount(rs.getDouble("suma_tranzactie"));
		return transaction;
	}

	private List<String> getIBANByCNP(String cnp) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			st.execute("SELECT IBAN FROM cont WHERE proprietar_cnp='" + cnp + "'");
			List<String> ibans = new ArrayList<>();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				ibans.add(rs.getString("IBAN"));
			}
			return ibans;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean createUser(User user) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			if (1 == st.executeUpdate("INSERT INTO utilizator VALUES (" + "\"" + user.getNume() + "\", " + "\""
					+ user.getPrenume() + "\", " + "\"" + user.getEmail() + "\", " + "\"" + user.getParola() + "\", "
					+ "\"" + user.getCnp() + "\", " + "\"" + user.getTelefon() + "\", " + "\"" + "activ" + "\""
					+ ")")) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	private String generateIbanCandidate() {
		Random rand = new Random();
		StringBuilder iban = new StringBuilder();
		for (int i = 0; i < 16; ++i) {
			iban.append(rand.nextInt(10) + "");
		}
		return "RO84RIPB" + iban.toString();
	}

	public String generateIBAN(String cnp) {
		int size = 1;
		while (size >= 1) {
			try (Statement st = DBConnection.getInstance().conn.createStatement()) {
				Log4J.getLogger().info("Generating IBAN for: " + cnp);
				String ibanCandidate = generateIbanCandidate();
				Log4J.getLogger().info("Generated IBAN: " + ibanCandidate);
				st.execute("SELECT * FROM cont WHERE IBAN=\"" + ibanCandidate + "\"");
				ResultSet rs = st.getResultSet();
				if (null != rs) {
					rs.beforeFirst();
					rs.last();
					size = rs.getRow();
					if (0 == size) {
						return ibanCandidate;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public boolean createAccount(String cnp, String iban, TipCont tipCont, Double amount) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			// TODO: need to add support for account type
			// TODO: randomize PIN & return it
			st.execute("INSERT INTO cont VALUES(\"" + iban + "\", " + "\"" + cnp + "\", " + "\"" + tipCont + "\","
					+ "\"" + "0000" + "\", " + amount + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getPINForDefaultAccount(String cnp) {
		try (Statement st = DBConnection.getInstance().conn.createStatement()) {
			st.execute("SELECT PIN FROM cont where proprietar_cnp='" + cnp + "' AND tip_cont=\"depozit\"");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				return rs.getString("PIN");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}