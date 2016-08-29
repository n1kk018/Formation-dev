package fr.afcepf.al28.thread;

import java.util.concurrent.Semaphore;

public class TestThread {

	public static void main(String[] args) {
		MyStock stockCommun = new MyStock(8000);
		ResaTask task = new ResaTask(stockCommun);
		Semaphore syncObj = new Semaphore(0);
		task.setSyncObject(syncObj);
		for(int i=0;i<4;i++){
			new Thread(task).start();
		}
		try {
			syncObj.acquire(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("qte en stock apres 4000 réservations : " + stockCommun.getQte());
	}
}