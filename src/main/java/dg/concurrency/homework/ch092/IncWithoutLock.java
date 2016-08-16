package dg.concurrency.hw.ch092;

public class IncWithoutLock implements Runnable{
    private MyInt intValue;
    private final int maxM;
    private int count;

    public IncWithoutLock(MyInt _intValue) {
        intValue = _intValue;
        maxM     = 1000000;
        count    = 0;
    }

    public IncWithoutLock(MyInt _intValue, int _maxM) {
        intValue = _intValue;
        maxM     = _maxM;
        count    = 0;
    }

    @Override
    public void run() {
        // should not use following code,
        // since get() and inc() are seperated, may cause data racing
//      while(true) {
//          if(intValue.getIntValue().get() < maxM){
//            intValue.inc();
//          }else{
//            break;
//          }
//      }

        while(intValue.incWithLimit(maxM)) {count++;}

//      String threadName = Thread.currentThread().getName();
//      System.out.println("Thread ["+threadName+"]'s value: "
//                      +intValue.getIntValue()+"|"+count);
    }

    public Integer getIntValue() {
        return intValue.getIntValue().get();
    }

    public void setIntValue(MyInt intValue) {
        this.intValue = intValue;
    }

    public int getMaxM() {
        return maxM;
    }


}
