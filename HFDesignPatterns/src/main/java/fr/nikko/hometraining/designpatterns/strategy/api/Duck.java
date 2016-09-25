package fr.nikko.hometraining.designpatterns.strategy.api;

/**
 * La Classe Canard.
 * @author nikko
 *
 */
public abstract class Duck {
    /**
     * Instance Interface Comportement Vol.
     */
    private FlyBehavior flyBehavior;
    /**
     * Instance interface comportement cancaner.
     */
    private QuackBehavior quackBehavior;
    /**
     * Constructeur par défaut.
     */
    public Duck() {
        super();
    }
    /**
     * méthode effectuerVol().
     */
    public final void performFly() {
        flyBehavior.fly();
    }
    /**
     * méthode effectuerCancanement().
     */
    public final void performFQuack() {
        quackBehavior.quack();
    }
    /**
     * méthode nager.
     */
    public final void swim() {
        System.out.println("Tous les canards flottent mêment les appeaux!");
    }
    /**
    *accesseur pour le comportement de vol.
    *@return comportement de vol
    */
    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }
    /**
    *mutateur pour le comportement de vol.
    *@param paramFlyBehavior comportement de vol
    */
    public void setFlyBehavior(FlyBehavior paramFlyBehavior) {
        flyBehavior = paramFlyBehavior;
    }
    /**
    *accesseur pour le comportement de cancanement.
    *@return comotement de cancanement
    */
    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }
    /**
    *mutateur pour le comportement de cancanement.
    *@param paramQuackBehavior comportement de cancanement
    */
    public void setQuackBehavior(QuackBehavior paramQuackBehavior) {
        quackBehavior = paramQuackBehavior;
    }
}
