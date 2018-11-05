package Agents;

import Behaviours.MakeMoveBehaviour;
import Behaviours.getCortaPlay;
import GameLogic.Jogador;
import GameLogic.Jogo;
import jade.core.Agent;

public class CortaAGENT extends Agent{

	private Jogo sueca;

	public CortaAGENT(Jogo sueca) {
		this.sueca = sueca;	
	}
	
	public void setup() {
		addBehaviour(new getCortaPlay(this.sueca));
	}
	
	protected void takeDown() {

	}
	
}
