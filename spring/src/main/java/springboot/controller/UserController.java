package springboot.controller;


import springboot.entity.User;
import springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService service;
    @CrossOrigin
    @GetMapping("/login")
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }
    @CrossOrigin
    @PostMapping("/login")
    public String login(@RequestBody User user ) {
    	User oauthUser = service.login(user.getemail(), user.getpassword());
    	System.out.print("user "+ oauthUser.getemail() +oauthUser.getpassword() + oauthUser.getprofile()+ oauthUser.getName()  );
    	if(Objects.nonNull(oauthUser)) 
    	{	
    			if(oauthUser.getprofile().compareTo("admin")==0)
    				return "admin";
    			else
        			if(oauthUser.getprofile().compareTo("sale")==0)
        				return "sale";
        			else
        				return "manager";
    	} else {
    		return "/login";
    		
    	
    	}
 
}
    @CrossOrigin
    @PostMapping("/addUser")
    public User addUser(@RequestBody User User) {
        return service.saveUser(User);
    }
    @CrossOrigin
    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> Users) {
        return service.saveUsers(Users);
    }
    @CrossOrigin
    @GetMapping("/Users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }
    @CrossOrigin
    @GetMapping("/UserById/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }
    @CrossOrigin
    @GetMapping("/User/{name}")
    public User findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }
    @CrossOrigin
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User User) {
        return service.updateUser(User);
    }
    @CrossOrigin
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
