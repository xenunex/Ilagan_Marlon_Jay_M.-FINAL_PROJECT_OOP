## Bill Calculator


## I. Project Overview

The Bill Calculator is a Java-based console application designed to help users compute and manage various types of bills. This program simplifies the calculation of bills for utilities like water, electricity, internet, food, and rent. Users can add multiple bills, calculate their total expenses, and optionally compute the remaining amount after deducting bills from their salary.


## II. OOP Principles Applied
This project demonstrates the effective application of Object-Oriented Programming (OOP) principles:

* ****Abstraction****: The Bill class serves as an abstract base class, encapsulating the common behavior of all bill types while allowing specific types to provide their own implementation of the calculateBill method.

* ****Inheritance****: Different types of bills (WaterBill, ElectricityBill, InternetBill, FoodBill, RentBill) inherit from the Bill class, reusing common functionality and providing specialized behavior.

* ****Polymorphism****: The program uses polymorphism to treat all bill types as Bill objects, enabling a consistent interface for calculating and displaying bill details.

* ****Encapsulation****: The Bill class encapsulates data (e.g., totalAmount) with private access and provides controlled access via getter and setter methods.


## III. Chosen SDG and Integration

  The project aligns with Sustainable Development Goal 12: **Responsible Consumption and Production.** By helping users track and manage their utility consumption and expenses, the application promotes financial responsibility and encourages mindful resource usage, contributing to sustainable living practices.


## IV. Instructions for Running the Program
1. Open your IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).
2. Create a new Java project.
3. Add a new class file and name it BillCalculator.
4. Copy and paste the provided code into the BillCalculator class file.
5. Run the program by clicking the Run button in the IDE.
6. Follow the on-screen prompts to calculate and manage your bills.

