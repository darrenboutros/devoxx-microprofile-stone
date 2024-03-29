package fr.devoxx.microprofile.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Stone")
@NamedQuery(name = "Stone.findAll", query = "SELECT s FROM StoneEntity s")
@NamedQuery(name = "Stone.findByName", query = "SELECT s FROM StoneEntity s WHERE " + 
		"s.name = :name")
@Data @AllArgsConstructor @NoArgsConstructor
public class StoneEntity {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String color;

}
