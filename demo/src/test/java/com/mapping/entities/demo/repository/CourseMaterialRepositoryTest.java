package com.mapping.entities.demo.repository;

import com.mapping.entities.demo.entity.Course;
import com.mapping.entities.demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest
{
    @Autowired
    private CourseMaterialRepository repository;
    @Test
    public void saveCourseMaterial(){

        Course course=Course.builder()
                            .title(".net")
                            .credit(6)
                            .build();
        Course course1= Course.builder()

                              .build();

        CourseMaterial courseMaterial=
                CourseMaterial.builder()
                              .url( "www.geeksforgeeks.com" )
                              .course( course )
                              .build();

        repository.save( courseMaterial );
    }
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList=repository.findAll();
        System.out.println( "courseMaterialList = " + courseMaterialList );
    }
}