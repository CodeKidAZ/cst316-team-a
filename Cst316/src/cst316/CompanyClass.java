package cst316;


import java.util.TreeMap;

public class CompanyClass 
{
    String playerName;
    int totalHired;
    String companyName;
    private TreeMap<String, Building> buildingsTree = new TreeMap<String, Building>(); // treemap - sorted, ordered
    private TreeMap<String, Product> productsTree= new TreeMap<String, Product>(); 
    private TreeMap<String, ResearchDevelObject> researchDevObjTree = new TreeMap<String, ResearchDevelObject>(); 

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

    public TreeMap<String, Building> getBuildingsTree() {
        return buildingsTree;
    }

    public void setBuildingsTree(TreeMap<String, Building> buildingsTree) {
        this.buildingsTree = buildingsTree;
    }

    public TreeMap<String, Product> getProductsTree() {
        return productsTree;
    }

    public void setProductsTree(TreeMap<String, Product> productsTree) {
        this.productsTree = productsTree;
    }

    public TreeMap<String, ResearchDevelObject> getResearchDevObjTree() {
        return researchDevObjTree;
    }

    public void setResearchDevObjTree(TreeMap<String, ResearchDevelObject> researchDevObjTree) {
        this.researchDevObjTree = researchDevObjTree;
    }
    
}
