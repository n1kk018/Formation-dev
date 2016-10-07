package generic.util.local.interaction;

import generic.util.interaction.UserInteraction;

import javax.swing.JOptionPane;

public class LocalSwingMessageDialog implements UserInteraction{
	
	public String msgDialog(String message,String contextTitle){
		String response=null;
		if(contextTitle==null)
		    response=JOptionPane.showInputDialog(null,message);
		else response=JOptionPane.showInputDialog(null,message,contextTitle,JOptionPane.QUESTION_MESSAGE);
		return response;
	}
	
	public boolean confirmDialog(String messageToConfirm,String contextTitle){
		int res=0;
		if(contextTitle==null)
		    res = JOptionPane.showConfirmDialog(null,messageToConfirm,"confirmation",JOptionPane.OK_CANCEL_OPTION);
		else res = JOptionPane.showConfirmDialog(null,messageToConfirm,contextTitle,JOptionPane.YES_NO_OPTION);
		if(res==JOptionPane.YES_OPTION || res==JOptionPane.OK_OPTION)
			return true;
		else return false;
	}

	@Override
	public String replyMsgToRequestMsg(String message,String contextTitle) {
		return msgDialog(message,contextTitle);
	}

	@Override
	public boolean confirmMsg(String message,String contextTitle) {
		return confirmDialog(message,contextTitle);
	}

}
