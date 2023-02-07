package com.acc.training.customerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.training.customerapi.domain.CustomerDomain;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    
    public Customer getCustomer(String id){
        return mapDomainToModel(repository.findByCustomerId(id));
    }

    public Customer createCustomer(Customer requestBody){
        return mapDomainToModel(repository.save(mapModelToDomain(requestBody)));
    }

    public Customer mapDomainToModel(CustomerDomain customerdomain){
        Customer customer = new Customer();
        customer.setCustomerAddress(customerdomain.getCustomerAddress());
        customer.setCustomerId(customerdomain.getCustomerId());
        customer.setCustomerName(customerdomain.getCustomerName());
        customer.setOfficeCode(customerdomain.getOfficeCode());
        return customer;

    }

    public CustomerDomain mapModelToDomain(Customer customer){
        CustomerDomain customerdomain = new CustomerDomain();
        customerdomain.setCustomerAddress(customer.getCustomerAddress());
        customerdomain.setCustomerId(customer.getCustomerId());
        customerdomain.setCustomerName(customer.getCustomerName());
        customerdomain.setOfficeCode(customer.getOfficeCode());
        return customerdomain;
    }
}

