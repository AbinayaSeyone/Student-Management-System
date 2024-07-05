package com.mapping.entities.demo.repository;

import com.mapping.entities.demo.entity.Course;
import com.mapping.entities.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest
{
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){

        Course courseAutomata= Course.builder()
                               .title( "Automata" )
                               .credit( 3 )
                             .build();
        Course courseAI= Course.builder()
                             .title( "AI" )
                             .credit( 2)
                             .build();

        Teacher teacher=Teacher.builder()
                                .firstName( "Anoji" )
                                .lastName( "Vimalenthiran" )
                                //.courses( List.of(courseAutomata,courseAI) )
                               .build();
        teacherRepository.save( teacher );
    }
}