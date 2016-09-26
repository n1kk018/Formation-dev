package fr.nikko.hometraining.designpatterns.strategy.impl;

import fr.nikko.hometraining.designpatterns.strategy.api.Duck;
/**
 * Specialisation de la classe canard.
 * @author nikko
 *
 */
public class MallardDuck extends Duck {
    /**
     * Constructeur.
     */
    public MallardDuck() {
        super.setQuackBehavior(new Quack());
        super.setFlyBehavior(new FlyWithWings());
    }
    /**
     * méthode afficher.
     */
    public void display() {
        System.out.println("Je suis un vrai canrd mandarin!");
    }
}
