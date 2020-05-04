package Users;

public class User {

    private String mail;
    private String password;
    private String role;

    public User() {
    }

    public User(String mail, String password, String role) {
        this.mail = mail;
        this.password = password;
        this.role = role;
    }

    public String getMail() {
        return  mail;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!mail.equals(user.mail)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = mail.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
