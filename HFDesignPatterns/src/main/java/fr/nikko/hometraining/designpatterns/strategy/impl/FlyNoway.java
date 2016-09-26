package fr.nikko.hometraining.designpatterns.strategy.impl;

import fr.nikko.hometraining.designpatterns.strategy.api.FlyBehavior;
/**
 * Implémentation de comportement vol en nePasVoler.
 * @author nikko
 *
 */
public class FlyNoway implements FlyBehavior {

    @Override
    public final void fly() {
        System.out.println("je ne peux pas voler!");

    }

}
