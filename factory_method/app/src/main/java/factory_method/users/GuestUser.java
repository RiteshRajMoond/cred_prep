package factory_method.users;

public class GuestUser extends User {
    public GuestUser() {
        this.role = "Guest";
    }

    @Override
    public void accessSystem() {
        System.out.println("Guest user accessing system with limited privileges.");
    }
}
