package com.jpaway.SpringBootJPA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaway.SpringBootJPA.entity.User;
import com.jpaway.SpringBootJPA.jparepo.UserRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	
	@Autowired
	UserRepository userRepository ;
	
	 @PostMapping("/adduser")
	  User newUser(@RequestBody User newUser) {
	    return userRepository.save(newUser);
	  }

	  @GetMapping("/getuser")
	 //@RequestMapping(method=RequestMethod.GET ,value="/users")
	  List<User> all() {
	    return userRepository.findAll();
	  }

	
	@DeleteMapping("/deleteuser/{id}")
	//here id would be the parameter which can be passed along with the API end point
	// Parameter will be assigned as a method parameter
	public void deleteProduct(@PathVariable("id")int id) {
		//productRepository.deleteAll();
		userRepository.deleteById(id);

		}  
	
	//Update Operation
			// called as Put operation
		
	  @PutMapping("/products/{id}")
	    public ResponseEntity<User> updateProduct(@PathVariable int id) {
	    	User product = userRepository.findById(id)
	    .orElseThrow(() -> new RuntimeException("Product not exist with id :" + id));

	    	product.setName("cogent CS");
	    //user.setLastName(userDetails.getLastName());
	    //user.setEmailId(userDetails.getEmailId());
	    System.out.println("Success data got updated"); 
	    User updatedProduct = userRepository.save(product); //added toDB Again after modifying it
	    return ResponseEntity.ok(updatedProduct);
	    }




	}
	
	
	
	
	
