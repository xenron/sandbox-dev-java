package dg.concurrency.hw.ch091;

public class MyInt {
    private int intValue;

    public MyInt(int _intValue) {
        intValue = _intValue;
    }

    public void inc(){
        synchronized(this) {
            intValue ++;
        }
    }

    public boolean incWithLimit(int limit){
        synchronized(this) {
            if(intValue < limit){
                intValue ++;
                return true;
            }
            return false;
        }
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

}
