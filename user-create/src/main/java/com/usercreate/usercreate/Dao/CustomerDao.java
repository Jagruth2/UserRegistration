package com.usercreate.usercreate.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.usercreate.usercreate.model.Customer;

@Repository
public class CustomerDao {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public CustomerDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Customer getCustomer(String customerId) {
        return dynamoDBMapper.load(Customer.class, customerId);
    }

    public Customer createCustomer(Customer customer) {
        dynamoDBMapper.save(customer);
        return customer;
    }
}