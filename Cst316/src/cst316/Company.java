package cst316;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.json.JSONArray;
import org.json.JSONObject;

public class Company {
    String name;
  
	private ArrayList<Product> myProducts;
    private ArrayList<ResearchDevelObject> myRandD;
    private ArrayList<Employee> emp;
    private StringProperty cname;
    private double employees;
    private double marketPower;

    public Company(String name){
    	this.name = name;
    	this.employees = 0;
    	this.marketPower = 0;
    	this.myRandD = new ArrayList<ResearchDevelObject>();
    	this.myProducts = new ArrayList<Product>();
    } 
    
    public Company(String name, double marketPower){
    	this.name = name;
    	this.employees = 0;
    	this.marketPower = marketPower;
    	this.myRandD = new ArrayList<ResearchDevelObject>();
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
        this.marketPower = jsonObject.getDouble("marketPower");

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
    
    public void setName(String name){
    	this.name = name;
    }
    //___________________________________________GET
    public String getCompanyName() {
    	return name;
    }
    
	public StringProperty getNameProperty()
	{
		cname = new SimpleStringProperty(name);
		return cname;
	}
    public ArrayList<Product> getProducts(){	
    	return myProducts;
    }
    public ArrayList<ResearchDevelObject> getRandD() {
		return myRandD;
    }
    public ArrayList<Employee> getEmployeesList() {
		return emp;
	}
    //___________________________________________SET
  
   public void addProducts(Product prod){
	   myProducts.add(prod);
   }
   /**
    * Gets the product's string associated with that index
    * Purpose is to reduce long method chains.
    * @param index		Location of the desired product in the array list
    * @return			Product name
    */
   public String fetchProductString(int index) {
	   //Ensure that the ArrayList actually has that index
	   if(!(myProducts.size() < index))
		   return myProducts.get(index).getName();
	   //If it does not exist, return a null value
	   else
		   return null;
   }
   public void addRandD(ResearchDevelObject rd){
	   myRandD.add(rd);
   } 
   public double getEmployees() {
		return employees;
	}
	/**
	 * @return the marketPower
	 */
	public double getMarketPower() {
		return marketPower;
	}
	/**
	 * @param marketPower the marketPower to set
	 */
	public void setMarketPower(double marketPower) {
		this.marketPower = marketPower;
	}
	public void setEmployees(double employees) {
		this.employees = employees;
	}
	public void addEmployees(double employees) {
		this.employees += employees;
	}
	public String getName() {
		return name;
	}
	public void addEmployeesList(Employee employees) {
		emp.add(employees);
	}
}
