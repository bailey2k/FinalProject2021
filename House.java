/*
* @author Bailey Jones
* @date 12/11/2021
* This is a class for House, which has an embedded Realtor object.
*/
import java.text.DecimalFormat;
// class begins 
public class House
{  
   // list of private attributes with an embedded Realtor object
   private String address;
   private String city;
   private String state;
   private int zip;
   private Realtor agent;
   private double price;
   private boolean isSold;
   
   // def constructor
   public House()
   {
      address = " ";
      city = " ";
      state = " ";
      zip = 0;
      agent = null;
      price = 0.0;
      isSold = false;
   }
   
   // overloaded constructor
   public House(String address, String city, String state, int zip, String name, int idNo, double baseSalary, int listings, double price, boolean isSold)
   {
      this.address = address;
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.agent = new Realtor(name, idNo, baseSalary, listings);
      this.price = price;
      this.isSold = isSold;
   }
   
   // copy constructor
   public House(House copy)
   {
      this.address = copy.getAddress();
      this.city = copy.getCity();
      this.state = copy.getState();
      this.zip = copy.getZip();
      this.agent = new Realtor(copy.getAgent());
      this.price = copy.getPrice();
      this.isSold = copy.getStatus();
   }
   
   // accessor for address, @return address just returns the address
   public String getAddress()
   {
      return address;
   }
   
   // accessor for city, @return city just returns city
   public String getCity()
   {
      return city;
   }
   
   // accessor for state, self explanatory
   public String getState()
   {
      return state;
   }
   
   // accessor for zip, @return zip returns an integer value for zip
   public int getZip()
   {
      return zip;
   }
   
   /*
   * getAgent is an accessor for the embedded object, which creates a copy and returns it
   * @return copy returns this created copy
   */
   public Realtor getAgent()
   {
      Realtor copy = new Realtor(agent);
      return copy;
   }
   
   // accessor that allows us to retrieve the name of the realtor from the private attribute
   public String getRealtorName()
   {
      return agent.getName();
   }
   
   //accessor for commission of the realtor
   public double getCommission()
   {
      return agent.getCommissRate();
   }
   
   // accessor for salary that allows us to get it out of the embedded object
   public double getRealtorSalary()
   {
      return agent.getBaseSalary();
   }
   
   // accessor for price, @return price returns house price
   public double getPrice()
   {
      return price;
   }
   
   // getStatus accessor, @return isSold returns a boolean value for isSold
   public boolean getStatus()
   {
      return isSold;
   }
   
   // setter for address
   public void setAddress(String address)
   {
      this.address = address;
   }
   
   // setter for city
   public void setCity(String city)
   {
      this.city = city;
   }
   
   // setter for state
   public void setState(String state)
   {
      this.state = state;
   }
   
   // setter for zip
   public void setZip(int zip)
   {
      this.zip = zip;
   }
   
   // allows us to change the realtor on the house
   public void setRealtor(Realtor newAgent)
   {
      Realtor copy = new Realtor(newAgent);
      agent = copy;
   }
   
   // setter for price
   public void setPrice(double price)
   {
      this.price = price;
   }
   
   // setter for status
   public void setStatus(boolean isSold)
   {
      this.isSold = isSold;
   }
   
   /*
   * standard equals method to compare objects
   * @param test is the compared object
   * @return tester returns a boolean true if they're the same, false if not
   */
   public boolean equals(House test)
   {
      boolean tester = false;
      
      // I figure that two house cannot have the same address, so I will just check for that
      if (this.getAddress().equals(test.getAddress()))
      {
         tester = true;
      }
      
      return tester;
   }
   
   /*
   * toString method
   * @return sb.toString returns an appended string with all relevant information surrounding the house
   */
   public String toString()
   {
      DecimalFormat df = new DecimalFormat("0.00");
      StringBuilder sb = new StringBuilder();
      
      sb.append("Address: " + address +
                "\nCity: " + city + 
                "\nState: " + state +
                "\nZip: " + zip + 
                "\nName of Realtor: " + agent.getName() +
                "\nPrice: " + price +
                "\nSold Status(T/F): " + isSold);
     
     return sb.toString();
    
    }

}// end class