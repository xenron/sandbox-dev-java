package packt;

public class WaterVacuumCleaner implements VacuumCleaner {

    public WaterVacuumCleaner() {
        System.out.println("Creating WaterVacuumCleaner");
    }

    @Override
    public void vacuum() {
        System.out.println("Vacuuming water");
    }

    @Override
    public void clean() {
        System.out.println("Cleaning Water Vucuum Cleaner");
    }
    
}
