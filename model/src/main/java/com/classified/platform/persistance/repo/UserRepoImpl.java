package com.classified.platform.persistance.repo;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.classified.platform.model.User;

@Component
public class UserRepoImpl implements UserRepo {
	/*
	 * TODO figure out the persistance wiring
	 */
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	public void deleteInBatch(Iterable<User> arg0) {
		// TODO Auto-generated method stub

	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub

	}

	public User getOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<User> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(String arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(User arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(Iterable<? extends User> arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
