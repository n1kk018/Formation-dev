/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.vin.data.api;

import fr.afcepf.atod.vin.data.exception.ExceptionsVin;
import fr.afcepf.atod.vin.entity.Product;
import java.util.Set;

/**
 *
 * @author ronan
 */
public interface IDaoGestionVin {
    // remplacer les entities par les dtos
    Product addProduct(Product product) throws ExceptionsVin;
    boolean rmProduct(Product product) throws ExceptionsVin;
    Set<Product> findProducts(String name) throws ExceptionsVin;
}
