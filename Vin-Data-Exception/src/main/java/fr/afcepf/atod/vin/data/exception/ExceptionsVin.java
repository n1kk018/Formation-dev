/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.vin.data.exception;

/**
 * Exceptions personnalisees pour notre projet
 * @author ronan
 */
public class ExceptionsVin extends Exception {
    /**
     * erreur generique dans l'enumeration
     */
    private CodeErreurVin erreurVin;
    
    /**
     * 
     * @param message 
     */
    public ExceptionsVin(String message){
        super(message);
    }
    /**
     * 
     * @param erreurVin
     * @param message 
     */
    public ExceptionsVin(CodeErreurVin erreurVin, String message) {
        super(message);
        this.erreurVin = erreurVin;
    }
    

    public CodeErreurVin getErreurVin() {
        return erreurVin;
    }

    public void setErreurVin(CodeErreurVin erreurVin) {
        this.erreurVin = erreurVin;
    }
}
