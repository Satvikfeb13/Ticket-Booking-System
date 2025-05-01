Train Ticket Booking System
Overview
This is a simple train ticket booking system built using Java, which allows users to search for trains, book tickets, and view their booked tickets. It simulates a real-world system for booking tickets for available trains between different stations.

Features
User Registration & Authentication: Users can login to access their profile and book tickets.

Train Search: Users can search for available trains based on source and destination.

Ticket Booking: Users can book a ticket for a selected train.

View Booked Tickets: Users can view all their booked tickets with ticket details.

Simple Data Storage: The system uses JSON files to store train and user data.

Technologies Used
Java 8+: The application is written in Java, utilizing Object-Oriented Programming concepts.

JSON: Used for storing train data.

Scanner Class: For capturing user input from the console.

Setup & Installation
Prerequisites
Java 8+ (Ensure that Java is installed on your system)

IDE like IntelliJ IDEA or Eclipse for running the code (Optional)

JSON data file for trains (trains.json)

Steps to Run the Application
Clone the Repository:

bash
Copy
Edit
git clone <repository_url>
Navigate to the project folder:

bash
Copy
Edit
cd train-ticket-booking-system
Compile the Java Files: You can either compile the Java files manually or through your IDE.

bash
Copy
Edit
javac -d bin src/org/example/*.java
Run the Main Application: After compiling, run the TrainTicketBookingApp.java file to start the application.

bash
Copy
Edit
java -cp bin org.example.TrainTicketBookingApp
Data Files: Make sure the trains.json file is placed in the src/org/example/resources folder (or update the path in your code accordingly).

How to Use
Login:

On the startup screen, users will be prompted to enter their User ID and password to login.

If the credentials match a registered user, they will be granted access.

Booking a Ticket:

After logging in, users can view available trains by entering the source and destination stations.

The system will list the available trains and allow the user to select a train.

After selecting the train, the user will receive a confirmation and a unique ticket ID.

Viewing Tickets:

Users can view all their booked tickets by selecting the appropriate option in the menu.

Logging Out:

The user can log out at any time and return to the login screen.

File Structure
sql
Copy
Edit
/train-ticket-booking-system
|-- src/
|   |-- org/
|       |-- example/
|           |-- entities/
|               |-- Train.java
|               |-- Ticket.java
|               |-- User.java
|           |-- services/
|               |-- TrainService.java
|               |-- TicketService.java
|               |-- UserService.java
|           |-- TrainTicketBookingApp.java
|-- resources/
|   |-- trains.json
|-- README.md
Example Usage
Login:

pgsql
Copy
Edit
Enter user ID: user1
Enter password: password
Booking Ticket:

yaml
Copy
Edit
Enter source station: station1
Enter destination station: station3
Enter travel date: 2025-05-01

Available trains:
1. Train ID: 1
2. Train ID: 2

Select train by number: 1
Ticket booked successfully! Ticket ID: T1618365623456
View Tickets:

yaml
Copy
Edit
Ticket ID: T1618365623456
Source: station1
Destination: station3
Date of Travel: 2025-05-01
Train Number: 12345
Future Enhancements
Payment Integration: Integrating a payment system to process payments for ticket bookings.

Train Seat Availability: Real-time seat availability checking.

User Registration: Allowing users to register directly in the application.

Admin Panel: Adding an admin feature to add/remove trains and view all users' bookings.

License
This project is licensed under the MIT License - see the LICENSE file for details.
