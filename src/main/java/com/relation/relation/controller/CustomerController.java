package com.relation.relation.controller;

import com.relation.relation.config.JwtTokenUtil;
import com.relation.relation.model.CustomerModel;
import com.relation.relation.model.GetCustomQuery;
import com.relation.relation.repository.CustomerRepository;
import com.relation.relation.service.JwtCustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    JwtCustomerDetailService jwtCustomerDetailService;
    @GetMapping("/")
    private List<CustomerModel> getAll(){
        return customerRepository.findAll();
    }
    @PostMapping("/insert")
    private String insertCustomer(@RequestBody CustomerModel model){
        customerRepository.save(model);
        return "Selamat data sudah di tambahkan";
    }

    @GetMapping("/custom")
    List<GetCustomQuery> getAllData(){
    return customerRepository.getAllDataFristNameLastName();
    }

    @PatchMapping("/")
    private String updateAddres(@RequestParam(name = "addres") String addres, @RequestParam(name = "id") long id){
        customerRepository.updateCustomer(addres, id);
        return "Data sudah berhasil terupdate";
    }

    @GetMapping("/balabala/{fristName}/{id}")
    private CustomerModel getData(@PathVariable("fristName") String fristName, @PathVariable("id")long id){
        return customerRepository.getDataBYId(id, fristName);
    }
    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody CustomerModel customer) throws Exception{
        authenticate(customer.getUsername(), customer.getPassword());
        final UserDetails userDetails = jwtCustomerDetailService.loadUserByUsername(customer.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }
    private void authenticate(String userName, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        }catch (DisabledException e){

            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){

            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
