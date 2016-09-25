package fr.nikko.hometraining.designpatterns.strategy.impl;

import fr.nikko.hometraining.designpatterns.strategy.api.QuackBehavior;
/**
 * Implémentation du comportement cancaner en cancaner.
 * @author nikko
 *
 */
public class Quack implements QuackBehavior {

    @Override
    public final void quack() {
        System.out.println("Coin-coin!");
    }

}
