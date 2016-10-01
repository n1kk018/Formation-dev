package fr.afcepf.al28.livraison.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.al28.livraison.data.api.IDaoPreparateur;
import fr.afcepf.al28.livraison.data.impl.DaoPreparateur;
import fr.afcepf.al28.livraison.entities.Preparateur;
import fr.afcepf.al28.livraison.exceptions.QualitEnum;
import fr.afcepf.al28.livraison.exceptions.QualitException;

/**
 * test de la méthode se connecter du DAO.
 * @author stagiaire
 *
 */
public class TestDaoPreparateurSeConnecter {
    /**
     * un login valide dans la base de test.
     */
    private String loginValide = "test1";
    /**
     * un mdp valide dans la bdd assoscié au loginValide.
     */
    private String mdpValide = "test1";
    /**
     * un login qui n'esxiste pas danns la bdd.
     */
    private String loginInvalide = "jhkjhkj";
    /**
     * Le préparateur attendu dans le cas nominal.
     */
    private Preparateur preparateurExpected =
            new Preparateur(1, "preparateur test1", loginValide, mdpValide);
    /**
     * la definition du service à tester.
     */
    private IDaoPreparateur dao = new DaoPreparateur();
    /**
     * Test du cas Nominal, avec un bon login et mdp.
     * @throws QualitException ne doit pas passer ici.
     */
    @Test
    public void testConnectionNominale() throws QualitException {
        Preparateur p = dao.seConnecter(loginValide, mdpValide);
        Assert.assertNotNull(p);
        Assert.assertNotNull(p.getId());
        Assert.assertNotNull(p.getNom());
        Assert.assertNotNull(p.getLogin());
        Assert.assertNull(p.getMdp());
        Assert.assertEquals(preparateurExpected.getId(), p.getId());
        Assert.assertEquals(preparateurExpected.getNom(), p.getNom());
        Assert.assertEquals(preparateurExpected.getLogin(), p.getLogin());
    }
    /**
     * Test cas d'echec 1.
     */
    @Test
    public void testConnectionEchec() {
        try {
            dao.seConnecter(loginInvalide, mdpValide);
            Assert.fail("c'est pas normal...");
        } catch (QualitException paramE) {
            Assert.assertEquals(
                    QualitEnum.PROBLEME_IDENTIFICATION,
                    paramE.getCodeErreur());
        }
    }
    /**
     * Test cas d'echec 2.
     * @throws QualitException vrai car cas d'erreur.
     */
    @Test(expected = QualitException.class)
    public void testConnectionEchecE() throws QualitException {
            dao.seConnecter(loginInvalide, mdpValide);
    }
    /***
     * Méthode qui crée la bdd de test.
     */
    @Before
    public void setUp() {
        /*String path = Thread.currentThread()
                .getContextClassLoader()
                .getResource("crebase.bat").getPath();*/
        try {
            Process proc = Runtime.getRuntime().exec("/usr/bin/mysql -uroot -pc4p1b4r4 < bdd_livraison.sql");
            proc.waitFor();
        } catch (IOException paramE) {
            paramE.printStackTrace();
        } catch (InterruptedException paramE) {
            paramE.printStackTrace();
        }
    }
}
