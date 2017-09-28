package com.glick.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.glick.api.model.Food;
import com.glick.api.model.User;
import com.glick.api.repository.FoodRepository;

@Service
public class FoodService {
	@Autowired
	private FoodRepository foodRepository;

	public List<Food> listAll() {
		return foodRepository.findAll();
	}

	public Food find(Long id) {
		Food food = foodRepository.findOne(id);

		if (food == null) {
			throw new ResourceNotFoundException("Food reading not found.");
		}

		return food;

	}

	public List<Food> findByUser(User User) {
		return foodRepository.findByUser(User);
	}

	public List<Food> findByFoodDateBetween(Date startDate, Date endDate) {
		return foodRepository.findByModifyDateBetween(startDate, endDate);
	}

	public Food save(User user, Food food) {
		food.setUser(user);

		return foodRepository.save(food);
	}

	public List<Food> save(User user, List<Food> foods) {
		for (Food food: foods) {
			food.setUser(user);
		}

		return foodRepository.save(foods);
	}

	public void delete(Long id) {
		try {
			foodRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Food not found.");
		}
	}

	public void update(User user, Food food) {
		isPresent(food);
		food.setUser(user);
		foodRepository.save(food);
	}

	private void isPresent(Food food) {
		find(food.getId());
	}
}
