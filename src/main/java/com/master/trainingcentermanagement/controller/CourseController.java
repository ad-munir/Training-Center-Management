package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.repository.CourseRepo;
import com.master.trainingcentermanagement.service.impl.CourseServiceImpl;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.nio.file.Path;
import org.modelmapper.ModelMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courses")

public class CourseController {
    private final ModelMapper modelMapper;

    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    CourseRepo courseRepo ;

    public CourseController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @PostMapping
    public CourseDto addCourse(
            @RequestParam String title,
            @RequestParam String hours,
            @RequestParam float cost,
            @RequestParam String ville,
            @RequestParam boolean online,
            @RequestParam String description,
            @RequestParam String type,
            @RequestParam String category,
            @RequestParam MultipartFile image,
            @RequestParam Long trainer_id
    ) throws IllegalStateException, IOException {
        String pathPhoto = "src/main/resources/static/photos/course/";
        CourseDto c = new CourseDto(title,hours,cost,ville,online,description,type,category,image,trainer_id);
        Long id = courseService.saveCourse(c) ;
        Course course = courseRepo.findById(id)
                .orElseThrow(()->new AppException("id course not found!", HttpStatus.NOT_FOUND));
        pathPhoto+=course.getId();
        image.transferTo(Path.of(pathPhoto));
        String urlPhoto="http://localhost:8080/photos/course/"+course.getId();
        course.setImage(urlPhoto);
        course = courseRepo.save(course) ;

        return modelMapper.map(course, CourseDto.class);

    }
    @GetMapping
    public List<CourseDto> findAllCourses(){

        return courseService.listCourses();
    }

    @DeleteMapping("/{id}")
    public void  deleteCompany(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

    @GetMapping(path = "/photos/course/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable String id){
        String path="src/main/resources/static/photos/course/"+id;
        FileSystemResource file=new FileSystemResource(path);
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(file);
    }
}
