package fr.afcepf.al28.livraison.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.al28.livraison.biz.api.IBusinessPreparateur;
import fr.afcepf.al28.livraison.biz.impl.BusinessPreparateur;
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
public class TestBusinessCreationLivraison {
    /**
     * Date pévue de la libvraison nominale.
     */
    private String dateDepartNominale = "31/12/2016 23:50";
    /**
     * Date prévue de la livraison échec.
     */
    private String dateDepartEchec = "22/09/2016 09:30";
    /**
     * Pour manipuler les dates.
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    /**
     * ID du {@link Preparateur}.
     */
    private static final int ID_PREPARATEUR = 1;
    /**
     * Le préparateur de la {@link Commande}.
     */
    private Preparateur preparateur = new Preparateur(ID_PREPARATEUR, "preparateur test1", "test1", null);
    /**
     * Numéro de {@link Commande} à livrer.
     */
    private static final int NUMERO_COMMANDE = 6;
    /**
     * La commande à livrer.
     */
    private Commande commande = new Commande(NUMERO_COMMANDE, "preparée", null, preparateur);
    /**
     * Exception attendue dans l'échec.
     */
    private QualitEnum expectedEchec = QualitEnum.PAS_DE_LIVREUR_DISPO;
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
    private Livreur expectedLivreur = new Livreur(ID_NOUR, "nour", "nour");
    /**
     * livraison  attendue.
     */
    private Livraison expectedLivraison = new Livraison(NUMERO_LIVRAISON, null, null, preparateur, expectedLivreur, commande);
    /**
     * livraison nominale.
     */
    private Livraison livraisonNominale = new Livraison(null, null, null, preparateur, null, commande);
    /**
     * livraison échec.
     */
    private Livraison livraisonEchec = new Livraison(null, null, null, preparateur, null, commande);
    /**
     * Api contenant le sevice à tester.
     */
    private IBusinessPreparateur bu = new BusinessPreparateur() {
        /**
         * Mock de la méthode créer
         */
        @Override
        public Livraison creer(Livraison paramLiv) throws QualitException {
            if (paramLiv == livraisonNominale) {
                paramLiv.setLivreur(expectedLivreur);
                paramLiv.setId(NUMERO_LIVRAISON);
            } else {
                throw new QualitException("", QualitEnum.PAS_DE_LIVREUR_DISPO);
            }
            return paramLiv;
        };
    };
    /**
     * Constructeur défaut.
     */
    public TestBusinessCreationLivraison() {
        try {
            livraisonNominale.setDateDepart(sdf.parse(dateDepartNominale));
            livraisonEchec.setDateDepart(sdf.parse(dateDepartEchec));
            expectedLivraison.setDateDepart(sdf.parse(dateDepartNominale));
        } catch (ParseException paramE) {
            paramE.printStackTrace();
        }
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
