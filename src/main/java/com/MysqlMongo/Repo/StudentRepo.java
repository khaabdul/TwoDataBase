package com.MysqlMongo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MysqlMongo.Entity.StudentBean;

public interface StudentRepo extends JpaRepository<StudentBean, Integer> {
	public Optional<StudentBean> findByEmail(String email);

	public void deleteByEmail(String email);
}
