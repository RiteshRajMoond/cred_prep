package strategy_pattern;

import strategy_pattern.strategy.IValidationStrategy;

public class ValidationContext {
    private IValidationStrategy validationStrategy;

    public ValidationContext(IValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public void setStrategy(IValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validateUser(User user) {
        return validationStrategy.validate(user);
    }
}
