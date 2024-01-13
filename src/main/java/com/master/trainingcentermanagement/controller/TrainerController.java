package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.TrainerDto;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.service.impl.TrainerServiceImpl;
import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import com.master.trainingcentermanagement.user.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trainers")
@CrossOrigin("http://localhost:4200")
public class TrainerController {

    private final ModelMapper modelMapper;

    @Autowired
    TrainerServiceImpl trainerService;

    @Autowired
    UserRepo userRepo ;

    public TrainerController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<TrainerDto> listTrainers(){

        return trainerService.listTrainers();
    }

    @DeleteMapping("/{id}")
    public void  deleteTrainer(@PathVariable Long id){
        trainerService.deleteTrainer(id);
    }

    @PostMapping
    public TrainerDto addCourse(
            @RequestParam  String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String keywords,
            @RequestParam MultipartFile image,
            @RequestParam Role role
    ) throws IllegalStateException, IOException {
        String pathPhoto = "src/main/resources/static/photos/trainer/";
        TrainerDto trn = new TrainerDto(firstname,lastname,email,phone,keywords,image,role);
        Long id = trainerService.saveTrainer(trn) ;
        User trainer = userRepo.findById(id)
                .orElseThrow(()->new AppException("id trainer not found!", HttpStatus.NOT_FOUND));
        pathPhoto+=trainer.getId();
        image.transferTo(Path.of(pathPhoto));
        String urlPhoto="http://localhost:8080/api/v1/trainers/photos/trainer/"+trainer.getId();
        trainer.setImage(urlPhoto);
        trainer = userRepo.save(trainer) ;
        return modelMapper.map(trainer , TrainerDto.class);

    }

    @GetMapping(path = "/photos/trainer/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable String id){
        String path="src/main/resources/static/photos/trainer/"+id;
        FileSystemResource file=new FileSystemResource(path);
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(file);
    }


}
