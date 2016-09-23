package fr.afcepf.al28.livraison.biz.impl;

import java.util.List;

import fr.afcepf.al28.livraison.biz.api.IBusinessPreparateur;
import fr.afcepf.al28.livraison.data.api.IDaoLivraison;
import fr.afcepf.al28.livraison.data.api.IDaoLivreur;
import fr.afcepf.al28.livraison.entities.Livraison;
import fr.afcepf.al28.livraison.entities.Livreur;
import fr.afcepf.al28.livraison.exceptions.QualitEnum;
import fr.afcepf.al28.livraison.exceptions.QualitException;
/**
 * Implémentation des services métiers.
 * @author stagiaire
 *
 */
public class BusinessPreparateur implements IBusinessPreparateur {
    /**
     * dépendance vers {@link IDaoLivreur}
     */
    private IDaoLivreur daoLivreur;
    /**
     * dépendance vers {@link IDaoLivraison}.
     */
    private IDaoLivraison daoLivraison;
    @Override
    public Livraison creer(Livraison paramLiv) throws QualitException {
        List<Livreur> livreurs = daoLivreur.rechercher(paramLiv.getDateDepart());
        if (livreurs.isEmpty()) {
            throw new QualitException("nour pas rentré", QualitEnum.PAS_DE_LIVREUR_DISPO);
        } else {
            paramLiv.setLivreur(livreurs.get(0));
            paramLiv = daoLivraison.creer(paramLiv);
        }
        return paramLiv;
    }
    /**
     * Pour injection CDI ou Spring ou EJB.
     * @param paramDaoLivreur the daoLivreur to set
     */
    public void setDaoLivreur(IDaoLivreur paramDaoLivreur) {
        daoLivreur = paramDaoLivreur;
    }
    /**
     * Pour injection CDI ou Spring ou EJB.
     * @param paramDaoLivraison the daoLivraison to set
     */
    public void setDaoLivraison(IDaoLivraison paramDaoLivraison) {
        daoLivraison = paramDaoLivraison;
    }
}
