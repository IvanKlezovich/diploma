package com.example.diploma.exceptions.base;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RemoteException extends AbstractException {

    static final Locale RU_LOCALE = Locale.of("ru");

    protected RemoteException(RemoteExceptionBuilder<?, ?> builder) {
        super(builder);
    }

    public static RemoteExceptionBuilder<?, ?> builder() {
        return new RemoteExceptionBuilderImpl();
    }

    public abstract static class RemoteExceptionBuilder<C extends RemoteException, B extends RemoteExceptionBuilder<C, B>>
            extends AbstractExceptionBuilder<C, B> {

        public RemoteExceptionBuilder() {
        }

        public B messages(Map<Locale, String> messages) {
            this.messages = new HashMap<>(messages);
            this.message = messages.getOrDefault(RU_LOCALE, messages.values().stream().findAny().orElse(null));
            return self();
        }

        protected abstract B self();

        public abstract C build();
    }

    private static final class RemoteExceptionBuilderImpl extends RemoteExceptionBuilder<RemoteException, RemoteExceptionBuilderImpl> {
        private RemoteExceptionBuilderImpl() {
        }

        protected RemoteExceptionBuilderImpl self() {
            return this;
        }

        public RemoteException build() {
            return new RemoteException(this);
        }
    }
}
