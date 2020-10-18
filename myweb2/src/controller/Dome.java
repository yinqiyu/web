package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Dome {
    public static void main(String[] args) throws IOException {
        //Dome.class.getClassLoader()获取文件路径类加载器
        InputStream in = Dome.class.getClassLoader().getResourceAsStream("datebase.properties");
        //读取文件
        Properties properties=new Properties();
        properties.load(in);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");
        String jdbcUrl= properties.getProperty("jdbcUrl");
        System.out.println(user);

        System.out.println(password);
        System.out.println(driverClass);
        System.out.println(jdbcUrl);

    }
}