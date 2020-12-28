package com.example.backendDB.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("video")
public class VideoController {
	

	@Value("${upload.videos}")
	private String uploadfolder;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public void videoUpload(MultipartFile image) throws IllegalStateException, IOException
	{
    image.transferTo(new File(uploadfolder+image.getOriginalFilename()));
    
	}
	
	@RequestMapping(value="/download/{filename}")
	public ResponseEntity<ByteArrayResource> getVideoDownload(@PathVariable String filename) throws IOException
	{
		 Path path=Paths.get(uploadfolder+filename);
    	 byte [] bytes=Files.readAllBytes(path);
    	 ByteArrayResource bar=new ByteArrayResource(bytes);
    	 return new ResponseEntity<ByteArrayResource>(bar,HttpStatus.OK);
    			 
	}
	
	
	@RequestMapping(value="/all")
	public ResponseEntity<String[]> getAllVideos()
	{
		File file=new File(uploadfolder);
		String[] filelist=file.list();
		return new ResponseEntity<String[]>(filelist,HttpStatus.OK);
	}

}
