package restapi.dao;
import dk.via.restapi.model.User;

import java.util.ArrayList;

//Service Implementation

public class UserDAOImpl implements UserDAO {

    private ArrayList<User> users;

    public UserDAOImpl() {
        this.users = new ArrayList<User>();
    }

    @Override
    public String createUser(User user) {
        users.add(user);
        return "User " + user.getId() + " was created just now";
    }

    @Override
    public User readUser(int id) {
        //iterate through arraylist and find matching ID;
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                break;
            }
        }
    }

    @Override
    public void deleteUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.remove(i);
                break;
            }
        }
    }

    @Override
    public User validateUser(String email, String password) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)){
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public void changePassword(int id, String newPassword) {
               User u = readUser(id);//returns user object
                if(u != null){
                    u.setPassword(newPassword);
                    updateUser(u);
                }

    }


}
