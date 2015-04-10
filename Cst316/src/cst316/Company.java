package cst316;


import java.util.ArrayList;
import java.util.TreeMap;

public class Company 
{
   // String playerName;
    String companyName;
    
  
	private ArrayList<Product> myProducts;
    private ArrayList<ResearchDevelObject> myRandD;
    private ArrayList<Employee> myEmployees;
    
    public Company(String cname){
    	this.companyName = cname;
    }
    //___________________________________________GET
  
    public String getCompanyName() {
  		return companyName;
  	}
    public ArrayList<Product> getProducts(){	
    	return myProducts;
    }
    public ArrayList<ResearchDevelObject> getRandD() {
		return myRandD;
    }
    public ArrayList<Employee> getMyEmployees(){
    	return myEmployees;
    }
    //___________________________________________SET
    public void setCompanyName(String cname){
    	this.companyName = cname;
    }
   public void addProducts(Product prod){
	   myProducts.add(prod);
   }
   public void addRandD(ResearchDevelObject rd){
	   myRandD.add(rd);
   }
   public void addEmployees(Employee emp){
	   myEmployees.add(emp);
   }   
}
