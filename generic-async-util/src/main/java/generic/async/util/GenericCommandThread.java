package generic.async.util;



public class GenericCommandThread implements Runnable {
	
	private long delay; //en ms
	private Command command;
	
	public GenericCommandThread(){
	super();	
	}
	
	public GenericCommandThread(long delay,Command command){
		this.delay=delay;
		this.command=command;
	}

	@Override
	public void run() {
		//System.out.println("" + delay  +" ms de pause");
		try {
			Thread.sleep(delay); //ex 5 * 1000 ms = 5s
			command.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void executeCommandAfterDelay(long delay,Command command){
		Thread t = new Thread (new GenericCommandThread(delay,command));
		t.start();
	}

}
