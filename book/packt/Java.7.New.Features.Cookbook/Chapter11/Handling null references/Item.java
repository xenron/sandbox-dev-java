package packt;

import java.util.Objects;

public class Item {
   private String name;
   private int partNumber;
   
   public Item() {
       this("Widget", 0);
   }
   
   public Item(String name, int partNumber) {
       this.name = Objects.requireNonNull(name);
       this.partNumber = partNumber;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
//        this.name = Objects.requireNonNull(name, "The name field requires a non-null value");        
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.partNumber != other.partNumber) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + this.partNumber;
        return hash;
    }
    
    // Additional Objects class methods
//    @Override
//    public int hashCode() {
//        return Objects.hash(name,partNumber);
//    }
    
    @Override
    public String toString() {
        return name + " - " + partNumber;
    }
    
}

