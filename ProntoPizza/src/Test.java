import fr.afcepf.al28.pizzeria.Pizza;
import fr.afcepf.al28.pizzeria.Pizzeria;
import fr.afcepf.al28.pronto.factories.Cheesy4SaisonsFactory;
import fr.afcepf.al28.pronto.factories.HawaiCheesyFactory;

public class Test {

	public static void main(String[] args) {
		Pizzeria p = new Pizzeria();
		
		Pizza p1 = p.creerPizza(new HawaiCheesyFactory());
		Pizza p2 = p.creerPizza(new Cheesy4SaisonsFactory());

	}

}
