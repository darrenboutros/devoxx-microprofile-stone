package fr.devoxx.microprofile.dao;

import java.util.List;
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
    
    public List<StoneEntity> findAll(){
    	return em.createNamedQuery("Stone.findAll", StoneEntity.class).getResultList();
    }
    
    public List<StoneEntity> findStoneByName(String name){
    	return em.createNamedQuery("Stone.findByName", StoneEntity.class)
    			.setParameter("name", name)
    			.getResultList();
    }

}
