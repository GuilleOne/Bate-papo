package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessDB {
	Connection conection = null;

	private String login = "root";
	private String senha = "";
	private String url = "jdbc:mysql://localhost:3308/cadastros_login_bate_bapo";
	private boolean isClient;
	private boolean isPassword;
	

	
	public boolean AccessDB(String nomeU, String pass) throws SQLException {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conection = DriverManager.getConnection(url, login, senha);

			ResultSet rsClient = conection.createStatement().executeQuery("SELECT * FROM logins");

			while(rsClient.next()) {
				if(rsClient.getString("usuario").equals(nomeU) 
						&& rsClient.getString("senha").equals(pass)) {
							
					
				}
				
			}

		} catch (ClassNotFoundException ex) {
			System.out.println("Driver do banco não foi localizado.");
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
		} finally {
			if (conection != null) {
				conection.close();
			}

		}
		
		return false;
	} 
	

	public AccessDB() {
		
	}
	public boolean isClient() {
		return isClient;
	}


	public void setClient(boolean isClient) {
		this.isClient = isClient;
	}


	public boolean isPass() {
		return isPassword;
	}


	public void setPass(boolean pass) {
		this.isPassword = pass;
	}


	public static void main(String[] args) throws SQLException {
		boolean ad;
		AccessDB adb = new AccessDB();
		ad = adb.AccessDB("Guigo", "bolinhoGordo");
		
		System.out.println();
		System.out.println(ad);
	}

}
