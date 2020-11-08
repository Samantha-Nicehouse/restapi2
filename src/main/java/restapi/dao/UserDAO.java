package restapi.dao;

import dk.via.restapi.model.User;


public interface UserDAO {
// a getmapping method(client gets a resource (i.e. user) from server)
    // a postmapping adds or updates an existing resource (i.e. add new or update existing user)
    // a putmapping creates a new resource(i.e. user)  in the server
    // a deletemapping, removes a resource( i.e.user) from the server
    //url to expose and type of mapping

    public String createUser(User user); //putmapping
    public User readUser(int id); //getmapping
    public void updateUser(User user); //postmapping
    public void deleteUser(User user); // deletemapping
    public User validateUser(String email, String password); //getmapping
    public void changePassword(int id, String newPassword);//postmapping

}
