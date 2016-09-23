package fr.afcepf.al28.livraison.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.afcepf.al28.livraison.biz.api.IBusinessPreparateur;
import fr.afcepf.al28.livraison.biz.impl.BusinessPreparateur;
import fr.afcepf.al28.livraison.data.api.IDaoLivraison;
import fr.afcepf.al28.livraison.data.api.IDaoLivreur;
import fr.afcepf.al28.livraison.entities.Commande;
import fr.afcepf.al28.livraison.entities.Livraison;
import fr.afcepf.al28.livraison.entities.Livreur;
import fr.afcepf.al28.livraison.entities.Preparateur;
import fr.afcepf.al28.livraison.exceptions.QualitEnum;
import fr.afcepf.al28.livraison.exceptions.QualitException;

/**
 * Test de la création d'une livraison par le {@link Preparateur}
 * dans la couche biz de l'app.
 * @author stagiaire
 *
 */
public class TestBusinessCreationLivraisonavecMockData {
    /**
     * Date pévue de la libvraison nominale.
     */
    private static String dateDepartNominale = "31/12/2016 23:50";
    /**
     * Date prévue de la livraison échec.
     */
    private static  String dateDepartEchec = "22/09/2016 09:30";
    /**
     * Pour manipuler les dates.
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    /**
     * ID du {@link Preparateur}.
     */
    private static final int ID_PREPARATEUR = 1;
    /**
     * Le préparateur de la {@link Commande}.
     */
    private static Preparateur preparateur = new Preparateur(ID_PREPARATEUR, "preparateur test1", "test1", null);
    /**
     * Numéro de {@link Commande} à livrer.
     */
    private static final int NUMERO_COMMANDE = 6;
    /**
     * La commande à livrer.
     */
    private static Commande commande = new Commande(NUMERO_COMMANDE, "preparée", null, preparateur);
    /**
     * Exception attendue dans l'échec.
     */
    private static QualitEnum expectedEchec = QualitEnum.PAS_DE_LIVREUR_DISPO;
    /**
     * id de la livraison attendue.
     */
    private static final int NUMERO_LIVRAISON = 5;
    /**
     * id du livreur.
     */
    private static final int ID_NOUR = 1;
    /**
     * livreur de la livraison nominale.
     */
    private static Livreur expectedLivreur = new Livreur(ID_NOUR, "nour", "nour");
    /**
     * livraison  attendue.
     */
    private static Livraison expectedLivraison = new Livraison(NUMERO_LIVRAISON, null, null, preparateur, expectedLivreur, commande);
    /**
     * livraison nominale.
     */
    private static Livraison livraisonNominale = new Livraison(null, null, null, preparateur, null, commande);
    /**
     * livraison échec.
     */
    private static Livraison livraisonEchec = new Livraison(null, null, null, preparateur, null, commande);
    /**
     * Api contenant le sevice à tester.
     */
    private static IBusinessPreparateur bu = new BusinessPreparateur();
    /**
     * Mock de la couche de persistence pour le {@link Livreur}.
     */
    private static IDaoLivreur mockDaoLivreur;
    /**
     * Mock de la couche de persistence pour la {@link Livraison}.
     */
    private static IDaoLivraison mockDaoLivraison;
    /**
     * Avantt tous les tests.
     * @throws QualitException pour le mock.
     * @throws ParseException pour le mock.
     */
    @BeforeClass
    public static void avantTousLesTests() throws QualitException, ParseException {
        livraisonNominale.setDateDepart(sdf.parse(dateDepartNominale));
        livraisonEchec.setDateDepart(sdf.parse(dateDepartEchec));
        expectedLivraison.setDateDepart(sdf.parse(dateDepartNominale));
        mockDaoLivraison = EasyMock.createMock(IDaoLivraison.class);
        mockDaoLivreur = EasyMock.createMock(IDaoLivreur.class);
        EasyMock.expect(mockDaoLivreur.rechercher(
                livraisonEchec.getDateDepart()))
                .andReturn(new ArrayList<>());
        List<Livreur> liste = new ArrayList<Livreur>();
        liste.add(expectedLivreur);
        EasyMock.expect(mockDaoLivreur.rechercher(
                livraisonNominale.getDateDepart()))
                .andReturn(liste);
        EasyMock.expect(mockDaoLivraison
                .creer(livraisonNominale))
                .andReturn(expectedLivraison);
        EasyMock.replay(mockDaoLivraison);
        EasyMock.replay(mockDaoLivreur);
        ((BusinessPreparateur) bu).setDaoLivraison(mockDaoLivraison);
        ((BusinessPreparateur) bu).setDaoLivreur(mockDaoLivreur);
    }
    /**
     * Aprés tous les tests.
     */
    @AfterClass
    public static void apresTousLesTests() {
        EasyMock.verify(mockDaoLivraison);
        EasyMock.verify(mockDaoLivreur);
    }
    /**
     * Test du cas ou Nour est dispo.
     * @throws QualitException caca.
     */
    @Test
    public void testNominal() throws QualitException {
        Livraison retour = bu.creer(livraisonNominale);
        Assert.assertNotNull(retour);
        Assert.assertNotNull(retour.getId());
        Assert.assertNotNull(retour.getLivreur());
        Assert.assertNotNull(retour.getDateDepart());
        Assert.assertNotNull(retour.getCmd());
        Assert.assertNotNull(retour.getPreparateur());
        Assert.assertNull(retour.getDateArrivee());
        Assert.assertEquals(expectedLivraison.getId(), retour.getId());
        Assert.assertEquals(expectedLivraison.getDateDepart(), retour.getDateDepart());
        Livreur livreurRetour = retour.getLivreur();
        Assert.assertNotNull(livreurRetour.getId());
        Assert.assertNotNull(livreurRetour.getNom());
        Assert.assertNotNull(livreurRetour.getPrenom());
        Assert.assertEquals(expectedLivreur.getId(), livreurRetour.getId());
        Assert.assertEquals(expectedLivreur.getNom(), livreurRetour.getNom());
        Assert.assertEquals(expectedLivreur.getPrenom(), livreurRetour.getPrenom());
    }
    /**
     * Test du cas ou Nour est pas dispo.
     */
    @Test
    public void testEchec() {
        try {
            bu.creer(livraisonEchec);
            Assert.fail("livraison créée... pas normal!");
        } catch (QualitException paramE) {
            Assert.assertEquals(expectedEchec, paramE.getCodeErreur());
        }
    }
}
