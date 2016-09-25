package fr.nikko.hometraining.designpatterns.strategy.impl;

import fr.nikko.hometraining.designpatterns.strategy.api.QuackBehavior;
/**
 * Implémentation du comportement cancaner en couiner.
 * @author nikko
 *
 */
public class Squeak implements QuackBehavior {
    @Override
    public final void quack() {
        System.out.println("Pwee-pwee!");

    }

}
