package com.yunjun.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yunjun.springboot.MyDataMongo;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, Long> {

}