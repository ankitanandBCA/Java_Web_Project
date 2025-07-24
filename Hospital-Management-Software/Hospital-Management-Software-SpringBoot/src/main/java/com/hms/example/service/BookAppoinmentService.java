package com.hms.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.example.entity.BookAppoinment;
import com.hms.example.repository.BookAppoinmentRepositry;

@Service
public class BookAppoinmentService {
	@Autowired
	BookAppoinmentRepositry bar;
	
	public BookAppoinment addAppoinment(BookAppoinment ba)
	{
		return bar.save(ba);
	}
	
	
	public List<BookAppoinment> getdata(){
		return bar.findAll();
	}
	
	public int appcount()
	{
		return (int) bar.count();
	}
	
	public Boolean deleteapp(String id)
	{
		bar.deleteById(id);
		return true;
	}

}
