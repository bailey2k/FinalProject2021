/*
* @author Bailey Jones
* @date 12/11/2021
* This is a class for Realtor, which is a subclass of Employee.
*
*/
import java.text.DecimalFormat;
//class begins 
public class Realtor extends Employee
{  
   //private attributes
   private double commissRate;
   private int listings;
   
   //def constructor
   public Realtor()
   {
      super();
      commissRate = 0.03;
      listings = 0;
   }
   
   // overload constructor
   public Realtor(String name, int idNo, double baseSalary, int listings)
   {
      super(name, idNo, baseSalary);
      commissRate = 0.03;
      this.listings = listings;
   }
   
   /*
   * copy constructor
   * @param copy is the copied object
   */
   public Realtor(Realtor copy)
   {  
      this.setName(copy.getName());
      this.setIdNo(copy.getIdNo());
      this.setBaseSalary(copy.getBaseSalary());
      commissRate = 0.03;
      this.listings = copy.getListings();
   }
   
   /*
   * setListings takes a value for listings and stores it in the object
   * @param listings is the tallied number for listings
   */
   public void setListings(int listings)
   {
      this.listings = listings;
   }
   
   /*
   * changeCommissionRate allows the driver to change the commission rate value, which defaults
   * to 0.03 on construction
   * @param commissRate is the given change for commission rate
   */
   public void changeCommissionRate(double commissRate)
   {
      this.commissRate = commissRate;
   }
   
   /*
   * basic accessor for commissRate
   * @return commissRate returns the commiss rate
   */
   public double getCommissRate()
   {
      return commissRate;
   }
   
   /*
   * basic accessor for listings
   * @return listings returns this tallied value
   */
   public int getListings()
   {
      return listings;
   }
   
   /*
   * standard equals method to compare two objects
   * @param test is the compared object
   * @return tester returns true if they're the same, false if not
   */
   public boolean equals(Realtor test)
   {
      boolean tester = false;
      
      if (this.getListings() == test.getListings() && this.getCommissRate() == test.getCommissRate())
      {
         tester = true;
      }
      
      return tester;
   }
   
   /*
   * basic toString method that makes a single string based off of an object's data
   * @return sb.toString() returns the created string 
   */
   public String toString()
   {
      DecimalFormat df = new DecimalFormat("0.00");
      StringBuilder sb = new StringBuilder();
      sb.append("Realtor Name: " + this.getName() +
               "\nID Number: " + this.getIdNo() +
               "\nGross Paycheck: " + df.format(this.computePay()) +
               "\nCommission Rate: " + commissRate +
               "\nListings: " + listings);
      return sb.toString();
      
   }
   
   /*
   * computePay is unique to the Realtor class, which divides the base salary by 24 (bimonthly pay)
   * return pay returns this calculated value
   */
   public double computePay()
   {
      double pay = this.getBaseSalary() / 24;
      return pay;
   }
   
} // end class
    
   