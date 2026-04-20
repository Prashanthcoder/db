package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sendData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbFlipkart", "root", "root");
		Statement s = conn.createStatement();
		System.out.println("connection established!!!");
		s.execute("create database dbFlipkart");
		s.execute("create table Customer(cid int primary key, cname varchar(40), product varchar(20))");
		s.execute("insert into Customer values(7093, 'Manjunath', 'Laptop')");
		s.execute("insert into Customer values(7194, 'Ayyaleppa', 'Mobile')");
		s.execute("insert into Customer values(8084, 'Chidananda M J', 'Gym powder')");
		System.out.println("done");
		s.execute("commit");
		s.execute("select * from Customer where cname = 'Ayyaleppa'");
		s.execute("delete from Customer where cid = 7093 and cname = 'Chidananda M J'");
		s.execute("insert into Customer values(8024, 'Confident', 'people fuck off')");
	}
}
