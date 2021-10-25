package i190548_assignment2_exception_handling_A;

import java.io.FileWriter;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class main_menu {
	static char choice;

	public static boolean WrongChoices() {
		if (choice == 'p' || choice == 'a' || choice == 'o') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException, FlightNotAvailableException, WrongChoiceException,
			NameNotCorrectException, NegativeNumberInputException, GenderNotSpecifiedException {
		boolean loopbool = true;
		while (loopbool)

		{
			boolean ch_flag = false;
			functions f = new functions();
			passengers passenger = new passengers();
			System.out.println(
					"do you want to enter as a passenger or as an admin ?\r\nEnter your choice (press 'p' for passenger and 'a' for admin)");

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			choice = (char) in.read();
			ch_flag = WrongChoices();
			if (ch_flag == true) {
				if (choice == 'p') {
					f.takeInputPassengerInfo();
					System.out.println(
							"our passengers can avail the following functionalites :\r\n1.book a flight\r\n2.search a flight by destination city and departure city\r\n3.pay for ticket\r\n4. check the total available seats");
					f.takeChoiceInput();
					if (f.choice_p.equals("1")) {
						f.takeInputCities();
						f.bookflight();
						f.writeToFile();

					} else if (f.choice_p.equals("2")) {
						f.searchFlight();
					} else if (f.choice_p.equals("3")) {
						System.out.println(
								"make payment... do you want to book 'first class' 'business class' or economy class");
						f.makePayment();

					}

					else {
						System.out.println("wrong input");
					}
				} else if (choice == 'a') {
					System.out.println(
							"you have entered as an admin\r\n press 1 to update flights\r\n press 2 to remove a flight\r\n3.view all flights");
                 f.Admin();
				} else if (choice == 'o') {
					loopbool = false;
				}
			} else {
				throw new WrongChoiceException();
			}

		}

	}
}
