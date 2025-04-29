package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<String, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void addUser(String email, User user) {
        users.put(email, user);
    }

    public User findByEmail(String email) throws NullPointerException
    {
        User user = users.get(email);
        if(user == null)
        {
            throw new NullPointerException();
        }
        return user;
    }

}
