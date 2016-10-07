package generic.util.local.interaction.test;
import generic.util.interaction.UserInteraction;
import generic.util.local.interaction.LocalConsoleUserInteraction;


public class LocalConsoleUserInteractionTestApp {

	public static void main(String[] args) {
		
		UserInteraction userInteraction = new LocalConsoleUserInteraction();
		System.out.println("crazy or not : "  + userInteraction.confirmMsg("are you crazy", "verification"));
		System.out.println("destroy this computer : "  + userInteraction.confirmMsg("destroy this computer", null));

		System.out.println("couleur preferee : "  + userInteraction.replyMsgToRequestMsg("quelle est votre couleur preferee", null));
		System.out.println("sport prefere (en vacances): "  + userInteraction.replyMsgToRequestMsg("quel est votre sport prefere", "en vacances"));

	}

}
