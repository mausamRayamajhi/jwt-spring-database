package com.iaeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaeste.dao.FeatureDAO;
import com.iaeste.model.Feature;

@Service
public class FeatureServiceImpl implements FeatureService {

	@Autowired
	private FeatureDAO dao;
	
	@Override
	public List<Feature> getAllFeatures() {
		return dao.getAllFeatures();
	}

	@Override
	public Feature getFeatureById(int featureId) {
		return dao.getFeatureById(featureId);
	}

	@Override
	public void addFeature(Feature feature) {
		dao.addFeature(feature);
	}

	@Override
	public void updateFeature(Feature feature) {
		dao.updateFeature(feature);
	}

	@Override
	public void deleteFeaturec(int featureId) {
		dao.deleteFeaturec(featureId);
	}

}
