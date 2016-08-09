package com.packtpub.mongo.chapter4.producer;

import com.mongodb.MongoClient;
import com.packtpub.mongo.chapter4.ejb.SchemaSetup;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
 
import javax.enterprise.inject.Produces;
@ApplicationScoped
public class Producer {
        private static final Logger LOGGER = Logger.getLogger(Producer.class.getName());
	  @Produces
	  public MongoClient mongoClient() {
	    try {
			return new MongoClient("localhost", 27017);
		} catch ( Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	    return null;
	  }
}
