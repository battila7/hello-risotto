package io.risotto.example.hello.persistence;

import static io.risotto.binding.BasicBinding.bind;

import io.risotto.Container;

public final class PersistenceContainer extends Container {
  @Override
  protected void configure() {
    // Only GreetingSupplier is visible
    addBinding(
        bind(GreetingSupplier.class).toClass(RandomGreetingSupplier.class).protectedScope());

    addBinding(bind(GreetingLoader.class).toClass(FileGreetingLoader.class).privateScope());

    // There can be multiple bindings using String.class and we must differentiate between them.
    // Here we use a named binding using the name "messagePath". Injection of a specific named
    // binding can be requested using the @Named annotation.
    addBinding(bind(String.class).as("messagePath").toInstance("messages.txt").privateScope());
  }
}
