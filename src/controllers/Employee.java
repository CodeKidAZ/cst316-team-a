package controllers;
import org.json.JSONObject;

public class Employee 
{
    private String name ;
    private int wage;
    
    public Employee()
    {
    }
    public Employee(String name, int wage)
    {
        this.name = name;
        this.wage = wage;
        
    }
    public void setName(String a)
    {
        name = a;
    }
    public String getName()
    {
        return name;
    }
    public void setWage(int a)
    {
        wage = a;
    }
    public int getWage()
    {
        return wage;
    }
        
}
