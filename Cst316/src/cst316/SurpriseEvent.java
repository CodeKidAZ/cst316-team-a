package cst316;

/**
 * Description: A class that gives the player a surprise event with different
 * outcomes or situations that affect that player stats.
 * This is used to simulate uncontrollable market or company events.
 * 
 * @author daniel
 *
 */
public class SurpriseEvent {
	private String eventTxt;
	private Player player;
	/**
	 * Default constructor
	 */
	public SurpriseEvent() {
		setPlayer(new Player());
		setEventTxt("blank");
	}
	/**
	 * Constructor that points this class's player to the one of the calling class
	 * @param player
	 */
	public SurpriseEvent(Player player) {
		setPlayer(player);
	}
	
	//Getters and setters
	public String getEventTxt() {
		return eventTxt;
	}

	public void setEventTxt(String eventTxt) {
		this.eventTxt = eventTxt;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * Generates an event based on a random number provided.
	 * A multiplier is also generated and rewards/deductions are created based on it.
	 */
	public void createEvent(int whichEvent, int multiplier) {
		switch(whichEvent) {
		case(1):
			setEventTxt("Employee are getting frustraited with current "
					+ "\nwork conditions and some quit on the spot."
					+ "\nEffect: You lose employees.");
			this.player.addEmployees(1 * multiplier);
			break;
		case(2):
			setEventTxt("Your company was featured in a YouTube video that received"
					+ "\nover a million hits, free advertising!"
					+ "\nEffect: Your company's point value rises.");
		this.player.addPoints(2 * multiplier);
			break;
		case(3):
			setEventTxt("Stocks plummet and people are being more careful with their"
					+ "\nmoney. Your business is seeing lower than usual profit margins."
					+ "\nEffect: Your company's point value decreases.");
			this.player.addPoints(2 * multiplier);
			break;
		case(4):
			setEventTxt("Eager graduate students who have received very high grades"
					+ "\nare looking for an intership with the company, free labor!"
					+ "\nEffect: You gain employees.");
			this.player.addEmployees(1 * multiplier);
			break;
		case(5):
			setEventTxt("The government is giving huge tax returns this year"
					+ "\nand you are no exception, lucky!"
					+ "\nEffect: You gain a sizeable wad of cash!");
			this.player.addMoney(80 * multiplier);
			break;
		}

	}
}
