package com.usercreate.usercreate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.usercreate.usercreate.Dao.CustomerDao;
import com.usercreate.usercreate.model.Customer;

@RestController
public class CustomerController {

    private @Autowired CustomerDao customerDao;

    @RequestMapping(value = "/customer", produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Customer> getCustomer(@RequestBody Customer customer) {
        try {
            Customer response = customerDao.createCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(),
                    e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/customers/{customerId}", produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        try {
            Customer response = customerDao.getCustomer(customerId);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(),
                    e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

}