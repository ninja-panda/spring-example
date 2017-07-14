package com.tuturself.spring.boot.service;

import com.tuturself.spring.boot.model.Student;
import org.jfairy.Fairy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

	private static Map<Integer, Student> studentDB;

	private Fairy fairy = Fairy.create();

	@PostConstruct
	public void init() throws Exception {
		studentDB = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			Student student = new Student(i,fairy.person());
			studentDB.put(new Integer(i), student);
		}
	}

	public Student getStudentById(Integer studentId) {
		return studentDB.get(studentId);
	}
}
