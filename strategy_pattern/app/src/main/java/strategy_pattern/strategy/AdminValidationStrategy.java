package strategy_pattern.strategy;

import strategy_pattern.User;

public class AdminValidationStrategy implements IValidationStrategy {
    @Override
    public boolean validate(User user) {
        System.out.println("Validating admin user: " + user.getUsername());
        return "admin".equalsIgnoreCase(user.getRole());
    }
}
