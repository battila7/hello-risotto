package io.risotto.example.hello.persistence;

import java.util.List;

interface GreetingLoader {
  List<String> loadGreetings();
}
