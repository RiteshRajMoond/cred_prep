/*
 * This source file was generated by the Gradle 'init' task
 */
package factory_method;

import factory_method.users.User;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        User admin = UserFactory.createUser("admin");
        System.out.println("User Role: " + admin.getRole());
        admin.accessSystem();


        User guest = UserFactory.createUser("guest");
        System.out.println("User Role: " + guest.getRole());
        guest.accessSystem();
    }
}
