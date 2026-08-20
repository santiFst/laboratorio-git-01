import java.util.concurrent.ThreadLocalRandom;

public class SensorHumedadSuelo extends Sensor {

    //Atributos
    private double humedadPct;

    public SensorHumedadSuelo(int id, String ubicacion, boolean activo) {
        super(id, ubicacion, activo);
        this.humedadPct = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
    }

    @Override
    public double tomarLectura() {
        if (isActivo()){
            return humedadPct;
        }else{
            return 0.0;
        }
       
    }

    @Override
    public String evaluarEstado() {
        if (!isActivo()) return "INACTIVO";
        if (humedadPct < 20.0) return "ALERTA: Sequía extrema (" + String.format("%.2f", humedadPct) + "%)";
        if (humedadPct > 80.0) return "ALERTA: Suelo encharcado (" + String.format("%.2f", humedadPct) + "%)";
        return "OPTIMO (" + String.format("%.2f", humedadPct) + "%)";
    }

    //SETTERS
    public void setHumedad(double humedadPct) {
        this.humedadPct = humedadPct;
    }
    //GETTERS
    public double getHumedad() {
        return humedadPct;
    }   
}
