package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.AssistantDto;
import com.master.trainingcentermanagement.service.impl.AssistantServiceImpl;
import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/v1/assistants")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class AssistantController {

    private final ModelMapper modelMapper;
    private final AssistantServiceImpl assistantService;
    private final UserRepo userRepo ;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public AssistantDto getAssistantById(@PathVariable Long id) {
        return assistantService.getAssistantById(id);
    }




    @GetMapping
    public List<AssistantDto> listAssistants(){
        return assistantService.listAssistants();
    }

    @DeleteMapping("/{id}")
    public void  deleteAssistant(@PathVariable Long id){
        assistantService.deleteAssistant(id);
    }

    @PostMapping
    public AssistantDto addAssistant(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam MultipartFile image
    ) throws IllegalStateException, IOException {
        String pathPhoto = "src/main/resources/static/photos/assistant/";


        User assistant = User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .phone(phone)
                .keywords(null)
                .password(passwordEncoder.encode(password))
                .image(null)
                .role(Role.ASSISTANT)
                .active(true)
                .build();

        assistant = userRepo.save(assistant);

        pathPhoto += assistant.getId();
        image.transferTo(Path.of(pathPhoto));
        String urlPhoto="http://localhost:8080/api/v1/assistants/photos/assistant/"+assistant.getId();

        assistant.setImage(urlPhoto);
        assistant = userRepo.save(assistant) ;

        return modelMapper.map(assistant , AssistantDto.class);
    }

    @GetMapping(path = "/photos/assistant/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable String id){
        String path="src/main/resources/static/photos/assistant/"+id;
        FileSystemResource file=new FileSystemResource(path);
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(file);
    }


}
