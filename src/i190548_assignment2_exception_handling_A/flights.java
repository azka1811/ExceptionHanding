package i190548_assignment2_exception_handling_A;

import java.time.LocalDate;

public class flights {
	private String departure_city;
	private static String destination_city;
	private String destination_time;
	private String departure_time;
	private String flight_class;
	private float fare;
	private int seats;
	private LocalDate date_of_flight;

	public String getDeparture_city() {
		return departure_city;
	}

	flights() {
		departure_city = null;
		destination_city = null;
		flight_class = null;
		seats = 0;
		fare = 0;
		date_of_flight = null;

	}
	flights(String destination_city,String departure_city,String flight_class, int fare,int seats,LocalDate date_of_flight)
	{
		this.departure_city = departure_city;
		this.destination_city = destination_city;
		this.flight_class = flight_class;
		this.seats = seats;
		this.fare = fare;
		this.date_of_flight = date_of_flight;
	}

	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}

	public static String getDestination_city() {
		return destination_city;
	}

	public void setDestination_city(String destination_city) {
		this.destination_city = destination_city;
	}

	public LocalDate getDate_of_flight() {
		return date_of_flight;
	}

	public void setDate_of_flight(LocalDate date_of_flight) {
		this.date_of_flight = date_of_flight;
	}

	public String getFlight_class() {
		return flight_class;
	}

	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
		if (flight_class.equals("first")) {
			fare = fare + 400;
		} else if (flight_class.equals("business")) {
			fare = fare + 200;
		} else if (flight_class.equals("economy")) {
			fare = fare + 0;
		} else {
			System.out.println("no such class is being offered here ");
		}
	}


	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return departure_city + " " + destination_city + " " + date_of_flight;
	}

	public String getDestination_time() {
		return destination_time;
	}

	public void setDestination_time(String destination_time) {
		this.destination_time = destination_time;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
}
