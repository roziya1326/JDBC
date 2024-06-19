package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public ArrayList<Customer> getAllcustomers() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		CustomerDAO customerDao = new CustomerDAO();
		Connection connection = customerDao.getConnection();
		customerList = customerDao.getAllCustomers(connection);
		return customerList;
	}

	@Override
	public int insertIntoCustomer(Customer customer) {
		CustomerDAO customerDao = new CustomerDAO();
		Connection connection = customerDao.getConnection();
		int rowsAffected = customerDao.insertCustomer(connection, customer);
		return rowsAffected;
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		CustomerDAO customerDao = new CustomerDAO();
		Connection connection = customerDao.getConnection();
		int rowsAffected = customerDao.updateCustomer(connection, customer);
		return rowsAffected;
	}

}
