/*
* @author Bailey Jones
* @date 12/11/2021
* This is a class for Employee, which is a superclass.
* 
*
*/

//class begin
public abstract class Employee implements Comparable<Employee>
{
   //private attributes
   private String name;
   private int idNo;
   private double baseSalary;
   
   // def constructor
   public Employee()
   {
      name = " ";
      idNo = 0;
      baseSalary = 0.0;
   }
   
   //overloaded constructor
   public Employee(String name, int idNo, double baseSalary)
   {
      this.name = name;
      this.idNo = idNo;
      this.baseSalary = baseSalary;
   }
   
   // overloaded constructor
   public Employee(Employee copy)
   {
      this.name = copy.getName();
      this.idNo = copy.getIdNo();
      this.baseSalary = copy.getBaseSalary();
   }
   
   /*
   * setName sets a val for name
   * @param name is given name
   */
   public void setName(String name)
   {
      this.name = name;
   }
   
  /*
   * setIdNo sets a val for idNo
   * @param idNo is the given idNo by the program
   */
   public void setIdNo(int idNo)
   {
      this.idNo = idNo;
   }
   
   /*
   * setBaseSalary sets a value for base salary
   * @param baseSalary is given by the driver
   */
   public void setBaseSalary(double baseSalary)
   {
      this.baseSalary = baseSalary;
   }
   
   /*
   * getName retrieves the stored val for name
   * @return name returns the val for name stored in an Employee object
   */
   public String getName()
   {
      return name;
   }
   
   /**
   * getIdNo get the val for id number
   * @return idNo returns the stored id number
   */
   public int getIdNo()
   {
      return idNo;
   }
   
   /*
   * getBaseSalary gets the stored value for salary in the object
   * @return baseSalary returns this value
   */
   public double getBaseSalary()
   {
      return baseSalary;
   }
   
   /*
   * equals method in every class that compares two of the same class object 
   * @param test is the tested object
   * @return tester returns true if the objects are the same, false if not
   */
   public boolean equals(Employee test)
   {
      boolean tester = false;
      
      if(this.getName().equals(test.getName()) && this.getIdNo() == test.getIdNo() && this.getBaseSalary() == test.getBaseSalary())
      {
         tester = true;
      }
      
      return tester;
   }
   
   /*
   * toString is a standard method that aggregates an objects data into a single string
   * @return sb.toString returns the full string
   */
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      sb.append("Employee Name: " + name +
               "\nID Number: " + idNo + 
               "\nBase Salary: " + baseSalary);
      
      return sb.toString();
   }
   
   // abstract methods
   public abstract double computePay();
   public abstract int getListings();
   
   // comparable interface method 
   public int compareTo(Employee test)
   {
      if (this.computePay() > test.computePay())
      {
         return 1;
      }
      else if (this.computePay() < test.computePay())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
}// end class