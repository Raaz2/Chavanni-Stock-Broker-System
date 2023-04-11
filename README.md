## CHAVANNI :- Stock Broker System
This project is a stock broker system that allows customers to invest and trade in shares. It has two users - brokers and customers.

## Features
Broker
- Login with fixed credentials
- View all customers
- Add new stocks
- View all stocks
- Delete customer
- Delete stock
- Logout

Customer
- Sign up with first name, last name, username, password, address, mobile number, and email
- Login with their own credentials
- View all stocks
- Buy and sell stocks
- View holding
- Add and withdraw funds to and from wallet
- Logout
## Database Design
### Tables: customers, stocks, transactions, wallet
Fields: customer_id, first_name, last_name, username, password, address, mobile_number, email, stock_id, stock_name, quantity, price_per_share, transaction_id, transaction_type, date, amount, wallet_id, balance, timestamp, is_deleted
## Relationships:
customers has a one-to-one relationship with wallet
stocks has a many-to-many relationship with customers through transactions table
is_deleted field is added to all tables to mark records as deleted instead of actually deleting them
## How to Run the Project
Clone the project to your local machine.

Install the required dependencies.

Update the properties file with database credentials.

Run the project from the main class.

Use the project based on the user type - broker or customer.

### Exception Handling
Appropriate exceptions will be thrown for invalid data entry, such as duplicate email or incorrect stock name.

## ER Diagram
![](https://lh3.googleusercontent.com/Er0vOBbIA7zQUs297G-WUaoV8koKh2JEVy0XKTD2Vo0F1do8FrnPAYdwDtVvMoh1GI-hqa2R4EDW4qJev3hl7tPADpTgrt2rg9jsAoNXByoHLyGLq8gyZKgReaLGkdRbsBV4n4gnc6K4gHAgnthYsdEvOTa4bnDqukL1sBCMVItH4Lym16h3qQGjp6QqtTAuPm0Oqr1YdUX8JY6vqYICvu85W7q5U9R4CHfiMut8h7k4aE071552JDX7KC0xsUE-S1b60t4KEiWC24tJkOc94w9wS_QuZ1G7mvPfTMiqOIVlCM-sNPxvUsFQpzbe733bbgl1AbcJCUPH77TWV15TsD-cam8ywd4Iu4waCZw8CQBNwiwsFd0z0QaH4hrtJkBLfASAL1W9ToeY_DGyoNsyT9UMy4pApAcGxjTQB5DyPBAQcAGhIW6lbm-bQugHMeEluU8xaezvWQNsM7o_YOCDmK0Oep7G5NhqJXq98RVxPa3ysgaGglATrFQ6Eba9tz-0t9q0i3WEttDT-LAQJ3ioSgclcbR8m8hLUSLXSUNKuHl5cDVBPmgWwRKzDJgHtKTzNP_wv9qy_RLNA6vrsQb54XZIFPDI1cWtNkX20QQp94NJZYK2F18hj2-A9lmfEXazvHCYflVbn2Ad6-5xLvl5xQIT_EnyAG19P6GDMi08HvzEh5G-qA749_oSicbla3AIEGYAFKZDzga2-NqDf1-qmZWFI8SEyZlbqiw3AHdoFIXxICOwMBlnBlHLI5Nc5dBtWOCvX5OxAyA6gypszr4balGV0yNWJFg9-K-RTR4bMvql48vnjOv9PHgm_U-hG-P6wLFXVZzcdMiCZkOYOhJSwXMaspz-zsMZPxthrts-rb7psF2k9M6IQeQNEcsQxdHnc7EMJKJugdHDsMPXspCVTPjGSF1FsHZ89A-TGIYZdPCZcjjNgg=w754-h686-s-no?authuser=0)


## Technologies Used
- Java
- MySQL
- JDBC
- STS

## Feedback
I believe constructive criticism is a good thing. So any Feedback is appreciated. Thank you for your time.
