package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Image;
import com.example.demo.service.ImageService;

@RestController
@RequestMapping("/api/v1")
public class ImageController {
	
	private ImageService imageService;

	@Autowired
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@GetMapping("/images")
	public ResponseEntity<Iterable<Image>> getAllImage()
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(imageService.getAllImage());
	}
	
	@PostMapping("/image/delete/{id}")
	public void deleteImage(@PathVariable("id") UUID id) {
		Image image = imageService.findById(id);
		imageService.delete(image);
	}
	
	@PostMapping("/image/update/{id}")
	public void updateImage(@PathVariable("id") UUID id, @RequestParam("url") String imageUrl)
	{
		Image image = imageService.findById(id);
		image.setImageUrl(imageUrl);
		imageService.save(image);
	}
	
	@PostMapping("/addImage")
	public void addImage() {
		Image image = new Image(UUID.randomUUID(), "someImageurl here");
		imageService.save(image);
	}

}
