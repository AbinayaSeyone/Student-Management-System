package com.mapping.entities.demo.repository;

import com.mapping.entities.demo.entity.Guardian;
import com.mapping.entities.demo.entity.Student;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest
{
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student=Student.builder()
                               .emailId( "123@gmail.com")
                                .firstName( "Abi" )
                                .lastName( "Naya" )
                                //.guardianName( "ishu" )
                                //.guardianEmail( "234@gmail.com" )
                                //.guardianMobile( "0778484172" )
                                .build();

        studentRepository.save( student );
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                                  .email( "234@gmail.com" )
                                  .name( "Naya" )
                                  .mobile("9999")
                                  .build();

        Student student=Student.builder()
                                .firstName( "Ishu" )
                                .emailId( "ishu@gmail.com" )
                                .lastName( "Anuraj" )
                                .guardian( guardian)
                               .build();

        studentRepository.save( student );
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();

        System.out.println("studentList = "+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students=studentRepository.findByFirstName( "Abi" );
        System.out.println( "students = " + students );
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students=studentRepository.findByFirstNameContaining( "A" );
        System.out.println( "students = " + students );
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=studentRepository.findByGuardianName( "ishu" );
        System.out.println( "students = " + students );
    }
    @Test
    public  void printGetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress( "123@gmail.com" );
        System.out.println( "student = " + student );
    }
    @Test
    public  void printGetStudentFirstNameByEmailAddress(){
       String firstName=studentRepository.getStudentFirstNameByEmailAddress( "123@gmail.com" );
        System.out.println( "student = " + firstName );
    }
    
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative( "123@gmail.com" );
        System.out.println( "student = " + student );
    }
    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeNamedParam( "123@gmail.com" );
        System.out.println( "student = " + student );
    }
    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Abi17",
                "123@gmail.com"
        );
    }

}