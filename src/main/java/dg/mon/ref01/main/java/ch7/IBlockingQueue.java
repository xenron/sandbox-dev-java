package ch7;

public interface IBlockingQueue<T> {
    public T take() throws InterruptedException;
    public void put(T obj) throws InterruptedException;
}
