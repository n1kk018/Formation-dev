package fr.afcepf.al28.livraison.test;

import java.io.IOException;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.afcepf.al28.livraison.data.api.IDaoPreparateur;
import fr.afcepf.al28.livraison.data.impl.DaoPreparateurEJB;
import fr.afcepf.al28.livraison.entities.Commande;
import fr.afcepf.al28.livraison.entities.LigneCommande;
import fr.afcepf.al28.livraison.entities.Livraison;
import fr.afcepf.al28.livraison.entities.Livreur;
import fr.afcepf.al28.livraison.entities.Preparateur;
import fr.afcepf.al28.livraison.entities.Produit;
import fr.afcepf.al28.livraison.exceptions.QualitEnum;
import fr.afcepf.al28.livraison.exceptions.QualitException;

/**
 * test de la méthode se connecter du DAO.
 * @author stagiaire
 *
 */
@RunWith(Arquillian.class)
public class TestDaoPreparateurSeConnecterEJB {
    @Deployment
    public static JavaArchive createDeploy() {
        JavaArchive jar = ShrinkWrap.create(
                JavaArchive.class, "test.jar");
        jar.addClass(Preparateur.class);
        jar.addClass(Commande.class);
        jar.addClass(QualitEnum.class);
        jar.addClass(LigneCommande.class);
        jar.addClass(Produit.class);
        jar.addClass(Livreur.class);
        jar.addClass(Livraison.class);
        jar.addClass(IDaoPreparateur.class);
        jar.addClass(DaoPreparateurEJB.class);
        jar.addClass(QualitException.class);
        jar.addAsManifestResource("test-persistence.xml", ArchivePaths.create("persistence.xml"));
        jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return jar;
    }
    /**
     * la definition du service à tester.
     */
    @EJB
    private IDaoPreparateur dao;
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
        String path = Thread.currentThread()
                .getContextClassLoader()
                .getResource("crebase.bat").getPath();
        try {
            Process proc = Runtime.getRuntime().exec(path);
            proc.waitFor();
        } catch (IOException paramE) {
            paramE.printStackTrace();
        } catch (InterruptedException paramE) {
            paramE.printStackTrace();
        }
    }
}
