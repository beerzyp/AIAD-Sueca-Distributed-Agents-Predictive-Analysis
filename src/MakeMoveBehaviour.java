import java.util.Random;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class MakeMoveBehaviour extends Behaviour{
//	private Round ronda;
//	private Mao hand;
	private Jogo sueca;
	private int player;
	public MakeMoveBehaviour(Jogo sueca,int jogador) {
		this.sueca=sueca;
		this.player=jogador;
	}
	@Override
	public void action() {
		final ACLMessage request= this.myAgent.blockingReceive();
		
		String message = request.getContent();
		
		System.out.println(message);
		//SEND PLAY TO LOGIC
		ACLMessage inform= new ACLMessage(ACLMessage.REQUEST);
		inform.addReceiver(new AID("gameAgent", AID.ISLOCALNAME));
		inform.setLanguage("Portugues");
		inform.setOntology("Sueca-Jogada");
		String cartaValue=this.returnPLay().toString();
		inform.setContent(cartaValue);
		this.myAgent.send(inform);
		System.out.println("agent " + this.myAgent.getAID().getLocalName() + "\n");
	}
	
	public Carta returnPLay() {
		Random r = new Random();
		int Low = 0;
		int High = this.sueca.getPlayer(this.player).getPlayerHand().getMao().size();
		int Result = r.nextInt(High-Low) + Low;
		return this.sueca.getPlayer(this.player).getPlayerHand().getCartaAt(Result);

	}
	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
