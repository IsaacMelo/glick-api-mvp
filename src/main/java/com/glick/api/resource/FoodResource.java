package com.glick.api.resource;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.glick.api.model.Food;
import com.glick.api.model.User;
import com.glick.api.service.FoodService;
import com.glick.api.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost","file://"})
@RequestMapping("/api/v1/user")
public class FoodResource {
	@Autowired
	private FoodService foodService;

	@Autowired
	private UserService userService;

	// Get a user and food
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/food", method = RequestMethod.GET)
	public ResponseEntity<?> findByFood(@PathVariable("id") Long userId) {
		User user = userService.find(userId);
		return ResponseEntity.status(HttpStatus.OK).body(foodService.findByUser(user));
	}
	
	// Get a user and glucose
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/food/{foodId}", method = RequestMethod.GET)
	public HttpEntity<?> findByGlucose(@PathVariable("id") Long userId, @PathVariable("foodId") Long foodId) {
		// User user = userService.find(userId);
		return ResponseEntity.status(HttpStatus.OK).body(foodService.find(foodId));
	}


	// Get a user and food
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/food", params = { "startDate", "endDate" }, method = RequestMethod.GET)
	public ResponseEntity<?> findByFoodDateBetween(@PathVariable("id") Long userId,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null, end = null;
		try {
			start = (Date) formatter.parse(startDate);
			end = (Date) formatter.parse(endDate);
			System.err.println(start.toString());
			System.err.println(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		userService.find(userId);
		return ResponseEntity.status(HttpStatus.OK).body(foodService.findByFoodDateBetween(start, end));
	}

	// Save new foods (list)
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/food", method = RequestMethod.POST)
	public ResponseEntity<Void> saveFood(@PathVariable("id") Long userId, @RequestBody List<Food> foods) {
		User user = userService.find(userId);
		foods = foodService.save(user, foods);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(uri).build();
	}

	// Delete food
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/food/{foodId:[\\d]+}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteFood(@PathVariable("id") Long id, @PathVariable("foodId") Long foodId) {
		foodService.delete(foodId);
		return ResponseEntity.noContent().build();
	}

	// Update food
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
	@RequestMapping(value = "/{id:[\\d]+}/food/{foodId:[\\d]+}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateFood(@RequestBody Food food, @PathVariable("id") Long userId,
			@PathVariable("foodId") Long foodId) {

		food.setId(foodId);
		User user = userService.find(userId);
		foodService.update(user, food);

		return ResponseEntity.noContent().build();
	}

}
