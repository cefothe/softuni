package com.cefothe.softuni.repositories;

import com.cefothe.softuni.entities.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cefothe on 27.04.17.
 */
@Repository
public interface CatRepository  extends CrudRepository<Cat,Long>{
}
