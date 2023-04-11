Stock Broker System
This project is a stock broker system that allows customers to invest and trade in shares. It has two users - brokers and customers.

Features
Broker
Login with fixed credentials
View all customers
Add new stocks
View all stocks
View consolidated report of a stock
Delete customer (credits total amount of all stocks to customer wallet and sets account inactive)
Delete stock (credits total amount for that stock to customer wallet and marks stock deleted from database)
Logout
Customer
Sign up with first name, last name, username, password, address, mobile number, and email
Login with their own credentials
View all stocks
Buy and sell stocks
View transaction history
Add and withdraw funds to and from wallet
Logout and delete account
Database Design
Tables: customers, stocks, transactions, wallet
Fields: customer_id, first_name, last_name, username, password, address, mobile_number, email, stock_id, stock_name, quantity, price_per_share, transaction_id, transaction_type, date, amount, wallet_id, balance, timestamp, is_deleted
Relationships:
customers has a one-to-one relationship with wallet
stocks has a many-to-many relationship with customers through transactions table
is_deleted field is added to all tables to mark records as deleted instead of actually deleting them
How to Run the Project
Clone the project to your local machine.
Install the required dependencies.
Update the properties file with database credentials.
Run the project from the main class.
Use the project based on the user type - broker or customer.
Exception Handling
Appropriate exceptions will be thrown for invalid data entry, such as duplicate email or incorrect stock name.
ER Diagram
An ER diagram for the project is included in the repository.

Technologies Used
Java
MySQL
Hibernate
Contributors
[Your Name]
