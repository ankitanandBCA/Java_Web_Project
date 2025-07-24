package com.hms.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.example.entity.DoctorSpecilazion;
import com.hms.example.repository.DocSpecilization;

@Service
public class DocSpc {
	
	@Autowired
	 DocSpecilization ds;
	
	public DoctorSpecilazion getadd(DoctorSpecilazion docs)
	{
		return ds.save(docs);
	}
	
	
	public List<DoctorSpecilazion> getdata()
	{
	   return ds.findAll();
	}
	
	public int dsc()
	{
		return (int) ds.count();
	}

}
