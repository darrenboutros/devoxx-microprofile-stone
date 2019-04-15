package fr.devoxx.microprofile.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import fr.devoxx.microprofile.model.Stone;

@ApplicationScoped
public class StoneService {

	private Map<Integer, Stone> stones = new HashMap<>();
	
	@PostConstruct
	public void init() {
		stones.put(1, new Stone(1, "Time", "Green"));
		stones.put(2, new Stone(2, "Power", "Purple"));
		stones.put(3, new Stone(3, "Space", "Blue"));
		stones.put(4, new Stone(4, "Reality", "Red"));
		stones.put(5, new Stone(5, "Soul", "Orange"));
		stones.put(6, new Stone(6, "Mind", "Yellow"));
	}

	public Stone findById(Integer id) {
		return  stones.get(id);
	}

	public List<Stone> findAll(){
		return stones.values().stream().collect(Collectors.toList());
	}
}
