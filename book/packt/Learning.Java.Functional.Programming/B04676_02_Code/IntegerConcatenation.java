package packt;

@FunctionalInterface
public interface IntegerConcatenation {
    public String concatenate(Integer n1, Integer n2) throws IllegalArgumentException;
}
