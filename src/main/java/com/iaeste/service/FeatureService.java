package com.iaeste.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.iaeste.model.Feature;

public interface FeatureService {
	

	public abstract List<Feature> getAllFeatures();
	

	public abstract Feature getFeatureById(int featureId);
	
	@Secured ("ROLE_ADMIN")
	public abstract void addFeature(Feature feature);
	
	@Secured ("ROLE_ADMIN")
	public abstract void updateFeature(Feature feature);
	
	@Secured ("ROLE_ADMIN")
	public abstract void deleteFeaturec(int featureId);
	
}
