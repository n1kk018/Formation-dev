package fr.afcepf.al28.livraison.data.impl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;
/**
 * DataSource pour effectuer les tests sur la bdd test.
 * @author stagiaire
 *
 */
public class QualiteDataSource implements DataSource {
    /**
     * url de la base de test.
     */
    private static String url;
    /**
     * login de la bdd de test.
     */
    private static String login;
    /**
     * mdp de la bdd de test.
     */
    private static String password;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("qualite");
        url = rb.getString("url");
        login = rb.getString("login");
        password = rb.getString("password");
        try {
            Class.forName(rb.getString("driver"));
        } catch (ClassNotFoundException paramE) {
            paramE.printStackTrace();
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
       return DriverManager.getConnection(url, login, password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter paramOut) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLoginTimeout(int paramSeconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> paramIface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> paramIface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public Connection getConnection(String paramUsername, String paramPassword) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
