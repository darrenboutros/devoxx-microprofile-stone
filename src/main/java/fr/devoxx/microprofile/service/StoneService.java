package fr.devoxx.microprofile.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import fr.devoxx.microprofile.dao.StoneDao;
import fr.devoxx.microprofile.entities.StoneEntity;
import fr.devoxx.microprofile.model.Stone;

@ApplicationScoped
public class StoneService {
	

	@Inject StoneDao stoneDao;
	
    public void saveAll(List<Stone> stones) {
    	List<StoneEntity> stoneEntities = StoneMapper.ToStoneEntities.apply(stones);
    	stoneEntities.forEach( se -> stoneDao.save(se));
    }
	
	public Stone findById(Integer id) {
		return StoneMapper.ToStone.apply(stoneDao.findById(id)).get();
	}

	public List<Stone> findAll(){
		return StoneMapper.ToStones.apply(stoneDao.findAll());
	}
	
	public List<Stone> findByName(String name){
	    return StoneMapper.ToStones.apply(stoneDao.findStoneByName(name));
	}
}
