/*
* @author Bailey Jones
* @date 12/11/2021
* This is the class for OfficeStaff, a subclass of Employee.
* No new attributes needed, gets all of them from the superclass.
*/
import java.text.DecimalFormat;
public class OfficeStaff extends Employee
{
   // def constructor
   public OfficeStaff()
   {
      super();
   }
   
   // overloaded constructor
   public OfficeStaff(String name, int idNo, double baseSalary)
   {
      super(name, idNo, baseSalary);
   }
   
   // copy constructor
   public OfficeStaff(OfficeStaff copy)
   {
      this.setName(copy.getName());
      this.setIdNo(copy.getIdNo());
      this.setBaseSalary(copy.getBaseSalary());
   }
   
   /*
   * computePay unique to this class
   * computes the gross paycheck based on two 40-hour work weeks
   */
   public double computePay()
   {
      double pay = this.getBaseSalary() * 80;
      return pay;
   }
   
   /*
   * simple equals method that compares the contents of two objects
   * @param test is the object being compared
   *
   */
   public boolean equals(OfficeStaff test)
   {
      boolean tester = false;
      
      if(this.getName().equals(test.getName()) && this.getIdNo() == test.getIdNo() && this.getBaseSalary() == test.getBaseSalary())
      {
         tester = true;
      }
      return tester;
   }
   
   /*
   * simple toString 
   * @return sb.toString returns a compiled string of the object's state
   */
   public String toString()
   {
      DecimalFormat df = new DecimalFormat("0.00");
      StringBuilder sb = new StringBuilder();
      sb.append("Name of Office Staff: " + this.getName() +
                "\nID Number: " + this.getIdNo() +
                "\nGross Paycheck: " + df.format(this.computePay()));
      
      return sb.toString();
   }
   






}  // class end
   