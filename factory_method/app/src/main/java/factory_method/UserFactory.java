package factory_method;

import factory_method.users.AdminUser;
import factory_method.users.GuestUser;
import factory_method.users.User;

public class UserFactory {
    public static User createUser(String userType) {
        switch (userType.toLowerCase()) {
            case "admin":
                return new AdminUser();
            case "guest":
                return new GuestUser();
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
}
