package tools;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatebaseConnection {
	// 数据库参数配置文件名
	private static final String JDBCPROPERTY = "jdbc.properties";
		// 准备数据库的四大参数：
		private static String DBDRIVER = "";
		private static String DBURL = "";
		private static String DBUSER = "";
		private static String PASSWORD = "";

		private Connection conn; // 准备一个数据库连接对象
		/**
		 * 使用静态静态代码快加载数据库配置文件
		静态代码块，在虚拟机加载类的时候就会加载执行，而且只执行一次;
		非静态代码块，在创建对象的时候(即new一个对象的时候)执行，每次创建对象都会执行一次
		 * @return 
		 */
		static {
			try {
				Properties property = new Properties();
		//使用绝对路径加载资源文件
		/*String classPath = 				 
		 * DatabaseConnection.class.getResource("/resource").getPath();
		InputStream is = new FileInputStream(classPath  + "/"+ JDBCPROPERTY);
		*/
		//使用类加载器加载资源
		InputStream is = DatebaseConnection.class.getClassLoader().getResourceAsStream("resource/"+JDBCPROPERTY);
				property.load(new InputStreamReader(is, "utf-8"));
				is.close();
				DBDRIVER = property.getProperty("DBDRIVER");
				DBURL = property.getProperty("DBURL");
				DBUSER = property.getProperty("DBUSER");
				PASSWORD = property.getProperty("PASSWORD");
				// 加载驱动，只需注册一次就行
				Class.forName(DBDRIVER);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//构造方法，实例化对象时创建连接对象
		public  DatebaseConnection() {
			try {
				this.conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//直接返回实例化对象时创建的连接对象
		public Connection getConnection() {
			return this.conn;
		}
	//关闭连接对象
		public void close() {
			if (this.conn != null) {
				try {
					this.conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	

