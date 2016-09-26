package fr.nikko.hometraining.designpatterns.strategy.impl;

import fr.nikko.hometraining.designpatterns.strategy.api.FlyBehavior;
/**
 * Implémentation de l'interface vol en voler avec des ailes.
 * @author nikko
 *
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public final void fly() {
        System.out.println("Je vole!");
    }

}
