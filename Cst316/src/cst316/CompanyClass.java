package cst316;


import java.util.TreeMap;

public class CompanyClass 
{
    String playerName;
    int totalHired;
    String companyName;
    public  TreeMap<String, Building> buildingsTree = new TreeMap<String, Building>(); // treemap - sorted, ordered
    public TreeMap<String, Product> productsTree= new TreeMap<String, Product>(); 
    public TreeMap<String, ResearchDevelObject> researchDevObjTree = new TreeMap<String, ResearchDevelObject>(); 

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTotalHired() {
        return totalHired;
    }

    public void setTotalHired(int totalHired) {
        this.totalHired = totalHired;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}
