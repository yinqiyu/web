package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreatImage {

	private static final int WIDTH = 100;
	private static final int HEIGHT = 30;
	private static final int LENGHT = 4;
	private static final int LINECOUNT = 20;

	private static final String str ="23456789"+"ABCDEFGHJKLMNPQRSTUVWXYZ"
			+"abcdefghijklmnpqrstuvwxyz";
	
	private static Random random =  new Random();
	//随机生成4位验证码
	public String createCode() {
		String code = "";
		for (int i = 0; i < LENGHT; i++) {
			//nextInt随机生成int值
			char c = str.charAt(random.nextInt(str.length()));
			
			code = code + c;
			
		}
		return code;
	}
	//获取颜色
	public Color getColor() {
		return new Color(random.nextInt(255), random.nextInt(255), 
				random.nextInt(255));
	}
	//获取字体样式
	public Font getFont() {
		return new Font("Fixedsys",Font.CENTER_BASELINE,22);
	}
	//绘制字符
	public void drawChar(Graphics g,String code) {
		g.setFont(getFont());
		for(int i = 0;i < LENGHT; i++) {
			char c = code.charAt(i);
			g.setColor(getColor());
			g.drawString(c + " ", 20 * i + 10, 20);		
		}
		
	}
	//随机线条
	public void drawLine(Graphics g) {
		int x = random.nextInt(WIDTH);
		int y = random.nextInt(HEIGHT);
		int x1 = random.nextInt(13);
		int y1 = random.nextInt(15);
		g.setColor(getColor());
		g.drawLine(x, y, x+x1, y+y1);
	}
	//绘制验证码图片
	public BufferedImage CreateImage(String code) {
		//获取画笔
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = image.getGraphics();
		//背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//绘制验证码
		drawChar(g,code);
		//绘制线条
		for(int i = 0;i < LINECOUNT;i++) {
			drawLine(g);
		}
		//绘制图片
		g.dispose();
		//返回图片
		return image;
		
	}
	
}
