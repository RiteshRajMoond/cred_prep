package factory_method.users;

public class AdminUser extends User{
    public AdminUser() {
        this.role = "Admin";
    }

    @Override
    public void accessSystem() {
        System.out.println("Admin user accessing system with full privileges.");
    }
}
