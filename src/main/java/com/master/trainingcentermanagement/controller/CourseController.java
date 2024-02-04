package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.entity.Company;
import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.repository.CompanyRepo;
import com.master.trainingcentermanagement.repository.CourseRepo;
import com.master.trainingcentermanagement.service.impl.CourseServiceImpl;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.nio.file.Path;
import org.modelmapper.ModelMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor

public class CourseController {

    private final ModelMapper modelMapper;
    private final CourseServiceImpl courseService;
    private final CourseRepo courseRepo;
    private final UserRepo userRepo;
    private final CompanyRepo companyRepo;



    @PostMapping
    public CourseDto addCourse(
            @RequestParam String title,
            @RequestParam String hours,
            @RequestParam float cost,
            @RequestParam String description,
            @RequestParam String type,
            @RequestParam(required = false) Long companyId,
            @RequestParam String category,
            @RequestParam MultipartFile image,
            @RequestParam Long trainerId
    ) throws IllegalStateException, IOException {

        String pathPhoto = "src/main/resources/static/photos/course";

        System.out.println(title);
        System.out.println(hours);
        System.out.println(type);
        System.out.println("companyId "+companyId);
        System.out.println("trainerId "+trainerId);

        Course c = Course.builder()
                .title(title)
                .hours(hours)
                .cost(cost)
                .description(description)
                .type(type)
                .category(category)
                .image(null)
                .trainer(userRepo.findById(trainerId).orElseThrow(() -> new AppException("Trainer not found", HttpStatus.NO_CONTENT)))
                .build();

        if (type.equals("COMPANY") && companyId != null) {
            System.out.println("type is company");
            // If type is COMPANY and companyId is provided, associate the course with the specified company
            Company comp = companyRepo.findById(companyId)
                    .orElseThrow(() -> new AppException("Company not found", HttpStatus.NO_CONTENT));

            c.addCompany(comp);
        }

        Course course = courseRepo.save(c);
        System.out.println("course saved");

        pathPhoto += "/" + course.getId();
        image.transferTo(Path.of(pathPhoto));
        String urlPhoto = "http://localhost:8080/api/v1/courses/photos/course/" + course.getId();

        course.setImage(urlPhoto);
        course = courseRepo.save(course);

        return modelMapper.map(course, CourseDto.class);
    }



    @GetMapping
    public List<CourseDto> findAllCourses(){

        return courseService.listCourses();
    }
    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        CourseDto courseDto = courseService.getCourseById(id);
        return courseDto;
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
