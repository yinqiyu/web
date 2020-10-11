package dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import vo.User;

public class UserDao {
	public static ArrayList<User> list =new ArrayList<User>();
	public User get(String userName) {
		User user = null;
		try{
			//code加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/excise?useSSL=false&serverTimezone=UTC&character=utf-8", "root", "root");;
			System.out .println("连上了");
			//创建语句
			String sql = "select * from t_user where userName=?";
			System.out .println("查询");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			
			//执行语句
			ResultSet rs = pst.executeQuery();
			System.out .println("执行语句成功");
			
			//结果处理
			if(rs.next()) {
				user = new User(rs.getString("userName"),
						rs.getString("password"),
						rs.getString("chrName"));
				System.out .println("结果处理成功");
			}
			System.out .println(user.getUserName());
			//关闭连接
			con.close();
			pst.close();
			rs.close();
			}catch(Exception e){
			e.printStackTrace();
			}
	
	return user;
}
}
