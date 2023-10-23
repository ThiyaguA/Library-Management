package com.Shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shop.entity.MyBooks;

@Repository
public interface MyBooks_Repo extends JpaRepository<MyBooks, Integer>{

}
