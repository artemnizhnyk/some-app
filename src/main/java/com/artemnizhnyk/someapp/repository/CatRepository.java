package com.artemnizhnyk.someapp.repository;

import com.artemnizhnyk.someapp.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
