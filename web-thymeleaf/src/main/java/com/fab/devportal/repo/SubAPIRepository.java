package com.fab.devportal.repo;

import org.springframework.data.repository.CrudRepository;

import com.fab.devportal.dao.SubApiTbl;

import java.util.List;
import java.lang.String;


public interface SubAPIRepository extends CrudRepository<SubApiTbl, Long> {

	List<SubApiTbl> findByParentApiName(String parentapiname);
	
	
}
