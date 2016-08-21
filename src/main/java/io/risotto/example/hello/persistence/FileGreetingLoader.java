package io.risotto.example.hello.persistence;

import io.risotto.annotations.Inject;
import io.risotto.annotations.Named;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

final class FileGreetingLoader implements GreetingLoader {
  private final String path;

  private List<String> messages;

  @Inject
  public FileGreetingLoader(@Named("messagePath") String path) {
    this.path = path;

    this.messages = null;
  }

  @Override
  public List<String> loadGreetings() {
    if (messages == null) {
      readFile();
    }

    return messages;
  }

  private void readFile() {
    ClassLoader classLoader = getClass().getClassLoader();

    try (
        InputStream fis = classLoader.getResourceAsStream(path);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr)
    ) {
      String line;

      messages = new ArrayList<>();

      while ((line = br.readLine()) != null) {
        messages.add(line);
      }
    } catch (IOException e) {
      messages = new ArrayList<>();
    }
  }
}
