package packt;

import java.util.Optional;

public class Part {
    private int partNumber;
    private String partName;
    private boolean outOfStock;

    public Part(int partNumber, String partName) {
        this.partNumber = partNumber;
        this.partName = partName;
    }

    public boolean isOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    public Optional<Part> outOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
        return Optional.of(this);
    }
    
    public Part setPartName(String partName) {
        this.partName = partName;
        return this;
    }
    
    public Optional<Part> partName(String partName) {
        this.partName = partName;
        return Optional.of(this);
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getPartName() {
        return partName;
    }
    
    public Optional<Part> replicatePartMonad() {
        // Replicate part
        System.out.println("Part replicated: " + this);
        return Optional.of(this);
    }

    @Override
    public String toString() {
        return "Part{" + "partNumber=" + partNumber + ", partName=" + partName + ", outOfStock=" + outOfStock + '}';
    }

}
