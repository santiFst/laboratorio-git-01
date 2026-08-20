import java.util.concurrent.ThreadLocalRandom;

public class SensorTemperatura extends Sensor{

    //Atributos
    private double celsius;

    public SensorTemperatura(int id, String ubicacion, boolean activo) {
        super(id, ubicacion, activo);
        this.celsius = ThreadLocalRandom.current().nextDouble(15.0, 45.0);
    }

    @Override
    public double tomarLectura() {
        if(isActivo()) {
            return celsius;
        }else{
            return 0.0;
        }
    }

    @Override
    public String evaluarEstado() {
        if (!isActivo()) return "INACTIVO";
        if (celsius > 38.0) return "ALERTA: Temperatura alta (" + String.format("%.2f", celsius) + "°C)";
        if (celsius < 18.0) return "ALERTA: Temperatura baja (" + String.format("%.2f", celsius) + "°C)";
        return "OPTIMO (" + String.format("%.2f", celsius) + "°C )";

    }

    //SETTERS
    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
    //GETTERS
    public double getCelsius() {
        return celsius;
    }

}

