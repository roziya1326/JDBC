package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {
	//get connection
	public Connection getConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/bank?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "root";
		String password = "experion@123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionURL,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	//close connection
	public Connection closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	//get all customer details
	public ArrayList<Customer> getAllCustomers(Connection connection){
		ArrayList<Customer> customerList = new ArrayList<Customer> ();
		String query = "select * from Customer";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int customerCode = resultSet.getInt(1);
				String customerFirstName = resultSet.getString(2);
				String customerLastName = resultSet.getString(3);
				String address = resultSet.getString(4);
		        long phnNo = resultSet.getLong(5);
		        long aadharNo = resultSet.getLong(6);
		        Customer customer = new Customer(customerCode, customerFirstName, customerLastName, address, phnNo, aadharNo);
		        customerList.add(customer);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerList;
	}
	public int insertCustomer(Connection connection, Customer customer) {
        String query = "INSERT INTO Customer (customer_code, customer_firstName, customer_lastName, address, phn_number, aadhar_no) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customer.getCustomerCode());
            preparedStatement.setString(2, customer.getCustomerFirstName());
            preparedStatement.setString(3, customer.getCustomerLastName());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setLong(5, customer.getPhnNumber());
            preparedStatement.setLong(6, customer.getAadharNo());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
	public int updateCustomer(Connection connection, Customer customer) {
	    String query = "UPDATE Customer SET customer_firstName = ?, customer_lastName = ?, address = ?, phn_number = ?, aadhar_no = ? WHERE customer_code = ?";
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, customer.getCustomerFirstName());
	        preparedStatement.setString(2, customer.getCustomerLastName());
	        preparedStatement.setString(3, customer.getAddress());
	        preparedStatement.setLong(4, customer.getPhnNumber());
	        preparedStatement.setLong(5, customer.getAadharNo());
	        preparedStatement.setInt(6, customer.getCustomerCode());
	        int rowsUpdated = preparedStatement.executeUpdate();
	        return rowsUpdated;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

}
