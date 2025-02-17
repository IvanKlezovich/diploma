package com.example.diploma.exceptions.base;

import java.util.Locale;

public class InternalException extends AbstractException {

  public static final Locale RU_LOCALE = Locale.of("ru");

  protected InternalException(InternalExceptionBuilder<?, ?> builder) {
    super(builder);
  }

  public static InternalExceptionBuilder<?, ?> builder() {
    return new InternalExceptionBuilderImpl();
  }

  public abstract static class InternalExceptionBuilder<C extends InternalException, B extends InternalExceptionBuilder<C, B>>
      extends AbstractExceptionBuilder<C, B> {

    protected InternalExceptionBuilder() {
      locale(RU_LOCALE);
    }

    protected abstract B self();

    public abstract C build();
  }

  private static final class InternalExceptionBuilderImpl
      extends InternalExceptionBuilder<InternalException, InternalExceptionBuilderImpl> {

    private InternalExceptionBuilderImpl() {
    }

    protected InternalExceptionBuilderImpl self() {
      return this;
    }

    public InternalException build() {
      return new InternalException(this);
    }
  }
}
