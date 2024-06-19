package com.ilp04.utility;

import com.ilp04.service.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;


public class CustomerUtility {

	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in); 
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View all customers");
            System.out.println("2. Insert a new customer");
            System.out.println("3. Update an existing customer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
 
            switch (choice) {
                case 1:
            		getAllCustomers();
                    break;
                case 2:
                    insertCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
	}
	
	private static void getAllCustomers() {
		CustomerService customerService = new CustomerServiceImpl();
		ArrayList<Customer> customerList = null;
		customerList = customerService.getAllcustomers();
		System.out.println("+---------------+---------------+---------------+");
	    System.out.printf("| %-13s | %-13s | %-13s |%n", "Customer Code", "Firstname", "Lastname");
		System.out.println("+---------------+---------------+---------------+");
		for(Customer customer: customerList) {
	        // Print data
	        System.out.printf("| %-13d | %-13s | %-13s |%n", customer.getCustomerCode(), customer.getCustomerFirstName(), customer.getCustomerLastName());
	        System.out.println("+---------------+---------------+---------------+");
		}
	}
	private static void insertCustomer() {
		CustomerService customerService = new CustomerServiceImpl();

		 Scanner scanner = new Scanner(System.in);
         System.out.println("Enter customer details:");

         System.out.print("Customer Code: ");
         int customerCode = scanner.nextInt();
         scanner.nextLine(); 

         System.out.print("First Name: ");
         String firstName = scanner.nextLine();

         System.out.print("Last Name: ");
         String lastName = scanner.nextLine();

         System.out.print("Address: ");
         String address = scanner.nextLine();

         System.out.print("Phone Number: ");
         long phoneNumber = scanner.nextLong();

         System.out.print("Aadhar Number: ");
         long aadharNumber = scanner.nextLong();

         Customer customer = new Customer(customerCode, firstName, lastName, address, phoneNumber, aadharNumber);
         int rows = customerService.insertIntoCustomer( customer);
         System.out.print(rows);
	}
	public static void updateCustomer() {
	    CustomerService customerService = new CustomerServiceImpl();

	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter customer details to update:");

	    System.out.print("Customer Code: ");
	    int customerCode = scanner.nextInt();
	    scanner.nextLine(); 

	    System.out.print("First Name: ");
	    String firstName = scanner.nextLine();

	    System.out.print("Last Name: ");
	    String lastName = scanner.nextLine();

	    System.out.print("Address: ");
	    String address = scanner.nextLine();

	    System.out.print("Phone Number: ");
	    long phoneNumber = scanner.nextLong();

	    System.out.print("Aadhar Number: ");
	    long aadharNumber = scanner.nextLong();

	    Customer customer = new Customer(customerCode, firstName, lastName, address, phoneNumber, aadharNumber);
	    int rows = customerService.updateCustomer(customer);
	    System.out.print(rows + " rows updated.");
	}

}
