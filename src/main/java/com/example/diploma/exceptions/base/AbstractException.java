package com.example.diploma.exceptions.base;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException implements ServiceException {

  @Getter
  private final Map<Locale, String> messages;
  private final Map<String, String> params;
  private final Integer httpCode;

  protected AbstractException(AbstractExceptionBuilder<?, ?> builder) {
    super(builder.message);
    this.messages = builder.messages;
    this.params = builder.params;
    this.httpCode = builder.httpCode;
  }

  @Override
  public Optional<Integer> getHttpCode() {
    return ofNullable(this.httpCode);
  }

  @Override
  public Map<String, String> getParams() {
    return params == null ? new HashMap<>() : params;
  }

  public abstract static class AbstractExceptionBuilder<C extends AbstractException, B extends AbstractExceptionBuilder<C, B>> {

    // 4 выбрано потому, что в большинстве случаев в мапе содержится всего два ключа
    protected Map<Locale, String> messages = new HashMap<>(4);
    protected String message;
    private Map<String, String> params;
    private Integer httpCode;
    private Locale locale = Locale.getDefault();

    public B message(String message) {
      this.messages.put(locale, message);
      this.message = message;
      return self();
    }

    public B params(Map<String, String> params) {
      this.params = params;
      return self();
    }

    public B httpCode(int httpCode) {
      this.httpCode = httpCode;
      return self();
    }

    public B httpCode(HttpStatus httpStatus) {
      return httpCode(httpStatus.value());
    }

    protected B locale(Locale locale) {
      this.locale = locale;
      return self();
    }

    protected abstract B self();

    public abstract C build();
  }
}
