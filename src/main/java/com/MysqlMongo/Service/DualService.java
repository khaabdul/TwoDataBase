package com.MysqlMongo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MysqlMongo.DTO.CoursesDto;
import com.MysqlMongo.DTO.StudentDto;
import com.MysqlMongo.Entity.CoursesBean;
import com.MysqlMongo.Entity.StudentBean;
import com.MysqlMongo.Exception.UserNotFound;
import com.MysqlMongo.Repo.CoursesRepo;
import com.MysqlMongo.Repo.StudentRepo;

@Service
public class DualService {
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private CoursesRepo coursesRepo;
	@Autowired
	private StudentDto studentDto;
	@Autowired
	private CoursesDto coursesDto;
	int lastId;

	public StudentDto insert(StudentDto studentDto) {
		StudentBean studentBean = new StudentBean();
		BeanUtils.copyProperties(studentDto, studentBean);
		studentRepo.save(studentBean);
		List<CoursesDto> coursesDto = studentDto.getCoursesDto();
		List<CoursesBean> findAll = coursesRepo.findAll();
		if (!findAll.isEmpty()) {
			CoursesBean lastCourse = findAll.get(findAll.size() - 1);
			lastId = lastCourse.getId();
		}
		for (CoursesDto coursesdto : coursesDto) {
			CoursesBean coursesBean = new CoursesBean();
			BeanUtils.copyProperties(coursesdto, coursesBean);
			coursesBean.setId(lastId += 1);
			coursesRepo.save(coursesBean);
		}
		return studentDto;
	}

	public StudentDto update(String email, StudentDto studentDto) {
		return null;
	}

	public String delete(String email) {
		studentRepo.delete(studentRepo.findByEmail(email).orElseThrow(() -> new UserNotFound("Invalid Email Id")));
		coursesRepo.deleteByEmail(coursesRepo.findByEmail(email)
				.orElseThrow(() -> new UserNotFound("Courses Not Present")).get(0).getEmail());

		return "SuccessFull";
	}

	public StudentDto read(String email) {
		StudentBean student = studentRepo.findByEmail(email).orElseThrow(() -> new UserNotFound("Invalid Email Id"));
		BeanUtils.copyProperties(student, studentDto);
		List<CoursesBean> courses = coursesRepo.findByEmail(email)
				.orElseThrow(() -> new UserNotFound("Courses Not Present"));
		List<CoursesDto> coursesList = courses.stream().map(coursesBean -> {
			BeanUtils.copyProperties(coursesBean, coursesDto);
			return coursesDto;
		}).collect(Collectors.toList());
		studentDto.setCoursesDto(coursesList);
		return studentDto;
	}

	public List<StudentDto> readAll() {
		List<StudentDto> studentList = new ArrayList<StudentDto>();
		List<StudentBean> student = Optional.ofNullable(studentRepo.findAll())
				.orElseThrow(() -> new UserNotFound("Data Not Present"));
		for (StudentBean studentBean : student) {
			List<CoursesDto> coursesList = new ArrayList<CoursesDto>();
			StudentDto studentDto = new StudentDto();
			BeanUtils.copyProperties(studentBean, studentDto);
			List<CoursesBean> courses = coursesRepo.findByEmail(studentDto.getEmail())
					.orElseThrow(() -> new UserNotFound("Courses Not Present"));
			for (CoursesBean coursesBean : courses) {
				CoursesDto coursesDto = new CoursesDto();
				BeanUtils.copyProperties(coursesBean, coursesDto);
				coursesList.add(coursesDto);
			}
			studentDto.setCoursesDto(coursesList);
			studentList.add(studentDto);
		}
		return studentList;
	}
}
