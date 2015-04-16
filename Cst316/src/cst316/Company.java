package cst316;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Company 
{
    String name;
  
	private ArrayList<Product> myProducts;
    private ArrayList<ResearchDevelObject> myRandD;
    private double employees;
    private StringProperty cname;

    public Company(String name){
    	this.name = name;
    	
    	this.employees = 0;
    	this.myProducts = new ArrayList<Product>();
    	
    } 
    /**
     * Creates a company based on JSON values in a text file
     * @param jsonObject
     * @throws Exception
     */
	public Company(JSONObject jsonObject) throws Exception {
        this.name = jsonObject.getString("companyName");
        this.employees = jsonObject.getDouble("employees");
        
        try {
		JSONArray jArrayProducts = jsonObject.getJSONArray("products");
		ArrayList<Product> tempProducts = new ArrayList<Product>();
        
		for (int i = 0; i != jArrayProducts.length(); ++i) {
			tempProducts.add(new Product(jArrayProducts.getJSONObject(i)));
		}
		
        this.myProducts = tempProducts;
        } catch (Exception e) {
        	System.out.println("Failed to read products inside company class.");
        }
        
    }
	
    public String toJSONString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", this.name);
        return jsonObject.toString(); //Return the JSON string
    }
    
    public void setname(String name){
    	this.name = name;
    }
    //___________________________________________GET
    public String getCompanyName() {
    	return name;
    }
    public StringProperty getNameProperty()
	{
    	cname = new SimpleStringProperty(name);
    	//cname.set(name);
		return cname;
	}
    public ArrayList<Product> getProducts(){	
    	return myProducts;
    }
    public ArrayList<ResearchDevelObject> getRandD() {
		return myRandD;
    }
    //___________________________________________SET
  
   public void addProducts(Product prod){
	   myProducts.add(prod);
   }
   public void addRandD(ResearchDevelObject rd){
	   myRandD.add(rd);
   } 
   public double getEmployees() {
		return employees;
	}
	public void setEmployees(double employees) {
		this.employees = employees;
	}
	public void addEmployees(double employees) {
		this.employees += employees;
	}
}
