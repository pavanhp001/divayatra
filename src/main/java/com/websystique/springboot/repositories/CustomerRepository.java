package com.websystique.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websystique.springboot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT c FROM Customer c WHERE LOWER(c.id) = LOWER(:id)")
    public Customer findByName(@Param("id") Long id);
}

/*

*If he is not new customer we need to show his details.
*
*
**
*/
