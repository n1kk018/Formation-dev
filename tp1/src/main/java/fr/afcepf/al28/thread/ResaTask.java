package fr.afcepf.al28.thread;

import java.util.concurrent.Semaphore;

public class ResaTask implements Runnable {
	
	private MyStock stock;
	private Semaphore syncObject; //référence sur objet de synchro

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ " start");
		for(int i=0; i<1000;i++){
			  //réserver un produit et décrémenter le stock:
			     //...
			  synchronized(stock){
				 //... 
			     stock.setQte( stock.getQte() - 1) ;
			  }
		  }
		  if(syncObject!=null){
			  synchronized(syncObject){ 
				  System.out.println("appel release");
				  syncObject.release(); //avertir fin de travail du Thread
			  }
		  }
		System.out.println(Thread.currentThread().getName()+ " stop");
	}
	

	public Semaphore getSyncObject() {
		return syncObject;
	}


	public void setSyncObject(Semaphore syncObject) {
		this.syncObject = syncObject;
	}


	public ResaTask(MyStock stock) {
		super();
		this.stock = stock;
	}

	public MyStock getStock() {
		return stock;
	}

	public void setStock(MyStock stock) {
		this.stock = stock;
	}

}
