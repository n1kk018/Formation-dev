package fr.afcepf.al28.geodb;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf.al28.reflection.ConsoleApp;

import java.sql.Connection;

public class GeoDBApp {
	
	private static Logger logger = LoggerFactory.getLogger(ConsoleApp.class);

	public static void main(String[] args) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlDB = "jdbc:mysql://localhost/geodb";
			cn = DriverManager.getConnection(urlDB, "root", "afcepf");
			st = cn.prepareStatement("SELECT * FROM Regions WHERE num >= ?;");
			st.setInt(1, 15);
			rs = st.executeQuery();
			while(rs.next()) {
				logger.info(rs.getString("nom"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GeoDBApp.closeAll(cn,rs,st);
		}
	}
	
	public static void closeAll(Connection cn,ResultSet rs, Statement st){
		try {
			rs.close();
			st.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
