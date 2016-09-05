/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.vin.data.impl;

import fr.afcepf.atod.vin.data.api.IDaoGestionVin;
import fr.afcepf.atod.vin.data.exception.CodeErreurVin;
import fr.afcepf.atod.vin.data.exception.ExceptionsVin;
import fr.afcepf.atod.vin.entity.Product;
import java.util.Set;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ronan
 */
@Service
@Transactional
public class DaoGestionVin implements IDaoGestionVin {
    
    private SessionFactory sf;
    @Autowired
    public void setMaSessionFactory(SessionFactory sf) 
            throws ExceptionsVin {
        this.sf = sf;
    }
    
    /*****************************************************.
     *                  Requetes HQL
     ****************************************************/

   

    /****************************************************.
     *                 Fin Requetes HQL
     ****************************************************/
    
    
    @Override
    public Product addProduct(Product product) 
            throws ExceptionsVin {
        
       if (!product.getName().equals("") && 
               !product.getPrice().equals("")) {
           // on devra convertir dto to entity
           sf.getCurrentSession().save(product);
       } else {
           throw new ExceptionsVin(CodeErreurVin.IMPOSSIBLE_AJOUT_DANS_BASE,
           "ajouter un produit n'est pas possible");
       }
        
        return product; 
    }

    @Override
    public boolean rmProduct(Product product)  
            throws ExceptionsVin {
       return false;
    }

    @Override
    public Set<Product> findProducts(String name)  
            throws ExceptionsVin {
        return null;
    }
    
}
