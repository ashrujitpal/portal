package com.fab.devportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fab.devportal.dao.SubApiTbl;
import com.fab.devportal.repo.SubAPIRepository;

@Service
public class SubApiService {
	
	@Autowired
    private SubAPIRepository repository;
	
	public List<SubApiTbl> findByParentApiName(String parentapiname){
		
		return repository.findByParentApiName(parentapiname);
		
	}

}
