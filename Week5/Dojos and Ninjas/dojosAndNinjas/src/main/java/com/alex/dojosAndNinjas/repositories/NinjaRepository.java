package com.alex.dojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alex.dojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	List<Ninja> findAll();
}
