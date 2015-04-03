package cst316;

import java.util.ArrayList;

public class ResearchAndDevelopment {
	ArrayList<ResearchDevelObject> resDevObjs = new ArrayList<ResearchDevelObject>();
	Player p;
	
	public ResearchAndDevelopment() {
		generateResDevObjs();
	}
	
	public ResearchAndDevelopment(Player p) {
		this.setPlayer(p);
		generateResDevObjs();
	}
	
	//Custom list of research and development choices for the player, change as needed
	public void generateResDevObjs() {
		ResearchDevelObject materials = new ResearchDevelObject(5,5,"materials");
		ResearchDevelObject mediaTrends = new ResearchDevelObject(10,8,"mediaTrends");
		ResearchDevelObject technology = new ResearchDevelObject(15,11,"technology");
		ResearchDevelObject strategies = new ResearchDevelObject(20,14,"strategies");
		ResearchDevelObject commercial = new ResearchDevelObject(25,17,"commercial");
		ResearchDevelObject scienceLab = new ResearchDevelObject(30,20,"scienceLab");
		resDevObjs.add(materials);
		resDevObjs.add(mediaTrends);
		resDevObjs.add(technology);
		resDevObjs.add(strategies);
		resDevObjs.add(commercial);
		resDevObjs.add(scienceLab);
	}
	
	//Returns a RDObject if it exists
	public ResearchDevelObject getResDevObjsElement(String str) {
		for(int i=0; i<resDevObjs.size(); i++) {
			if(resDevObjs.get(i).getName().equals(str))
				return resDevObjs.get(i);
		}
		return null;
	}
	
	//Getters and Setters
	public ArrayList<ResearchDevelObject> getResDevObjs() {
		return resDevObjs;
	}

	public void setResDevObjs(ArrayList<ResearchDevelObject> resDevObjs) {
		this.resDevObjs = resDevObjs;
	}
	
	//Use this to attach the player class to this class
	public void setPlayer(Player p) {
		this.p = p;
	}
	
	//Return the player class back to update his/her assets 
	public Player getPlayer() {
		return this.p;
	}
}
