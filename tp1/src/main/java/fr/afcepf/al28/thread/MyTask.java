package fr.afcepf.al28.thread;

public class MyTask implements Runnable {
	
	private int n;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public MyTask() {
		super();
		this.n = 4;
	}

	@Override
	public void run() {
		int i = n;
		while (i>0){
			System.out.println(Thread.currentThread().getName() + "-->" + i--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
