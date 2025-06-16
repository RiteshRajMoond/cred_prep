package strategy_pattern.strategy;

import strategy_pattern.User;

public interface IValidationStrategy {
    boolean validate(User user);
}
