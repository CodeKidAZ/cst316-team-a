package cst316;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Company 
{
    String name;
    
    private ArrayList<Product> myProducts;
    private ArrayList<ResearchDevelObject> myRandD;
    private int employees;

    public Company(String name){
    	this.name = name;
    	this.employees = 0;
    	this.myProducts = new ArrayList<Product>();
    	
    } 
    
	public Company(JSONObject jsonObject) throws Exception {
        this.name = jsonObject.getString("companyName");
        //this.employees = jsonObject.getInt("Employees");
    }
	
    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", this.name);
        return jsonObject.toString(); //Return the JSON string
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
   public void addProducts(Product prod){
	   myProducts.add(prod);
   }
   public void addRandD(ResearchDevelObject rd){
	   myRandD.add(rd);
   } 
   public int getEmployees() {
		return employees;
	}
	public void setEmployees(int employees) {
		this.employees = employees;
	}
	public void addEmployees(int employees) {
		this.employees += employees;
	}
}
