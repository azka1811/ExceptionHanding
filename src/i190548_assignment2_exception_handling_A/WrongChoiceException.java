package i190548_assignment2_exception_handling_A;

public class WrongChoiceException extends Exception {
	WrongChoiceException()
	{
		System.out.println("the choice u entered is neither 'p' nor 'a', please enter a valid choice");
	}

}
