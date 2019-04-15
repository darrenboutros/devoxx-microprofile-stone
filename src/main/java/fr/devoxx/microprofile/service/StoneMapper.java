package fr.devoxx.microprofile.service;

import java.util.Optional;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;

import fr.devoxx.microprofile.entities.StoneEntity;
import fr.devoxx.microprofile.model.Stone;

public final class  StoneMapper {

	
	private StoneMapper() {
		super();
	}

	public static Function<Optional<StoneEntity>, Optional<Stone>> ToStone = (stoneEntity) ->{

			if (stoneEntity.isEmpty()) 
				return Optional.empty();
			
			StoneEntity stoneEntityTmp = stoneEntity.get();
		    return Optional.of( new Stone(stoneEntityTmp.getId(), stoneEntityTmp.getName(), stoneEntityTmp.getColor()));

		
	};

	public static  Function<Optional<Stone>, Optional<StoneEntity>> ToStoneEntity = (stone) ->{

			if (stone.isEmpty()) 
				return Optional.empty();
			
			Stone stoneTmp = stone.get();
			return Optional.of(new StoneEntity(stoneTmp.getId(), stoneTmp.getName(), stoneTmp.getColor())) ;
	
		
	};

}
