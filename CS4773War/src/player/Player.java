package player;

import pile.*;
public class Player {

	String name;
	Pile pile;
	public Player(String name) {
		this.name = name;
		pile = new Pile();
	}

}
