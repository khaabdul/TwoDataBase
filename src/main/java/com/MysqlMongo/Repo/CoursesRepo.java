package com.MysqlMongo.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MysqlMongo.Entity.CoursesBean;

public interface CoursesRepo extends MongoRepository<CoursesBean, Integer> {
	public Optional<List<CoursesBean>> findByEmail(String email);

	public void deleteByEmail(String email);
}
