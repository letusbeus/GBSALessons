package car;

import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping{


    private Refueling refueling;

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
        this.fuelType = FuelType.Diesel;
    }

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
        System.out.println("Автомобиль едет на заправку.");
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public void sweeping() {
        System.out.println("Автомобиль метет улицу");
    }

    @Override
    public void wipMirrors() {
        System.out.println("Зеркала снова чистые.");
    }

    @Override
    public void wipWindshield() {
        System.out.println("Лобовое стекло сияет.");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Фары протерты.");
    }
}
