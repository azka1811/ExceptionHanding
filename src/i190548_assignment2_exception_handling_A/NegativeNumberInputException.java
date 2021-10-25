package i190548_assignment2_exception_handling_A;

public class NegativeNumberInputException extends Exception {
	NegativeNumberInputException() {
		System.out.println("input cannot be negative");
	}
}
