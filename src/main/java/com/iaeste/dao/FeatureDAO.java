package com.iaeste.dao;

import java.util.List;

import com.iaeste.model.Feature;

public interface FeatureDAO {
	public abstract List<Feature> getAllFeatures();
	public abstract Feature getFeatureById(int featureId);
	public abstract void addFeature(Feature feature);
	public abstract void updateFeature(Feature feature);
	public abstract void deleteFeaturec(int featureId);
}
