import java.sql.*;
public abstract class Conectar {
	public static String status="";
	
	public static Connection getConnection() {
		Connection cn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://localhost/fofuxos_pet";
			String login = "root";
			String senha = "mysql"; // Nesta linha, é só apagar o mysql
			cn = DriverManager.getConnection(url,login,senha);
			
			status = "Conex�o Aberta";
		}catch(SQLException e){
			status =  e.getMessage();
		}catch(ClassNotFoundException e){
			status =  e.getMessage();
		}catch(Exception e){
			status =  e.getMessage();
		}
		return cn;
	}

}
