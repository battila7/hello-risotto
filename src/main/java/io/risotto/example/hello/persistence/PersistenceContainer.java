package io.risotto.example.hello.persistence;

import io.risotto.Container;
import io.risotto.annotations.BindingSupplier;
import io.risotto.annotations.Named;
import io.risotto.annotations.WithScope;
import io.risotto.binding.scope.PrivateScope;
import io.risotto.binding.scope.ProtectedScope;

public final class PersistenceContainer extends Container {
  @BindingSupplier
  @WithScope(ProtectedScope.class)
  public GreetingSupplier greetingSupplier(GreetingLoader greetingLoader) {
    return new RandomGreetingSupplier(greetingLoader);
  }

  @BindingSupplier
  @WithScope(PrivateScope.class)
  public GreetingLoader greetingLoader(@Named("messagePath") String messagePath) {
    return new FileGreetingLoader(messagePath);
  }

  @BindingSupplier
  @Named("messagePath")
  @WithScope(PrivateScope.class)
  public String messagePath() {
    return "messages.txt";
  }
}
