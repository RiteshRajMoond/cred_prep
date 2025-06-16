package factory_method.users;

public abstract class User {
    protected String role;

    public String getRole() {
        return role;
    }

    public abstract void accessSystem();
    
}
