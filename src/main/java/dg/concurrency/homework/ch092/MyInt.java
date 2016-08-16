package dg.concurrency.hw.ch092;

import java.util.concurrent.atomic.AtomicInteger;

public class MyInt {
    private AtomicInteger intValue;

    public MyInt(AtomicInteger _intValue) {
        intValue = _intValue;
    }

    public void inc(){
        int curr = intValue.get();
        intValue.compareAndSet(curr, curr+1);
    }

    public boolean incWithLimit(int limit){
        int curr = intValue.get();
        while (curr < limit) {
            if(intValue.compareAndSet(curr, curr+1)){
                return true;
            }else{
                curr = intValue.get();
            }
        }
        return false;
    }

    public AtomicInteger getIntValue() {
        return intValue;
    }

    public void setIntValue(AtomicInteger intValue) {
        this.intValue = intValue;
    }

}
