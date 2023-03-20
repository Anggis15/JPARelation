package com.relation.relation.repository;

import com.relation.relation.model.CustomerModel;
import com.relation.relation.model.GetCustomQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    @Query(value = "SELECT frist_name, last_name from customer WHERE customer_id > 1", nativeQuery = true)
    List<GetCustomQuery> getAllDataFristNameLastName();

    @Query(value = "SELECT * FROM customer WHERE customer_id = ?1 and frist_name like %?2%", nativeQuery = true)
    CustomerModel getDataBYId(long id, String fristName);
    @Transactional
    @Modifying
    @Query(value = "UPDATE customer SET addres = ?1 where customer_id = ?2", nativeQuery = true)
    void updateCustomer(String adress, long id);

    CustomerModel findByUsername(String userName);

}
