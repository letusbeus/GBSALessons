package car;
import java.awt.*;

public abstract class Car {

    // region Constructor

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    // endregion
    // region Public Methods

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();

    // Включение дворников
    public abstract boolean switchWipers();

    // Подметать улицу
//    public abstract void sweeping();

    public boolean switchFogLights(){
        fogLights = !fogLights;
        return fogLights;
    }

    // endregion
    // region Private Fields

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    private FuelType fuelType;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Сосотяние ПТФ
    private boolean fogLights = false;

    // endregion
}
