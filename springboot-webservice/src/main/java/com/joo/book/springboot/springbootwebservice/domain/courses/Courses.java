package com.joo.book.springboot.springbootwebservice.domain.courses;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.joo.book.springboot.springbootwebservice.domain.mapping.StudentCourse;
import com.joo.book.springboot.springbootwebservice.domain.students.Students;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

//    @OneToOne(mappedBy = "course")
//    private Students student;

//    @ManyToOne
//    private Students student;

//    @ManyToMany(mappedBy = "course")	
//    private Set<Students> student;

//	@OneToMany(mappedBy = "course")
//	private Set<Students> student;

	@OneToMany(mappedBy = "course")
	private Set<StudentCourse> student;
	
	@Builder
	public Courses(String name) {
		this.name = name;
		this.student = new HashSet<>();
	}

//    @Builder
//    public Courses(String name) {
//        this.name = name;
//    }
//
//    public void update(String name, Students student) {
//    	this.name = name;
//    	this.student = student;
//    }
//    
//    public void updateStudent(Students student) {
//    	this.student = student;
//    }

//	public void update(String name, Students student) {
//		this.name = name;
//		this.student.add(student);
//	}
	
	public void update(String name, StudentCourse student) {
		this.name = name;
		this.student.add(student);
	}
}
