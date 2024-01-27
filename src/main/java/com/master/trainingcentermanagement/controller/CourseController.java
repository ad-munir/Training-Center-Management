package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.repository.CourseRepo;
import com.master.trainingcentermanagement.service.impl.CourseServiceImpl;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.nio.file.Path;
import org.modelmapper.ModelMapper;
import java.io.IOException;
import java.util.List;
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



    @PostMapping
    public CourseDto addCourse(
            @RequestParam String title,
            @RequestParam String hours,
            @RequestParam float cost,
            @RequestParam String description,
            @RequestParam String type,
            @RequestParam String category,
            @RequestParam MultipartFile image,
            @RequestParam Long trainerId
    ) throws IllegalStateException, IOException {
        String pathPhoto = "src/main/resources/static/photos/course/";
//        User trainer = userRepo.findById(trainerId).get() ;


        Course c = Course.builder()
                        .title(title)
                        .hours(hours)
                        .cost(cost)
                        .description(description)
                        .type(type)
                        .category(category)
                        .image(null)
                        .trainer(userRepo.findById(trainerId).get())
                        .build();

        Course course = courseRepo.save(c) ;

        pathPhoto+=course.getId();
        image.transferTo(Path.of(pathPhoto));
        String urlPhoto="http://localhost:8080/api/v1/courses/photos/course/"+course.getId();


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
