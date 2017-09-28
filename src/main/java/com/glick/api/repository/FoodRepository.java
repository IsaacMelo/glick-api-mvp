package com.glick.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glick.api.model.Food;
import com.glick.api.model.User;

public interface FoodRepository extends JpaRepository<Food, Long>{
	List<Food> findByModifyDateBetween(Date startDate, Date endDate);
	List<Food> findByUser(User user);
}
