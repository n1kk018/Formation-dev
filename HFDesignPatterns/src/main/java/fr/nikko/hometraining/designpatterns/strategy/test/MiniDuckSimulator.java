package fr.nikko.hometraining.designpatterns.strategy.test;

import fr.nikko.hometraining.designpatterns.strategy.api.Duck;
import fr.nikko.hometraining.designpatterns.strategy.impl.FlyWithRockets;
import fr.nikko.hometraining.designpatterns.strategy.impl.MallardDuck;
import fr.nikko.hometraining.designpatterns.strategy.impl.ModelDuck;

/**
 * Test du pattern strategy.
 * @author nikko
 *
 */
public class MiniDuckSimulator {
    /**
     * Point d'entrée de l'app.
     * @param args arguments en entrée de l'app
     */
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFQuack();
        mallard.performFly();
        ((MallardDuck) mallard).display();
        Duck model = new ModelDuck();
        model.performFQuack();
        model.performFly();
        model.setFlyBehavior(new FlyWithRockets());
        model.performFly();
        ((ModelDuck) model).display();
    }

}
