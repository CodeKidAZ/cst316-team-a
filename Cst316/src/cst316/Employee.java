package cst316;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee 
{
    private StringProperty name ;
    private IntegerProperty wage;
    
    public Employee()
    {
    }
    public Employee(String name, int wage)
    {
        this.name = new SimpleStringProperty(name);
        this.wage = new SimpleIntegerProperty(wage);
        
    }
     public String getName()
    {
        return name.get();
    }
    public void setName(String a)
    {
        this.name.set(a);
    }
   public StringProperty getNameProperty()
   {
       return name;
   }
   
   
    public int getWage()
    {
        return wage.get();
    }
    public void setWage(int a)
    {
        this.wage.set(a);
    }
    public IntegerProperty getWageProperty()
   {
       return wage;
   }
   
        
}
