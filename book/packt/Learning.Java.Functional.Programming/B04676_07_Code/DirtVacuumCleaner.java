package packt;

public class DirtVacuumCleaner implements VacuumCleaner {

    public DirtVacuumCleaner() {
        System.out.println("Creating DirtVacuumCleaner");
    }

    @Override
    public void vacuum() {
        System.out.println("Vacuuming dirt");
    }

    @Override
    public void clean() {
        System.out.println("Cleaning Dirt Vucuum Cleaner");
    }
    
}
