package com.mapping.entities.demo.repository;

import com.mapping.entities.demo.entity.Course;
import com.mapping.entities.demo.entity.Student;
import com.mapping.entities.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest
{
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printCourses(){
        List<Course> courses=courseRepository.findAll();
        System.out.println( "courses = " + courses );
    }
    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher= Teacher.builder()
                                 .firstName( "Perinpa" )
                                 .lastName( "Thaas" )
                                .build();
        Course course=Course.builder()
                              .title( "Python" )
                              .credit(7)
                              .teacher( teacher )
                            .build();

        courseRepository.save( course );
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords=
                PageRequest.of( 0,3 );
        Pageable secondPageWithTwoRecords =
                PageRequest.of( 1,2 );

List<Course> courses=courseRepository.findAll(secondPageWithTwoRecords).getContent();

Long totalElements=courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

long totalPages=courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println( "totalPages = " + totalPages );

        System.out.println( "totalElements = " + totalElements );

        System.out.println( "courses = " + courses );


    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle=
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc=
                PageRequest.of(
                        0,
                        2,
                        Sort.by( "credit" ).descending()
                );
        Pageable sortByTitleAndCreditDesc=
                PageRequest.of(
                        0,
                        2,
                        Sort.by( "title" )
                            .descending()
                            .and( Sort.by( "credit" ) )
                );

        List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
        System.out.println( "courses = " + courses );
    }
    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords= PageRequest.of( 0,10 )  ;
        List<Course> courses=courseRepository.findByTitleContaining(
                "D",
                firstPageTenRecords ).getContent();
        System.out.println( "courses = " + courses );
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher =Teacher.builder()
                                 .firstName( "Priyanga" )
                                 .lastName( "Talagala" )
                                .build();
        Student student=Student.builder()
                                .firstName( "Abhishek" )
                                .lastName( "seyone" )
                                .emailId( "abishek@gmail.com" )
                                .build();
        Course course=Course.builder()
                              .title( "Statistics" )
                              .credit( 3 )
                              .teacher( teacher )
                            .build();
        course.addStudents( student );

        courseRepository.save( course );

    }

}