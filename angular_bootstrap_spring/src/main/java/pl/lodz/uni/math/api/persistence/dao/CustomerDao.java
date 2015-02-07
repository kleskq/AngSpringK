package pl.lodz.uni.math.api.persistence.dao;

import java.util.List;

import pl.lodz.uni.math.api.api.model.customer.Customer;

public interface CustomerDao {
    List<Customer> getCustomers();

    boolean deleteCustomer(Long id);

    boolean saveCustomer(Customer customer);
}
