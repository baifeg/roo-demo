package com.eadp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eadp.dao.IStudentDao;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	private IStudentDao studentDao;

	@GetMapping("findByName")
	public ResponseEntity<?> findByName(String name, Pageable pageable) {
		return ResponseEntity.ok(studentDao.findByNameNative(name));
	}
}
