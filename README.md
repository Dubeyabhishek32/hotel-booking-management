# hotel-booking-management

** Hotel Booking Management APIs:**
This is a simple Java-based springboot microservice API for managing hotel reserevations & bookings . It provides endpoints for Creating bookings, Getting details about the  rooms availibility on a given date, and retrieving the reservations or bookings for a specific guest.

**Features:**
Create Guest Reservation : Endpoint to create a booking with guest name, room number, and date.
Get Available Rooms: Endpoint to find all the details for available rooms for a given date.
Get Booking Details for Guest: Endpoint to find all the bookings as per the reservations for a specific guest.

**Prerequisites:**
Java Development Kit (JDK) installed on your machine - JDK 22 latest would be great
Maven or Gradle for building the project
Git Required for cloning the repository (optional)

**Installation**
Clone the repository carefully to your local machine with the correct branch by using the below git command:
git clone https://github.com/Dubeyabhishek32/hotel-booking-management.git

Navigate to the project directory:
cd hotel-booking-management

Build the project using Maven:
mvn clean install

**Usage**
Run the main springboot class **HotelManagementApplication** to run or start the server:
java -cp target/classes com.hotelmanagementprocess.hotelroomreservationcontroller

Use a Postman to make HTTP requests to the API endpoints:
Create Guest Reservation:        POST /hotel-bookings
Get Available Rooms:             GET /hotel-available-rooms?date={date}
get Booking Details for Guestt:  GET /reservation-for-guest/{guestName}

**Example For Requests To Trigger**
createGuestReservation:
curl -X POST -d "guestName=Abhishek Dubey&roomNumber=2&date=2024-06-08" http://localhost:8080/hotel-bookings

getAvailableRooms:
curl http://localhost:8080/hotel-available-rooms?date=2024-06-08

getBookingDetailsByGuest:
curl http://localhost:8080/reservation-for-guest/Abhishek Dubey
