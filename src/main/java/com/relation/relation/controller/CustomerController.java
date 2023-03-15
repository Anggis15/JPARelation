package com.relation.relation.controller;

import com.relation.relation.model.CustomerModel;
import com.relation.relation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("/")
    private List<CustomerModel> getAll(){
        return customerRepository.findAll();
    }
    @PostMapping("/insert")
    private String insertCustomer(@RequestBody CustomerModel model){
        customerRepository.save(model);
        return "Selamat data sudah di tambahkan";
    }
}
