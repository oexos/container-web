package com.service.servicetwo.controllers;

import com.service.servicetwo.dto.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("two")
@Slf4j
@CrossOrigin
public class ServiceTwoController {
    @GetMapping
    public List<Data> getOne(@RequestHeader Map<String, String> headers) throws InterruptedException {
        String response = "Response from GET /service-two/two at " + new Date() + "\n" + "All headers: " + headers;
        log.info(response);
//        Thread.sleep(3000);
        List<Data> dataList = Arrays.asList(
                new Data(2, "Data 2 From Service"),
                new Data(3, "Data 3 From Service"));
        return dataList;
    }

    @GetMapping("/name-check/{name}")
    public boolean checkIfNameExist(@PathVariable String name) throws InterruptedException {
        List<String> existingNames = new ArrayList<>();
        existingNames.add("Hazel");
        existingNames.add("bruice");
        existingNames.add("Jordan");
        Thread.sleep(3000);
        return existingNames.contains(name);
    }
}
