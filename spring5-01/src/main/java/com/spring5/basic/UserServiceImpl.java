package com.spring5.basic;

public class UserServiceImpl implements UserService {
//    private UserDAO userDAO = new UserDAOImpl();
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) {
//        UserDAO userDAO = BeanFactory.getUserDAO();
//        UserDAO userDAO = (UserDAO) BeanFactory.getBean("userDAO");
        userDAO.save(user);
    }

    @Override
    public void login(String name, String password) {
//        UserDAO userDAO = BeanFactory.getUserDAO();
//        UserDAO userDAO = (UserDAO) BeanFactory.getBean("userDAO");
        userDAO.queryUserByNameAndPassword(name, password);
    }
}
