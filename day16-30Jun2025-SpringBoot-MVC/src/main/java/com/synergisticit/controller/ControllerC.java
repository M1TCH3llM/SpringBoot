package com.synergisticit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // ✅ This is the key fix!
public class ControllerC {

    @RequestMapping("/c1")
    public ResponseEntity<String> c1() {
        String str = "Abraham\nBenjamin\nChris\nDavid\nEric";
        System.out.println(str);
        return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/c2")
    public ResponseEntity<String> c2() {
        String msg = "@RequestMapping(\"c2\") endpoint called";
        System.out.println(msg);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
