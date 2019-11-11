package com.satish.wm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.satish.wm.models.Customers;

@Repository
@Transactional
public interface ICustomerRepo extends MongoRepository<Customers, String> {

}
