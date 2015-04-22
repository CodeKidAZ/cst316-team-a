package cst316;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.IOException;
import static java.lang.System.in;
import java.util.TreeMap;
import org.json.JSONObject;

public class Management {

	final public static TreeMap<String, Employee> empTree = new TreeMap<String, Employee>(); //to store all employee data
	final public static TreeMap<String, Employee> hiredTree = new TreeMap<String, Employee>(); // to store all hired employees data

	public Management() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Management.class.getClassLoader().getResourceAsStream("res/employeeData.txt")));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			JSONObject obj = new JSONObject(strLine);				  //extract employee info from datafile
			String name = obj.get("name").toString();
			int wage = obj.getInt("wage");
			Employee empObject = new Employee(name, wage);	  //create employee objects
			empTree.put(name, empObject);								//store employee object into hashtable

		}
		in.close();
		br.close();
	}

}
