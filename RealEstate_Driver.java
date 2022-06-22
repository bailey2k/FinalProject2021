/*
* @author Bailey Jones
* @date 12/11/2021
* This is a driver for the final project, I have titled it RealEstateDriver.
* This driver includes an integer driven menu.
*/

// import statements
import java.text.DecimalFormat;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

// class begin
public class RealEstate_Driver
{
   // main method with ability to throw exceptions
   public static void main(String[] args) throws IOException
   {
      // create objects
      Scanner scan = new Scanner(System.in);
      ArrayList<Employee> empArray = new ArrayList<Employee>();
      ArrayList<House> houseArray = new ArrayList<House>();
      
      // call methods 
      readEmpData(empArray);
      readHouseData(houseArray);
      assignRealtors(houseArray, empArray);
      
      mainMenu(houseArray, empArray, scan);
      
      
   }
   
   /*
   * readEmpData is the method used to fill an arraylist with the data from the employees data file
   * @param dataArray is the one being filled 
   * @return dataArray is the same thing 
   */
   public static ArrayList<Employee> readEmpData(ArrayList<Employee> dataArray) throws IOException
   {
      File empData = new File("employeesFinalProject.csv");
      Scanner reader = new Scanner(empData);
      
      reader.nextLine();
      
      while(reader.hasNext())
      {
         String line = reader.nextLine();
         StringTokenizer toker = new StringTokenizer(line, ",");
         
         String type = toker.nextToken();
         
         // checks what type of employee and makes the correct object
         if (type.equals("o"))
         {
            String offName = toker.nextToken();
            int offID = Integer.parseInt(toker.nextToken());
            double offSal = Double.parseDouble(toker.nextToken());
            dataArray.add(new OfficeStaff(offName, offID, offSal));
          }
          else
          {
            String realName = toker.nextToken();
            int realID = Integer.parseInt(toker.nextToken());
            double realSal = Double.parseDouble(toker.nextToken());
            
            // set listings to zero for now
            int listings = 0;
            dataArray.add(new Realtor(realName, realID, realSal, listings));
           } 
          
        }
        
        return dataArray;
      
      }
   
   /*
   * readHouseData is the same thing as the last method, but with all of the house data
   * @param dataArray is the new arraylist for house data
   * @return dataArray is the filled house data list
   *
   */   
   public static ArrayList<House> readHouseData(ArrayList<House> dataArray) throws IOException
   {
      File houseData = new File("housesFinalProject.csv");
      Scanner reader = new Scanner(houseData);
      
      reader.nextLine();
      
      while(reader.hasNext())
      {
         String line = reader.nextLine();
         StringTokenizer toker = new StringTokenizer(line, ",");
         
         String address = toker.nextToken();
         String city = toker.nextToken();
         String state = toker.nextToken();
         int zip = Integer.parseInt(toker.nextToken());
         
         // blank Realtor for now
         String name = " ";
         int idNo = 0;
         double baseSalary = 0.0;
         int listings = 0;
         
         double price = Double.parseDouble(toker.nextToken());
         boolean isSold = false;
         
         // make a house object with huge list of attributes
         dataArray.add(new House(address, city, state, zip, name, idNo, baseSalary, listings, price, isSold));
      }
      
      return dataArray;
    }
    
    /*
    * assignRealtors assigns realtors to each house object, one at a time
    * @param houseArray house data arraylist
    * @param realArray employee data arraylist
    * @return houseArray returns the arraylist for house data because that was the one being manipulated
    */
    public static ArrayList<House> assignRealtors(ArrayList<House> houseArray, ArrayList<Employee> realArray)
    {
         // we know the index of where realtors start
         int realtorStart = 5;
         
         for (int index = 0; index < houseArray.size(); index++)
         {
            // get out the objects attributes again so we can remake it with full info in the arraylist
            String realName = realArray.get(realtorStart).getName();
            int realID = realArray.get(realtorStart).getIdNo();
            double realSal = realArray.get(realtorStart).getBaseSalary();
            int listings = realArray.get(realtorStart).getListings();
            listings++;
            
            // we need to remake the object with the correct listings, there is more than likely a better way to do this
            realArray.set(realtorStart, new Realtor(realName, realID, realSal, listings));
            Realtor deepCopy = new Realtor(realName, realID, realSal, listings);
            houseArray.get(index).setRealtor(deepCopy);
            realtorStart++;
            
            // makes sure only realtors data is being checked in the file
            if (realtorStart >= realArray.size())
            {
               realtorStart = 5;
            }
          }
        
        return houseArray;  
     }
    /*
    * simple mainMenu driven by integer input
    * @param realArray same employee arraylist
    * @param houseArray same house arraylist
    * @param scan is a scanner for user input
    */
    public static void mainMenu(ArrayList<House> houseArray, ArrayList<Employee> realArray, Scanner scan)
    {
         // text wall
         System.out.println("Welcome to the Real Estate Program. Please enter a valid integer.");
         System.out.println("0: Display all.");
         System.out.println("1: Display all realtors.");
         System.out.println("2: Display all office staff.");
         System.out.println("3: Search by U.S. State.");
         System.out.println("4: Search by price range.");
         System.out.println("5: Search by realtor name.");
         System.out.println("6: Sell a house.");
         System.out.println("7: Display realtors by name.");
         
         
         int choice = scan.nextInt();
         
         // integer driven switch statement
         switch (choice)
         {
            case 0: displayAll(houseArray, realArray);
            break;
            
            case 1: displayRealtors(realArray);
            break;
            
            case 2: displayStaff(realArray);
            break;
            
            case 3: searchByState(houseArray, scan);
            break;
            
            case 4: searchByPrice(houseArray, scan);
            break;
            
            case 5: searchByRealtor(houseArray, scan);
            break;
            
            case 6: sellHouse(houseArray, scan);
            break;
            
            case 7: searchRealtor(realArray, scan);
            break;
            
            // exits if incorrect
            default: System.out.println("Invalid integer. Exiting program.....");
                     System.exit(0);
                     
         }
         
    
    
    
       }
    /*
    * displayAll displays both arraylists' worth of data
    * @param houseArray same house arraylist
    * @param realArray same employee arraylist
    */
    public static void displayAll(ArrayList<House> houseArray, ArrayList<Employee> realArray)
    {
         // traverses entire houseArray
         for (int index = 0; index < houseArray.size(); index++)
         {
            System.out.println(houseArray.get(index).toString());
            System.out.println();
         }
         
         // traverses entire employee arraylist
         for (int index = 0; index < realArray.size(); index++)
         {
            System.out.println(realArray.get(index).toString());
            System.out.println();
         }
     }
    
    /*
    * displayRealtors displays all realtors in the realArray, which also has OfficeStaff
    * @param realArray, same employee arraylist
    *
    */
    public static void displayRealtors(ArrayList<Employee> realArray)
    {
         for (int index = 0; index < realArray.size(); index++)
         {
            // uses instanceof keyword to make this somewhat reusable
            if (realArray.get(index) instanceof Realtor)
            {
               System.out.println(realArray.get(index).toString());
               System.out.println();
            }
         }
    }
    
    /*
    * displayStaff displays all of the information of stored OfficeStaff objects 
    * @param realArray is this same arraylist for employee data
    *
    */
    public static void displayStaff(ArrayList<Employee> realArray)
    {
         for (int index = 0; index < realArray.size(); index++)
         {
            // again, using instanceof keyword
            if (realArray.get(index) instanceof OfficeStaff)
            {
               System.out.println(realArray.get(index).toString());
               System.out.println();
            }
         }

    }
    
    /*
    * searchByState gets a user input for a state abbreviation, and displays all houses in that state
    * @param houseArray is all the house data
    * @param scan is the scanner for user input
    */
    public static void searchByState(ArrayList<House> houseArray, Scanner scan)
    {
         System.out.println("Please enter the abbreviation for a state. Example: TX");
         scan.nextLine();
         String input = scan.nextLine();
         
         for (int index = 0; index < houseArray.size(); index++)
         {
            if (houseArray.get(index).getState().equalsIgnoreCase(input))
            {
               System.out.println(houseArray.get(index).toString());
               System.out.println();
            }

         }
    }
    
    /*
    * searchByPrice searches between the given range by the user and displays all applicable houses
    * @param houseArray is same arraylist with house data
    * @param scan is the scanner for user input
    */
    public static void searchByPrice(ArrayList<House> houseArray, Scanner scan)
    {
         System.out.println("Please enter a minimum house price.");
         double min = scan.nextDouble();
         System.out.println("Please enter a maximum house price.");
         double max = scan.nextDouble();
         
         for (int index = 0; index < houseArray.size(); index++)
         {
            if (houseArray.get(index).getPrice() >= min && houseArray.get(index).getPrice() <= max)
            {
               System.out.println(houseArray.get(index).toString());
               System.out.println();
            }
         }
    }
    
    /*
    * searchByRealtor searches the houseArray for realtor names that contain that given string
    * @param houseArray arraylist with all house data from csv
    * @param scan is the scanner for user input
    */
    public static void searchByRealtor(ArrayList<House> houseArray, Scanner scan)
    {
         System.out.println("Please enter a realtor's name.");
         scan.nextLine();
         String input = scan.nextLine();
         
         for (int index = 0; index < houseArray.size(); index++)
         {
            // case insensitive, can also find portions of a name for better or worse
            if (houseArray.get(index).getRealtorName().toLowerCase().contains(input.toLowerCase()));
            {
               System.out.println(houseArray.get(index).toString());
               System.out.println();
            }
         }
    }
    
    /*
    * sellHouse gets an address from the user and "sells" it, and calculates the new salary for the realtor
    * @param houseArray, again, all of the house data in an arraylist
    * @param scan is the scanner for user input
    */
    public static void sellHouse(ArrayList<House> houseArray, Scanner scan)
    {
         System.out.println("Please enter the EXACT address of a house.");
         scan.nextLine();
         String input = scan.nextLine();
         
         for (int index = 0; index < houseArray.size(); index++)
         {
            if (houseArray.get(index).getAddress().equalsIgnoreCase(input))
            {
               houseArray.get(index).setStatus(true);
               double commission = houseArray.get(index).getCommission() * houseArray.get(index).getPrice();
               double newSalary = commission + houseArray.get(index).getRealtorSalary();
               System.out.println("The realtor's salary is now $" + newSalary);
               System.out.println(houseArray.get(index).toString());
             }
          }
    }
    
    /*
    * searchRealtor searches the arraylist for realtors and displays all of their information
    * @param realArray is the arraylist with employee data
    * @param scan is the scanner for user input
    */
    public static void searchRealtor(ArrayList<Employee> realArray, Scanner scan)
    {
         System.out.println("Please enter a realtor's name.");
         scan.nextLine();
         String input = scan.nextLine();
         
         for (int index = 0; index < realArray.size(); index++)
         {
            if (realArray.get(index).getName().toLowerCase().contains(input.toLowerCase()))
            {
               System.out.println(realArray.get(index).toString());
            }
         }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 } // end class
    
    