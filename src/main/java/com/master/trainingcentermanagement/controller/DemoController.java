package com.master.trainingcentermanagement.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/api/v1/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from secured endpoint");
    }


    @GetMapping("/api/v1/bye")
    public ResponseEntity<String> sayBye(){
        return ResponseEntity.ok("Bye from secured endpoint");
    }


    @GetMapping("/api/v2/bye")
    public ResponseEntity<String> sayBye2(){
        return ResponseEntity.ok("Bye2 from secured endpoint");
    }



    @PostMapping("/api/v1/bye")
    public ResponseEntity<String> sayByePost(@RequestParam int id){
        return ResponseEntity.ok("id is " + id);
    }

    @PostMapping("/api/v2/bye")
    public ResponseEntity<String> sayByePost2(@RequestParam int id){
        return ResponseEntity.ok("id is " + id);
    }


}
