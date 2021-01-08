package viapos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.UserDao;
import viapos.model.User;

@Component
public class UserService extends BaseService {
    @Autowired
    UserDao userDao;

    public User loginUser(User user) {
        User loggedInUser = userDao.getUser(user.getUsername().toLowerCase());
        if (loggedInUser != null && loggedInUser.getPassword() != null
                && !loggedInUser.getPassword().isEmpty() && loggedInUser.getPassword().equals(user.getPassword())) {
            return loggedInUser;
        } else {
            return null;
        }
    }
}
