package fr.afcepf.al8.patterns;

public class DistributeurTicket //Singleton ThreadSafe
{
	static{//ts
		instance = new DistributeurTicket();
	}
	private int numeroCourant;
	private static DistributeurTicket instance;
	
	private DistributeurTicket() 
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Constructeur du distributeur");
		numeroCourant = 0;
	}
	
	public static DistributeurTicket getInstance()
	{
		/*if(instance==null){
			instance = new DistributeurTicket();
		}*/
		return instance;
	}

	public synchronized/*ts*/ int getNumero() {
		return ++numeroCourant;
	}
	
	
}

	
