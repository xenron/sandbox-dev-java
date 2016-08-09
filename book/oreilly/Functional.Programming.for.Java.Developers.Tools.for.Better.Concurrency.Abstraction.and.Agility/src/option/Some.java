package option;

public final class Some<T> extends Option<T> {
  private final T value;

  public Some(T value) { this.value = value; }

  public boolean hasValue() { return true; }
  
  public T get() { return value; }

  @Override
  public String toString() { return "Some("+value+")"; }

  @Override
  public boolean equals(Object other) {
    if (other == null || other.getClass() != Some.class)
      return false;
    Some<?> that = (Some<?>) other;
    Object thatValue = that.get();
    return value.equals(thatValue);
  }

  @Override
  public int hashCode() { return 37 * value.hashCode(); }
}