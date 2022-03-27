package com.example.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentRestController {

    private final BookRestConsumer consumer;

    @GetMapping("/data")
    public String getStudentInfo() {
        System.out.println(consumer.getClass().getName());
        return "Accessing from STUDENT-SERVICE ==> " +consumer.getBookData();
    }

    @GetMapping("/allBooks")
    public String getBooksInfo() {
        return "Accessing from STUDENT-SERVICE ==> " + consumer.getAllBooks();
    }

    @GetMapping("/getOneBook/{id}")
    public String getOneBookForStd(@PathVariable Integer id) {
        return "Accessing from STUDENT-SERVICE ==> " + consumer.getBookById(id);
    }

    @GetMapping("/entityData")
    public String printEntityData() {
        ResponseEntity<String> resp = consumer.getEntityData();
        return "Accessing from STUDENT-SERVICE ==> " + resp.getBody() +" , status is:" + resp.getStatusCode();
    }
}
