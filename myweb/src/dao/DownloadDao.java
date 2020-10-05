package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.Download;
import vo.User;

public class DownloadDao {
	public static ArrayList<Download> dlist =new ArrayList<Download>();
	public static void addToDownloadArrayList(Download d){
		dlist.add(d);
	}
	public static String getNamebyId(int x){
		return dlist.get(x).getName();
	}
	public static String getpathbyId(int x){
		return dlist.get(x).getPath();
	}
	public static String getDescriptionbyId(int x){
		return dlist.get(x).getDescription();
	}
	public static int getstarbyId(int x){
		return dlist.get(x).getStar();
	}
	public static double getSizebyId(int x){
		return dlist.get(x).getSize();
	}
	public static String getImagebyId(int x){
		return dlist.get(x).getImage();
	}
	
	
	public Map<String,Object> get(String name) {
		Download Download = null;
		   Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			//code加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/excise?userSSL=false&serverTimezone=UTC&character=utf-8", "root", "root");;
			System.out .println("数据库连上了");
			//创建语句
			String sql = "select * from t_downloadList ";
			PreparedStatement pst = con.prepareStatement(sql);
			//执行语句
			ResultSet rs = pst.executeQuery();
			System.out .println("rs:"+rs.toString());
			//结果处理
			while(rs.next()){
				 resultMap.put("image", rs.getString("image"));
				   resultMap.put("path", rs.getString("path"));
				   resultMap.put("size",rs.getString("size"));
				   resultMap.put("path",rs.getString("path"));
				   
				
				
			/*	DownloadDao.addToDownloadArrayList(new Download(rs.getInt("id"),rs.getString("name"), rs.getString("path") , rs.getString("description") ,
				rs.getDouble("size"), rs.getInt("star"), rs.getString("image"), sql ));
				System.out.println(rs.getInt("id"));*/
			}	
			//关闭连接
			con.close();
			pst.close();
			rs.close();
		}
		catch(Exception e){
			e.printStackTrace();
			}
		return resultMap;
	}

		
	
}