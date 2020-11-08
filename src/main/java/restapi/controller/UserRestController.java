package restapi.controller;

import dk.via.restapi.dao.UserDAO;
import dk.via.restapi.dao.UserDAOImpl;
import dk.via.restapi.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    UserDAO userDAO;
    public UserRestController(){
        this.userDAO = new UserDAOImpl();

    }
  // a getmapping method(client gets a resource (i.e. user) from server)
    // a postmapping adds or updates an existing resource (i.e. add new or update existing user)
    // a putmapping creates a new resource(i.e. user)  in the server
    // a deletemapping, removes a resource( i.e.user) from the server
  //url to expose and type of mapping

    @GetMapping("/user")
    public User getUser(){
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("sam@gmail.com");
        user1.setPassword("1234567");
        return user1;
    }


    @PutMapping("/user")
    public String createUser(@RequestBody User user) //expects a JSON from client converted to a User object
    {
        return userDAO.createUser(user);

    } //putmapping

    @GetMapping("/read/{id}")
    public User readUser(@PathVariable int id) //expect client to send an integer in the URL
    {
       return userDAO.readUser(id);
    }//getmapping

    @PostMapping("/user")
    public void updateUser(@RequestBody User user) // client is making a request and sending a user to us to update
    {
        userDAO.updateUser(user);

    }//postmapping

    @DeleteMapping("/user") //client sends a user to us to delete
    public void deleteUser(@RequestBody User user)
    {
        userDAO.deleteUser(user);
    } // deletemapping

    @GetMapping("/validate/{email}/{password}")
    public User validateUser(@PathVariable String email, @PathVariable String password)
    {
       return userDAO.validateUser(email, password);
    } //getmapping

    @GetMapping("/change/{id}/{newPassword}")
    public void changePassword(@PathVariable int id, @PathVariable String newPassword){
       userDAO.changePassword(id, newPassword);
    }//postmapping

}
