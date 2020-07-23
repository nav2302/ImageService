package com.example.demo.service;

import java.util.UUID;

import com.example.demo.model.Image;

public interface ImageService {
	public Iterable<Image> getAllImage();

	public void delete(Image image);

	public Image findById(UUID id);

	public Image save(Image image);

}
