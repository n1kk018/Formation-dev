package fr.nikko.hometraining.designpatterns.strategy.impl;

import fr.nikko.hometraining.designpatterns.strategy.api.QuackBehavior;
/**
 * Implémentation du comportement cancaner en silence.
 * @author nikko
 *
 */
public class MuteQuack implements QuackBehavior {

    @Override
    public final void quack() {
        System.out.println("<< Silence >>");

    }

}
