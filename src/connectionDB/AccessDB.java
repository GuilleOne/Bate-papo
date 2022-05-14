package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessDB {
	private Connection conection = null;
	private String login = "root";
	private String senha = "";
	private String url = "jdbc:mysql://localhost:3308/cadastros_login_bate_bapo";
	
	

	
	public boolean login(String nomeU, String pass) throws SQLException {
		boolean isClient = false;
		boolean isPassword = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conection = DriverManager.getConnection(url, login, senha);

			ResultSet rsClient = conection.createStatement().executeQuery("SELECT * FROM logins");

			while(rsClient.next()) {
				if((rsClient.getString("usuario").equals(nomeU)) && 
						(rsClient.getString("senha").equals(pass))) {
							
							isClient = true;
							isPassword = true;
					
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
		
		if (isClient && isPassword == true) {
			return true;
		} else {
			return false;
		}
		
	} 
	

	public AccessDB() {
		
	}


	public static void main(String[] args) throws SQLException {
		
		AccessDB adb = new AccessDB();
		boolean ad = adb.login("El Josi", "bolinhoMagro");
		System.out.println(ad);
	}

}
