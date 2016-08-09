package packt;

class OverloadingDemo {

    public int max(int n1, int n2, int n3) {
        return 0;
    }

    public float max(long n1, long n2, long n3) {
        return 0.0f;
    }

    public float max(float n1, float n2) {
        return 0.0f;
    }
    
    public int max(int ... n1) {
        return 0;
    }   
}
