package com.example.demo.Repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository

public class UserRepository {
	public int id = 1;
	private List<User> users;
    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User(id++, "admin", "admin", true));
        users.add(new User(id++, "user", "user", false));
    }

    public boolean checkRights(User user) {
        return user.isAdminrights();
    }
}
