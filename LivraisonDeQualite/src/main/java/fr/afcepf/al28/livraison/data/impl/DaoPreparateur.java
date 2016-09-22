package fr.afcepf.al28.livraison.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import fr.afcepf.al28.livraison.data.api.IDaoPreparateur;
import fr.afcepf.al28.livraison.entities.Preparateur;
import fr.afcepf.al28.livraison.exceptions.QualitEnum;
import fr.afcepf.al28.livraison.exceptions.QualitException;
/**
 * Implémmentatio des services liés à la persistence de l'entité
 * {@link Preparateur}.
 * @author stagiaire
 *
 */
public class DaoPreparateur implements IDaoPreparateur {
    /**
     * Requete sql.
     */
    private static final String REQ_CONNECT = "SELECT id_preparateur,login_preparateur,nom_preparateur FROM preparateur"
            + " WHERE login_preparateur = ? AND password_preparateur = ?";
    /**
     * Index parametre prepared statement 1.
     */
    private static final Integer INDEX_PARAM_LOGIN = 1;
    /**
     * Index parametre prepared statement 2.
     */
    private static final Integer INDEX_PARAM_PASSWORD = 2;
    /**
     * Index colonne id bdd.
     */
    private static final Integer INDEX_COL_ID = 1;
    /**
     * Index colonne login bdd.
     */
    private static final Integer INDEX_COL_LOGIN = 2;
    /**
     * Index colonne nom bdd.
     */
    private static final Integer INDEX_COL_NOM = 3;
    /**
     * Le datasource mysql.
     */
    private DataSource ds = new QualiteDataSource();
    @Override
    public Preparateur seConnecter(String paramLogin, String paramMdp) throws QualitException {
        Connection con = null;
        QualitException qe = null;
        Preparateur p = new Preparateur();
        try {
            con = ds.getConnection();
            PreparedStatement stmt = con.prepareStatement(REQ_CONNECT);
            stmt.setString(INDEX_PARAM_LOGIN, paramLogin);
            stmt.setString(INDEX_PARAM_PASSWORD, paramMdp);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt(INDEX_COL_ID));
                p.setLogin(rs.getString(INDEX_COL_LOGIN));
                p.setNom(rs.getString(INDEX_COL_NOM));
            } else {
                qe = new QualitException("mauvais login/pwd", QualitEnum.PROBLEME_IDENTIFICATION);
            }
        } catch (Exception paramE) {
            qe = new QualitException(paramE.getMessage(), QualitEnum.CA_MARCHE_PAS);
        } finally {
            try {
              con.close();
            } catch (SQLException paramE) {
                qe = new QualitException(paramE.getMessage(), QualitEnum.PROBLEME_CONNECTION_SQL);
            }
        }
        if (qe != null) {
            throw qe;
        }
        return p;
    }
}
