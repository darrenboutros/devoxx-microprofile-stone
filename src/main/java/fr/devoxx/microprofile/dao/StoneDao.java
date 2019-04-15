package fr.devoxx.microprofile.dao;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import fr.devoxx.microprofile.entities.StoneEntity;

@RequestScoped
@Transactional
public class StoneDao {
	
    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;
    
    public void save(StoneEntity stoneEntity){
    	em.persist(stoneEntity);
    }
	
    public Optional<StoneEntity> findById(Integer id){
    	return Optional.ofNullable(em.find(StoneEntity.class, id));
    }
    

}
