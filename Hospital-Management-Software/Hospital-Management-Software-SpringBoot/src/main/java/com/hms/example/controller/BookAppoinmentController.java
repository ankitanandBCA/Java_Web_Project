package com.hms.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.example.entity.BookAppoinment;
import com.hms.example.service.BookAppoinmentService;

@RestController
@RequestMapping("/Appoinment")
public class BookAppoinmentController {
	
	
	@Autowired
	BookAppoinmentService bas;
	
	@PostMapping("/Book")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public BookAppoinment book(@RequestBody BookAppoinment b)
	{
		return bas.addAppoinment(b);
	}
	
	@GetMapping("/getAppoinment")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public List<BookAppoinment> getappoinment()
	{
		 return bas.getdata();
	}
    
	@GetMapping("/count")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public int countappoinment()
	{
		 return bas.appcount();
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins="http://127.0.0.1:5500")
	public Boolean deleteappoin(@PathVariable String id)
	{
		bas.deleteapp(id);
		return true;
	}
}
