package com.parkwell;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SpringFileUploadController {


	@GetMapping("/index")
	public String testing () {
		return "uploader";
	}

	// Things to consider 
	// File path is different for mac users & windows users 
	// User name is also going to be different 
	
  @PostMapping("/upload") 
  public ResponseEntity<?> handleFileUpload( @RequestParam("file") MultipartFile file ) {

    String fileName = file.getOriginalFilename();
    try {
      file.transferTo( new File("/Users/desireevanassche/parkwell/CompareExcel/upload/" + fileName)); 
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } 
    return ResponseEntity.ok("File uploaded successfully.");
  }
  
  

}