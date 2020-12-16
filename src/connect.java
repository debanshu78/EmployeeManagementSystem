import java.sql.*;
public class connect
{
	public static  Connection getOracleConeection()
	{
		Connection con=null;
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","debanshu78l");
		}	 
		catch (Exception e)
		{
		}
		return con;
	}
}
