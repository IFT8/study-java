package com.comodin.basic.dao;

import com.comodin.basic.bean.AbstractDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBaseMongoRepository<T extends AbstractDocument> extends MongoRepository<T, Long> {

}