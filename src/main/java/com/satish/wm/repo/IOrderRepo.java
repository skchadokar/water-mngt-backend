package com.satish.wm.repo;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.satish.wm.models.Orders;

@Repository
public interface IOrderRepo extends MongoRepository<Orders, String> {

	//@Query("select * from order where cid=1?")
	ArrayList<Orders> findAllByCustomerId(String cid);
}
