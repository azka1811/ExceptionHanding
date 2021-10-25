package i190548_assignment2_exception_handling_A;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class functions {
	public static String departure = null;
	public static String destination = null;
	public String passenger_passport_number=null;
	public String passengerName=null;
	public String passenger_address=null;
	public String passenger_age=null;
	public String passenger_gender=null;
	public String class_f=null;
	public String choice_p=null;
	public String choice_admin=null;
	
	public int a;
	public int p;

	public ArrayList<passengers> passengersList = new ArrayList();
	public ArrayList<flights> flightList = new ArrayList();
	passengers passenger = new passengers();
	flights flight=new flights("lhr","isb","economy",4000,2,LocalDate.now());
	flights flight2=new flights("khi","isb","business",5000,2,LocalDate.now());
	
	
	
	   public boolean noFlight()
    {
    	if (flight.getDeparture_city().equals(departure) && flight.getDestination_city().equals(destination))

		{
    		return true;
    	}
    	return false;
    }
	   public void takeChoiceInput() throws IOException
	   {
		   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		   choice_p=in.readLine();
		   
			
	   }
	public boolean WrongName()
	{
		for(int i=0;i<passenger.getName().length();i++)
		{
			if (!Character.isLetter(passenger.getName().charAt(i))) {
	            return true;
	        }
		}
		return false;
		
	}
	
	public boolean negativeInput()
	{
		if(a<0 && p<0)
		{
			return false;
		}
		return true;
	}
	public void takeInputPassengerInfo() throws IOException, NameNotCorrectException,NegativeNumberInputException, GenderNotSpecifiedException
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter name");
		passengerName=input.readLine();
		passenger.setName(passengerName);

		if(!WrongName() )
			
		{
			 System.out.println("enter a passport number :");
			 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			 passenger_passport_number=in.readLine();
			 p=Integer.parseInt(passenger_passport_number);
			 passenger.setPassport_number(p);
			 if(negativeInput())
			 {
				 System.out.println("enter passenger address");
			 passenger_address=in.readLine();
			 passenger.setAddress(passenger_address);
			 System.out.println("enter passenger age");
			 passenger_age=in.readLine();
			 a=Integer.parseInt(passenger_age);
			
			 passenger.setAge(a);
			
			 System.out.println("enter gender..Press F for female, M for male, O for others");
			 
			 passenger_gender=in.readLine();
			 if(passenger_gender.equals("F") || passenger_gender.equals("M") || passenger_gender.equals("O") )
			 {passenger.setGender(passenger_gender);}
			 else
			 {
				 throw new GenderNotSpecifiedException();
			 }
			 passengersList.add(passenger); 
			 }
			 else
			 {
				 throw new NegativeNumberInputException();
			 }
			
			
			 System.out.println("passenger info added successfully ");
	    }
		else
		{
			throw new NameNotCorrectException();
			
			
			
		}
	}
	public void takeInputCities() throws IOException
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter destination city");
		destination=input.readLine();
		flight.setDestination_city(destination);     
		System.out.println("enter departure city ");
		departure=input.readLine();
		flight.setDestination_city(destination);
	}
 
    public void makePayment() throws IOException
    {
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	class_f=input.readLine();
    	flight.setFlight_class(class_f);
    	flight.setFare(flight.getFare());
    	System.out.println("your fare is :"+ flight.getFare());
    	
    		
    	
    }
	public void bookflight() throws FlightNotAvailableException
	{
		boolean flag_flight=noFlight();
		
		if(flag_flight==true)
		{
		
			flightList.add(flight);
			System.out.println("flight added successfully");
			
		}
		
		else
		{
			throw new  FlightNotAvailableException();
		}
		

	}
	public void searchFlight() throws IOException
	{
		System.out.println("Enter a destination time to search if the flight is available or not ");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		functions.departure=input.readLine();
	
			if(flights.getDestination_city().equals(functions.departure))
			{
				
				System.out.println("flight found");
			}
			else
			{
				System.out.println("no such flight");
			}
		
	}
	public void writeToFile() 
	{
		 try {
		      FileWriter myWriter = new FileWriter("flightbookedInfo.txt");
		      myWriter.write(passenger.toString()+" "+flight.toString());
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public void viewFlights() throws IOException
	{
		flightList.add(flight);
		flightList.add(flight2);
		 FileWriter myWriter = new FileWriter("FlightsAvailable.txt");
	      
	      myWriter.close();
		for(int i=0;i<flightList.size();i++)
		{
			System.out.println(flightList.get(i).toString());
			myWriter.write(flightList.get(i).toString());
		}
		myWriter.close();
	}
	public void RemoveFlight(flights obj)
	{
		flightList.remove(obj);
		if (flightList.remove(obj)) {
			System.out.println("flight removed successfully");
		} else {
			System.out.println("an error occured while removing");
		}
	}
	public void AddFlight(flights obj)
	{
		flightList.add(obj);
		System.out.println("flight added successfully");
	}
	public void Admin() throws IOException
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		flights admin_update=new flights();
		choice_admin=input.readLine();
		if(choice_admin.equals("1"))
		{
			
			System.out.println("enter destination city");
			destination=input.readLine();
			flight.setDestination_city(destination);     
			System.out.println("enter departure city ");
			departure=input.readLine();
			flight.setDestination_city(destination);
			AddFlight(admin_update);
			System.out.println("after updation");
			viewFlights();
		}
		else if(choice_admin.equals("2"))
		{
			RemoveFlight(admin_update);
			
		}
		else if(choice_admin.equals("3"))
		{
			viewFlights();
			
		}
		else
		{
			System.out.println("Wrong input");
		}
		
	}
}
