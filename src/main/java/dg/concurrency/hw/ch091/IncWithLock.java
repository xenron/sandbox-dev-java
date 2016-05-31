package dg.concurrency.hw.ch091;

public class IncWithLock implements Runnable {
    private MyInt intValue;
    private final int maxM;
    private int count;

    public IncWithLock(MyInt _intValue) {
        intValue = _intValue;
        maxM     = 1000000;
        count    = 0;
    }

    public IncWithLock(MyInt _intValue, int _maxM) {
        intValue = _intValue;
        maxM     = _maxM;
        count    = 0;
    }

    @Override
    public void run() {
//      while(true) {
//        synchronized(intValue) {
//          if(intValue.getIntValue() < maxM){
//            intValue.inc();
//          }else{
//            break;
//          }
//        }
//      }

        while(intValue.incWithLimit(maxM)) {count++;}

//      String threadName = Thread.currentThread().getName();
//      System.out.println("Thread ["+threadName+"]'s value: "
//                      +intValue.getIntValue()+"|"+count);
    }

    public int getIntValue() {
        return intValue.getIntValue();
    }

    public void setIntValue(MyInt intValue) {
        this.intValue = intValue;
    }

    public int getMaxM() {
        return maxM;
    }

}
