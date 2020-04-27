package com.eadp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eadp.dao.IClazzDao;
import com.eadp.dto.StudentDTO;

@RestController
@RequestMapping("clazzes/query/")
public class ClazzController {
	@Autowired
	private IClazzDao clazzDao;

	@GetMapping("findByName")
	public ResponseEntity<?> findByName(StudentDTO student, Pageable pageable) {
		return ResponseEntity.ok(clazzDao.xxxMyName(student, pageable));
	}
}
