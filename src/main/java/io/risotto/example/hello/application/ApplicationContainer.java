package io.risotto.example.hello.application;

import static io.risotto.binding.BasicBinding.bind;

import io.risotto.Container;
import io.risotto.annotations.Child;
import io.risotto.example.hello.persistence.PersistenceContainer;

import java.util.Scanner;

@Child(containerClass = PersistenceContainer.class, name = "persistence")
public final class ApplicationContainer extends Container {
  @Override
  protected void configure() {
    // When an instance of Scanner is requested the Scanner wrapping System.in
    // will be injected.
    // Private scope prevents the binding from being visible from outside the container
    addBinding(bind(Scanner.class).toInstance(new Scanner(System.in)).privateScope());

    // A new Application instance will be created upon a request.
    // We use protected scope to make the binding visible for requests using getInstance()
    addBinding(bind(Application.class).toClass(Application.class).protectedScope());

    // adding the @Child annotation has the same effect as:
    // addChild(container(PersistenceContainer.class).as("persistence"));
  }
}
