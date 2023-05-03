package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.NewEntity;


@Repository
public interface NewRepository extends JpaRepository<NewEntity,Long> {

}
