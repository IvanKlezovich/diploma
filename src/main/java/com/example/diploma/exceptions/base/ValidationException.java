package com.example.diploma.exceptions.base;

public class ValidationException extends AbstractException {

    protected ValidationException(ValidationExceptionBuilder<?, ?> builder) {
        super(builder);
    }

    public static ValidationExceptionBuilder<?, ?> builder() {
        return new ValidationExceptionBuilderImpl();
    }

    public abstract static class ValidationExceptionBuilder<C extends ValidationException, B extends ValidationExceptionBuilder<C, B>>
            extends AbstractExceptionBuilder<C, B> {
        public ValidationExceptionBuilder() {
        }

        protected abstract B self();

        public abstract C build();
    }

    private static final class ValidationExceptionBuilderImpl
            extends ValidationExceptionBuilder<ValidationException, ValidationExceptionBuilderImpl> {
        private ValidationExceptionBuilderImpl() {
        }

        protected ValidationExceptionBuilderImpl self() {
            return this;
        }

        public ValidationException build() {
            return new ValidationException(this);
        }
    }
}
