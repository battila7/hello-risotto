package io.risotto.example.hello;

import static io.risotto.ContainerSettings.container;

import io.risotto.Container;
import io.risotto.Risotto;
import io.risotto.example.hello.application.Application;
import io.risotto.example.hello.application.ApplicationContainer;

public class Main {
  public static void main(String[] args) throws Exception {
    // Kickoff Risotto by adding the root container
    Container rootContainer = Risotto.addRootContainer(container(ApplicationContainer.class));

    // Enter the dependency-managed context
    rootContainer.getInstance(Application.class).ifPresent(Application::run);
  }
}
