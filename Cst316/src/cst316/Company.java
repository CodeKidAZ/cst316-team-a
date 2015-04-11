package cst316;

import java.util.ArrayList;

public class Company 
{
    String companyName;
    
    private ArrayList<Product> myProducts;
    private ArrayList<ResearchDevelObject> myRandD;
    private ArrayList<Employee> myEmployees;
    
    public Company(String companyName){
    	this.companyName = companyName;
    }
    public void setCompanyName(String companyName){
    	this.companyName = companyName;
    }
    public String getCompanyName() {
    	return companyName;
    }
    public ArrayList<Product> getProducts(){	
    	return myProducts;
    }
    public ArrayList<ResearchDevelObject> getRandD() {
		return myRandD;
    }
    public ArrayList<Employee> myEmployees(){
    	return myEmployees();
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
