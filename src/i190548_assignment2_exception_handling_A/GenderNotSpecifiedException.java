package i190548_assignment2_exception_handling_A;

public class GenderNotSpecifiedException extends Exception 
{
	 GenderNotSpecifiedException()
	 {
		 System.out.println("Please specify the gender ");
	 }
}
