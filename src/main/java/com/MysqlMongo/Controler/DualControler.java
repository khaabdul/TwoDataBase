package com.MysqlMongo.Controler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MysqlMongo.DTO.StudentDto;
import com.MysqlMongo.Service.DualService;

@RestController
public class DualControler {
	@Autowired
	private DualService dualService;
	Logger logger = LoggerFactory.getLogger(DualControler.class);
	@PostMapping("/student")
	public ResponseEntity<StudentDto> insert(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(dualService.insert(studentDto), HttpStatus.OK);
	}

	@PutMapping("/student/{email}")
	public ResponseEntity<StudentDto> update(@PathVariable("email") String email, @RequestBody StudentDto studentDto) {
		return null;
	}

	@DeleteMapping("/student/{email}")
	public ResponseEntity<String> delete(@PathVariable("email") String email) {
		return new ResponseEntity<String>(dualService.delete(email), HttpStatus.OK);
	}

	@GetMapping("/student/{email}")
	public ResponseEntity<StudentDto> read(@PathVariable("email") String email) {
		return new ResponseEntity<StudentDto>(dualService.read(email), HttpStatus.OK);
	}

	@GetMapping("/student")
	public ResponseEntity<List<StudentDto>> readAll() {
		logger.error("Getting List Of User");
		return new ResponseEntity<List<StudentDto>>(dualService.readAll(), HttpStatus.OK);
	}
}
