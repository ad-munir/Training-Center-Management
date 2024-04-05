package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.CourseDto;
import com.master.trainingcentermanagement.dto.TrainerDto;
import com.master.trainingcentermanagement.entity.Course;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.service.impl.MailSenderServiceImp;
import com.master.trainingcentermanagement.service.impl.TrainerServiceImpl;
import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;


import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;


import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trainers")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class TrainerController {

    private final ModelMapper modelMapper;
    private final TrainerServiceImpl trainerService;
    private final UserRepo userRepo ;
    private final PasswordEncoder passwordEncoder;
    private final MailSenderServiceImp mailSenderServiceImp;

    @GetMapping("/{id}")
    public TrainerDto getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
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
    public TrainerDto addTrainer(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String keywords,
            @RequestParam String password,
            @RequestParam MultipartFile image
    ) throws IllegalStateException, IOException {
        String pathPhoto = "src/main/resources/static/photos/trainer/";


        User trainer = User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .phone(phone)
                .keywords(keywords)
                .password(passwordEncoder.encode(password))
                .image(null)
                .role(Role.TRAINER)
                .active(true)
                .build();

        trainer = userRepo.save(trainer);

        pathPhoto += trainer.getId();
        image.transferTo(Path.of(pathPhoto));
        String urlPhoto="http://localhost:8080/api/v1/trainers/photos/trainer/"+trainer.getId();

        trainer.setImage(urlPhoto);
        trainer = userRepo.save(trainer) ;

        return modelMapper.map(trainer , TrainerDto.class);
    }

    @PostMapping(path = "/extern")
    public TrainerDto addExternTrainer(
            @RequestParam  String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String keywords,
            @RequestParam String password,
            @RequestParam MultipartFile image
    ) throws IllegalStateException, IOException {
        String pathPhoto = "src/main/resources/static/photos/trainer/";


        User trainer = User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .phone(phone)
                .keywords(keywords)
                .password(passwordEncoder.encode(password))
                .image(null)
                .role(Role.TRAINER)
                .active(false)
                .build();

        trainer = userRepo.save(trainer);

        pathPhoto += trainer.getId();
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

//    @PostMapping("/validate/{id}")
//    public boolean validateExternTrainer(@PathVariable Long id) {
//        try {
//            User user = userRepo.findById(id).get();
//
//            if (user != null) {
//                Context context = new Context();
//                mailSenderServiceImp.sendEmailToTrainerExtern(user.getEmail(), "Confirmation of Acceptance as External Trainer for eTrain Platform", "trainer-extern-mail-template", context, user.getFirstname());
//
//                System.out.println("Trainer extern validation " + id);
//
//                user.setActive(true);
//                user = userRepo.save(user);
//
//                return true;
//            } else {
//                // Handle the case where the user with the given id is not found
//                return false;
//            }
//        } catch (Exception e) {
//            // Handle the exception (e.g., log it)
//            e.printStackTrace();
//            return false;
//        }
//   }

    @PostMapping("/validate/{id}")
    public ResponseEntity<Boolean> validateExternTrainer(@PathVariable Long id) {
        try {
            User user = userRepo.findById(id).orElse(null);

            if (user != null) {
                Context context = new Context();

                mailSenderServiceImp.sendEmailToTrainerExtern(user.getEmail(), "Welcome to Our Training platform!", "trainer-extern-mail-template", context, user.getFirstname());

                System.out.println("Trainer extern validation " + id);

                user.setActive(true);
                user = userRepo.save(user);

                return ResponseEntity.ok(true);
            } else {
                // Handle the case where the user with the given id is not found
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Handle the exception (e.g., log it)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{id}")
    public TrainerDto editTrainer(
            @PathVariable String id,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String keywords,
            @RequestParam String password,
            @RequestParam MultipartFile image
    ) throws IllegalStateException, IOException {
        String pathPhoto = "src/main/resources/static/photos/trainer/";


        User trainer = User.builder()
                .id(Long.valueOf(id))
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .phone(phone)
                .keywords(keywords)
                .password(password)
                .image(null)
                .role(Role.TRAINER)
                .active(true)
                .build();

        trainer = userRepo.save(trainer);

        pathPhoto += trainer.getId();
        image.transferTo(Path.of(pathPhoto));
        String urlPhoto="http://localhost:8080/api/v1/trainers/photos/trainer/"+trainer.getId();

        trainer.setImage(urlPhoto);
        trainer = userRepo.save(trainer) ;

        return modelMapper.map(trainer , TrainerDto.class);
    }


}
