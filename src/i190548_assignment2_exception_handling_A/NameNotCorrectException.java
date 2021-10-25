package i190548_assignment2_exception_handling_A;

public class NameNotCorrectException extends Exception
{
    NameNotCorrectException()
    {
    	System.out.println("the name cannot have numbers or symbols ");
    }
}
