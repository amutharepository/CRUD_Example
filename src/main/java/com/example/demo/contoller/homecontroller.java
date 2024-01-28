package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class homecontroller {
	
	@Autowired
	private StudentRepository sr;
	
	
	@GetMapping("/index")
	public String index() {
		return "welcome to index";	
	}
	
	@PostMapping("/posting")
	public Student savedata(@RequestBody Student data) {
		sr.save(data);
		return data;
		
	}
	@GetMapping("/allusers")
	public List<Student> findall(){
		
		List<Student> li= sr.findAll();
		return li;
		
	}
	@DeleteMapping("/delete/{rollno}")
	public String deletion(@PathVariable int rollno) {
		Student st=sr.findById(rollno).get();
		if(st!=null) {
			sr.delete(st);
		}
		
		return "deleted successfully";
	}
	@PutMapping("/update")
	public Student update(@RequestBody Student rollno) {	
		
	sr.save(rollno);
		return rollno;
	}

}
