package com.example.pizzeria.persistence.repository;

import com.example.pizzeria.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends CrudRepository<UserEntity,String> {
}
