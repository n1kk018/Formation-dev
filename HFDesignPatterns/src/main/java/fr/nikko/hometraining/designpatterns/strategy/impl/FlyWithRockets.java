package fr.nikko.hometraining.designpatterns.strategy.impl;

import fr.nikko.hometraining.designpatterns.strategy.api.FlyBehavior;
/**
 * Implementation de comportement de vol en voler avec des roquettes.
 * @author nikko
 *
 */
public class FlyWithRockets implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Je vole avec ds roquettes!");

    }

}
