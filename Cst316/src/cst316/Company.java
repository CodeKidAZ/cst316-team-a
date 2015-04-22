package cst316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.json.JSONArray;
import org.json.JSONObject;

public class Company {

	String name;
	Player pl;

	private ArrayList<Product> myProducts;
	private ArrayList<ResearchDevelObject> myRandD;
	private double employees;


	// private double totalEmployees; //sumit added these
	// private ArrayList<Employee> emp;
	private StringProperty compName;
	private IntegerProperty totalEmp;
	public TreeMap<String, Employee> employmentTree = new TreeMap<String, Employee>(); //to store all employee data
	public TreeMap<String, Employee> hiredTree = new TreeMap<String, Employee>(); // to store all hired employees data

	public Company(String name) {
		this.name = name;
		this.myRandD = new ArrayList<ResearchDevelObject>();
		this.employees = 0;
		this.myProducts = new ArrayList<Product>();
	}


	/**
	 * Creates a company based on JSON values in a text file
	 *
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

	public void setName(String name){
		this.name = name;

	}

	//_________________________________________________________GET

	public String getCompanyName() {
		return name;
	}

	public StringProperty getNameProperty() { //used by table in HR
		compName = new SimpleStringProperty(name);
		return compName;
	}
	public int  getTotalHiredEmployees(){ //returns int
		return hiredTree.size();
	}
	public IntegerProperty getTotalEmployeesProperty(){ //used by table in HR
		totalEmp = new SimpleIntegerProperty(hiredTree.size());
		return totalEmp;
	}

	public ArrayList<Product> getProducts() {
		return myProducts;
	}

	public ArrayList<ResearchDevelObject> getRandD() {
		return myRandD;
	}

	//___________________________________________SET


	/**
	 * Gets the product's string associated with that index
	 * Purpose is to reduce long method chains.
	 * @param index		Location of the desired product in the array list
	 * @return			Product name
	 */
	public String fetchProductString(int index) 
	{
		//Ensure that the ArrayList actually has that index
		if(!(myProducts.size() < index))
			return myProducts.get(index).getName();
		//If it does not exist, return a null value
		else
			return null;
	}


	public TreeMap getHiredTree(){ //something wrong- suppose to access employee objects
		return hiredTree;
	}

	/*public void copyHiredTreeToArrayList() //if needed
	{
		emp.clear();
		emp = new ArrayList<Employee>(hiredTree.values());
	}*/

	/*public void addEmployeesList(Employee employees) {
	emp.add(employees);
	}*/

	/*public double getEmployees() {
        return employees;
    }*/

	/* public ArrayList<Employee> getEmployeesList() { //returns a list
        return emp;
    }*/

	/* public void setEmployees(double employees) {
    this.employees = employees;
    }*/

	/* public void addEmployees(double employees) {
    this.employees += employees;
    }*/

	//______________________________________________________SET

	public void addProducts(Product prod) {
		myProducts.add(prod);
	}

	public void addRandD(ResearchDevelObject rd) {
		myRandD.add(rd);
	}


	public void hireEmployees(Employee employees) {
		hiredTree.put(employees.getName(), employees);
	}
	public void fireEmployees(Employee employees){
		hiredTree.remove(employees.getName());
	}

	//___________________________________________________LOAD EMPLOYEES DATA
	public void loadEmployeeData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Management.class.getClassLoader().getResourceAsStream("res/employeeData.txt")));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			JSONObject obj = new JSONObject(strLine);                  //extract employee info from datafile
			String name = obj.get("name").toString();
			int wage = obj.getInt("wage");
			Employee empObject = new Employee(name, wage);      //create employee objects
			employmentTree.put(name, empObject);                                //store employee object into hashtable
		}
		in.close();
	}
}



