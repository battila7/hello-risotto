package io.risotto.example.hello.application;

import io.risotto.annotations.Inject;
import io.risotto.example.hello.persistence.GreetingSupplier;

import java.util.Scanner;

public final class Application {
  @Inject
  private Scanner scanner;

  @Inject
  private GreetingSupplier greetingSupplier;

  public void run() {
    System.out.println("Please enter your name:");

    do {
      String greeting = greetingSupplier.getGreetings();

      String name = scanner.nextLine();

      System.out.println(greeting + ", " + name + "!");
    } while(scanner.hasNextLine());
  }
}
