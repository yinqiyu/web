package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.Download;
import vo.User;

public class DownloadDao {
	public ArrayList<Download> query() {
		ArrayList<Download> list = new ArrayList<Download>();
		try {
			//code加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/excise?useSSL=false&serverTimezone=UTC&character=utf-8", "root", "root");
			System.out .println("连上了资源数据库");
			//创建语句
			String sql = "select * from t_downloadList"; 
			PreparedStatement pst = con.prepareStatement(sql);
			//执行语句
			ResultSet rs = pst.executeQuery();
			//结果处理
			while (rs.next()) {
				Download download = new Download();
				download.setId(rs.getInt("id"));
				download.setName(rs.getString("name"));
				download.setPath(rs.getString("path"));
				download.setDescription(rs.getString("description"));
				long size = rs.getLong("size");
				String sizeStr = fileSizeTransfer(size);
				download.setStar(rs.getInt("star"));
				download.setTime(rs.getString("time"));
				
				list.add(download);
				
			}
			//关闭连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	//根据资源id查询记录，将记录转换为对象进行返回
	public Download get(int id) {
		Download download = null;
		try {
			//code加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/excise?useSSL=false&serverTimezone=UTC&character=utf-8", "root", "root");
			System.out .println("连上了资源数据库2");
			//创建语句
			String sql = "seletc * from t_downloadList where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			//执行语句
			ResultSet rs = pst.executeQuery();

			//结果处理
			if (rs.next()) {
				download = new Download();
				download.setId(rs.getInt("id"));
				download.setName(rs.getString("name"));
				download.setPath(rs.getString("path"));
				download.setDescription(rs.getString("description"));
				long size = rs.getLong("size");
				String sizeStr = fileSizeTransfer(size);
				download.setStar(rs.getInt("star"));
				download.setTime(rs.getString("time"));
				download.setSizeStr(sizeStr);
				
			}
			//关闭连接
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return download;
	}

	private String fileSizeTransfer(long fileSize) {
		String mfileSize = null ;
		DecimalFormat df = new DecimalFormat("######0.00");
		double size = (double)fileSize;
		if (size > 1024 * 1024 * 1024) {
			size = size / (1024 * 1024 * 1024);
			mfileSize = df.format(size) + "G";
		}else if (size >1024 * 1024) {
			mfileSize = df.format(size) + "MB";
		}else if (size > 1024) {
			mfileSize = df.format(size) + "B";
		}
		
		return mfileSize;
	}
	
}
	
//	public static ArrayList<Download> dlist =new ArrayList<Download>();
//	public static void addToDownloadArrayList(Download d){
//		dlist.add(d);
//	}
//	public static String getNamebyId(int x){
//		return dlist.get(x).getName();
//	}
//	public static String getpathbyId(int x){
//		return dlist.get(x).getPath();
//	}
//	public static String getDescriptionbyId(int x){
//		return dlist.get(x).getDescription();
//	}
//	public static int getstarbyId(int x){
//		return dlist.get(x).getStar();
//	}
//	public static double getSizebyId(int x){
//		return dlist.get(x).getSize();
//	}
//	public static String getImagebyId(int x){
//		return dlist.get(x).getImage();
//	}
	
	
//	public Map<String,Object> get(String name) {
//		Download Download = null;
//		   Map<String, Object> resultMap = new HashMap<String, Object>();
//
//		try {
//			//code加载驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			//建立连接
//			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/excise?userSSL=false&serverTimezone=UTC&character=utf-8", "root", "root");;
//			System.out .println("数据库连上了");
//			//创建语句
//			String sql = "select * from t_downloadList ";
//			PreparedStatement pst = con.prepareStatement(sql);
//			//执行语句
//			ResultSet rs = pst.executeQuery();
//			System.out .println("rs:"+rs.toString());
//			//结果处理
//			while(rs.next()){
//				 resultMap.put("image", rs.getString("image"));
//				   resultMap.put("path", rs.getString("path"));
//				   resultMap.put("size",rs.getString("size"));
//				   resultMap.put("path",rs.getString("path"));
//				   
//				
//				
//			/*	DownloadDao.addToDownloadArrayList(new Download(rs.getInt("id"),rs.getString("name"), rs.getString("path") , rs.getString("description") ,
//				rs.getDouble("size"), rs.getInt("star"), rs.getString("image"), sql ));
//				System.out.println(rs.getInt("id"));*/
//			}	
//			//关闭连接
//			con.close();
//			pst.close();
//			rs.close();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			}
//		return resultMap;
//	}

		
	
