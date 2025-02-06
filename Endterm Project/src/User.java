public class User implements Describable, Observer {
    private String username;
    private boolean isAdmin;

    public User(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
    }

    @Override
    public String getDescription() {
        return "Имя пользователя: " + username + ", Администратор: " + isAdmin;
    }

    @Override
    public void update() {
        System.out.println("Новая книга добавлена! Проверьте библиотеку, ");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
