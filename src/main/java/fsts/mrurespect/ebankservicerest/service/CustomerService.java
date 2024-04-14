package fsts.mrurespect.ebankservicerest.service;

import fsts.mrurespect.ebankservicerest.dto.CustomerRequestDto;
import fsts.mrurespect.ebankservicerest.entity.Customer;
import fsts.mrurespect.ebankservicerest.exception.customer.CustumerNotFoundException;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id) throws CustumerNotFoundException;
    Customer addCustomer(CustomerRequestDto customer);
    Customer updateCustomer(Customer customer) throws CustumerNotFoundException;
    boolean deleteCustomer(String id) throws CustumerNotFoundException;
}
