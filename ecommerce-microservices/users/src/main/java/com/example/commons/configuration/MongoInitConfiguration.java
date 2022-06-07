package com.example.commons.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class MongoInitConfiguration {

	@Bean
	public Jackson2RepositoryPopulatorFactoryBean getRepositoryPopulator(MongoTemplate mongoTemplate,
			ObjectMapper mapper) {

		clearDatabase(mongoTemplate);

		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
		factory.setMapper(mapper);
		factory.setResources(new Resource[]{new ClassPathResource("mongo/users.json")});

		return factory;
	}

	private void clearDatabase(MongoTemplate mongoTemplate) {

		for (String collection : mongoTemplate.getCollectionNames()) {
			mongoTemplate.remove(new Query(), collection);
		}
	}
}
