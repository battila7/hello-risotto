package io.risotto.example.hello.persistence;

import io.risotto.annotations.Inject;

import java.util.List;
import java.util.Random;

final class RandomGreetingSupplier implements GreetingSupplier {
  private final Random random;

  private final GreetingLoader greetingLoader;

  @Inject
  public RandomGreetingSupplier(GreetingLoader greetingLoader) {
    this.greetingLoader = greetingLoader;

    this.random = new Random();
  }

  @Override
  public String getGreetings() {
    List<String> messages = greetingLoader.loadGreetings();

    return messages.get(random.nextInt(messages.size()));
  }
}
