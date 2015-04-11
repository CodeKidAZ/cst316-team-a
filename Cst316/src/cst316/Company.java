package cst316;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Company 
{
    String name;
    
    private ArrayList<Product> myProducts;
    private ArrayList<ResearchDevelObject> myRandD;
    private ArrayList<Employee> myEmployees;
    
    public Company(JSONObject jsonObject) throws Exception {
        this.name = jsonObject.getString("companyName");
    }
    
    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", this.name);
        return jsonObject.toString(); //Return the JSON string
    }
    
    public Company(String name){
    	this.name = name;
    }
    public void setname(String name){
    	this.name = name;
    }
    public String getCompanyName() {
    	return name;
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
