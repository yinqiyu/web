package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import vo.resource;

public class resourceDao {
	public static List<resource> get(String userName){
		List<resource> resources =  new ArrayList<resource>();
		
	
		try {
			//code加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/excise?userSSL=false&serverTimezone=UTC&character=utf-8", "root", "root");
			if (con != null) {
				System.out.println("语句查询成功");
			}else {
				System.out.println("语句查询失败");
			}
			//创建语句
			String sql = "SELECT * FROM t_resource WHERE resourceId IN ( SELECT resourceId FROM t_role_resource WHERE roleId IN ( SELECT roleId FROM t_user_role WHERE userName =?))";
			System.out .println("查询resource");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setNString(1, userName);
			//执行语句
			ResultSet rs = pst.executeQuery();
			System.out .println("执行resource语句成功"+rs.toString());
			
			//结果处理
			while(rs.next())
			{
				System.out.println("结果处理");
				resource resource= new resource();
				resource  = new resource(rs.getInt("resourceId"),rs.getString("resourceName"),rs.getString("url"));
				resources.add(resource);
			}
			//关闭连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  resources;
		
		
	}

}
