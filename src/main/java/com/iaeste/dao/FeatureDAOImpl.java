package com.iaeste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iaeste.model.Feature;


@Transactional
@Repository
public class FeatureDAOImpl implements FeatureDAO{

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@Override
	public List<Feature> getAllFeatures() {
		String HQL = "FROM Feature as f ORDER BY f.id";
		return (List<Feature>) entityManager.createQuery(HQL).getResultList();
	}

	@Override
	public Feature getFeatureById(int featureId) {
		return entityManager.find(Feature.class, featureId);
	}

	@Override
	public void addFeature(Feature feature) {
		entityManager.persist(feature);
		
	}

	@Override
	public void updateFeature(Feature feature) {
		Feature fe = getFeatureById(feature.getId());
		if(fe != null){
			fe.setTitle(feature.getTitle());
			fe.setDescription(feature.getDescription());
			fe.setImage(feature.getImage());
			entityManager.flush();
		}else{
			System.out.println("Feature doesn't exist which u want update.");
		}
		
	}

	@Override
	public void deleteFeaturec(int featureId) {
		Feature feature = getFeatureById(featureId);
		if(feature != null)
		entityManager.remove(feature);
		else
			System.out.println("Feature doesn't exist which u want delete.");	
		
	}

}
