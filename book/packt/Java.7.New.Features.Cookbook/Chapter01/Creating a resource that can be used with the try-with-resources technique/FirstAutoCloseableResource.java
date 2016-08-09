package packt;

public class FirstAutoCloseableResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        // Close the resource as appropriate
        System.out.println("FirstAutoCloseableResource close method executed");
        throw new UnsupportedOperationException(
                "A problem has occurred in FirstAutoCloseableResource");
    }

    public void manipulateResource() {
        // Perform some resource specific operation
        System.out.println("FirstAutoCloseableResource manipulateResource method executed");
    }
}
