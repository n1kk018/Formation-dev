package generic.util.local.interaction;

import generic.util.interaction.UserInteraction;

import java.util.Scanner;

public class LocalConsoleUserInteraction implements UserInteraction{
	
	//code à  peaufiner ....

	@Override
	public String replyMsgToRequestMsg(String message,String contextTitle) {
		String replyMsg =  null;
		if(contextTitle!=null)
			System.out.print("[context: " + contextTitle + "] ");
		System.out.println("requestMessage: " + message);
		System.out.print("responseMessage: ");
		
		@SuppressWarnings("resource") //no close System.in
		Scanner reader = new Scanner(System.in);
		reader.reset();
		replyMsg = reader.next();
		return replyMsg;
	}

	@Override
	public boolean confirmMsg(String message,String contextTitle) {
		boolean res =  false;
		if(contextTitle!=null)
			System.out.print("[context: " + contextTitle + "] ");
		System.out.println("message to confirm: " + message +  "?");
		System.out.print("response (y[es]/n[o]):");
		
		@SuppressWarnings("resource")  //no close System.in 
		Scanner reader = new Scanner(System.in);
		reader.reset();
		String sRes = reader.next();
		if(sRes!=null && sRes.length()>=1 && sRes.substring(0, 1).toLowerCase().equals("y"))
			res=true;
		return res;
	}

}
