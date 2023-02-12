package authorization.model;

public class User {

    private String user;
    private String password;
    private Authorities[] authorities;
    public User(String user, String password, Authorities[] authorities) {
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
