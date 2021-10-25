package i190548_assignment2_exception_handling_A;

public class FlightNotAvailableException extends Exception
{
	FlightNotAvailableException()
	{
		System.out.println("sorry, there is no such flight available");
	}
}
