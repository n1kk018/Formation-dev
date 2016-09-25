package fr.nikko.hometraining.designpatterns.strategy.impl;

import fr.nikko.hometraining.designpatterns.strategy.api.Duck;
/**
 * Implementation de canad en canard en plastoc.
 * @author nikko
 *
 */
public class ModelDuck extends Duck {
    /**
     * Constructeur.
     */
    public ModelDuck() {
        super.setFlyBehavior(new FlyNoway());
        super.setQuackBehavior(new Squeak());
    }
    /**
     * afficher.
     */
    public void display() {
        System.out.println("Je suis un canrd en plastique!");
    }
}
