package fr.devoxx.microprofile.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	public static Function<List<StoneEntity>, List<Stone>> ToStones = (stoneEntities) ->{
		return stoneEntities.stream().map(se -> StoneMapper.ToStone.apply(Optional.of(se)).get()).collect(Collectors.toList());
	};

	public static  Function<Optional<Stone>, Optional<StoneEntity>> ToStoneEntity = (stone) ->{

		if (stone.isEmpty()) 
			return Optional.empty();

		Stone stoneTmp = stone.get();
		return Optional.of(new StoneEntity(stoneTmp.getId(), stoneTmp.getName(), stoneTmp.getColor())) ;


	};

	public static Function<List<Stone>, List<StoneEntity>> ToStoneEntities = (stones) ->{
		return stones.stream().map(s -> StoneMapper.ToStoneEntity.apply(Optional.of(s)).get()).collect(Collectors.toList());
	};

}
