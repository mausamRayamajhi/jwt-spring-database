package com.iaeste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iaeste.model.Feature;
import com.iaeste.service.FeatureService;

@RestController
@RequestMapping("/admin")
public class FeatureController {
	
	@Autowired
	private FeatureService featureService;
	
	@GetMapping("/feature/{id}")
	public ResponseEntity<Feature> getFeatureById(@PathVariable("id") Integer id) {
		Feature feature = featureService.getFeatureById(id);
		return new ResponseEntity<Feature>(feature, HttpStatus.OK);
	}

	@GetMapping("/features")
	public ResponseEntity<List<Feature>> getAllFeatures() {
		List<Feature> list = featureService.getAllFeatures();
		return new ResponseEntity<List<Feature>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/feature")
	public  void addFeature(@RequestBody Feature feature) {
		featureService.addFeature(feature);
	}
	
	@PutMapping("/feature")
	public ResponseEntity<Feature> updateFeature(@RequestBody Feature feature) {
		featureService.updateFeature(feature);
		return new ResponseEntity<Feature>(feature, HttpStatus.OK);
	}
	
	@DeleteMapping("/feature/{id}")
	public ResponseEntity<Void> deleteFeature(@PathVariable("id") Integer id) {
		featureService.deleteFeaturec(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
}
