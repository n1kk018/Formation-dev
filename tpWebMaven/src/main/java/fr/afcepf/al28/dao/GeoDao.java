package fr.afcepf.al28.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class GeoDao {
	
	private static Logger logger = LoggerFactory.getLogger(GeoDao.class);

	public List<String> rechercherRegions() {
		List<String> regions = new ArrayList<String>();
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			/*Class.forName("com.mysql.jdbc.Driver");
			String urlDB = "jdbc:mysql://localhost/geodb";
			cn = DriverManager.getConnection(urlDB, "root", "afcepf");*/
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/"+"jdbc/geodb");
			cn = ds.getConnection();
			st = cn.prepareStatement("SELECT * FROM Regions WHERE num >= ?;");
			st.setInt(1, 15);
			rs = st.executeQuery();
			while(rs.next()) {
				logger.info(rs.getString("nom"));
				regions.add("["+rs.getInt("num")+"]"+rs.getString("nom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			GeoDao.closeAll(cn,rs,st);
		}
		return regions;
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
