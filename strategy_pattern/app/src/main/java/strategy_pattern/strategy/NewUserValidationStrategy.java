package strategy_pattern.strategy;

import strategy_pattern.User;

public class NewUserValidationStrategy implements IValidationStrategy{
    @Override
    public boolean validate(User user) {
        System.out.println("Validating new user: " + user.getUsername());
        return user.getUsername().length() >= 5;
    }
}
