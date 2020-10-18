package tools;
import java.sql.*;

public class JdbcUtil {
	public static void main(String[] arrgs)throws Exception{
		//1.加载mysql
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.建立连接与mysql服务器的连接
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
													"root",
													"root");
		//3.创建语句对象
		String sql = "select * from t_downloadList";
		PreparedStatement ps = con.prepareStatement(sql);
		
		//4.执行语句
		ResultSet rs = ps.executeQuery();
		
		//5.处理结果
		
		//6.关闭连接
		rs.close();
		ps.close();
		con.close();
	}

}
