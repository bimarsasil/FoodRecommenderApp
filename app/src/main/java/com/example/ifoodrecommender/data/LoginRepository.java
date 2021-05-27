package com.example.ifoodrecommender.data;

import com.example.ifoodrecommender.data.model.LoggedInUser;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private final LoginFBDSource loginFBDSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;
    // private constructor : singleton access
    private LoginRepository(LoginFBDSource dataSource) {
        this.loginFBDSource = dataSource;
    }

    public static LoginRepository getInstance(LoginFBDSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        loginFBDSource.logout();
    }

    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Boolean login(String username, String password) {
        // handle login
        final Boolean login = loginFBDSource.login(username, password);
        return login;
    }
}
