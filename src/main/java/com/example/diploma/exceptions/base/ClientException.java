package com.example.diploma.exceptions.base;

import java.util.Locale;

public class ClientException extends AbstractException {

  public static final Locale RU_LOCALE = Locale.of("ru");

  protected ClientException(ClientExceptionBuilder<?, ?> builder) {
    super(builder);
  }

  public static ClientExceptionBuilder<?, ?> builder() {
    return new ClientExceptionBuilderImpl();
  }

  public abstract static class ClientExceptionBuilder<C extends ClientException, B extends ClientExceptionBuilder<C, B>>
      extends AbstractExceptionBuilder<C, B> {

    public ClientExceptionBuilder() {
      locale(RU_LOCALE);
    }

    protected abstract B self();

    public abstract C build();
  }

  private static final class ClientExceptionBuilderImpl
      extends ClientExceptionBuilder<ClientException, ClientExceptionBuilderImpl> {

    private ClientExceptionBuilderImpl() {
    }

    protected ClientExceptionBuilderImpl self() {
      return this;
    }

    public ClientException build() {
      return new ClientException(this);
    }
  }
}
