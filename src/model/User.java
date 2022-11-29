package model;

public class User extends Entity {
    private String username;
    private String emailAddress;
    private String password;

    private Role role;

    public User(String username, String emailAddress, String password, Role role, User owner) {
        super(owner);
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
