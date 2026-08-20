import java.util.ArrayList;
import java.util.List;

public class EstacionMonitoreo {
    private List<Sensor> sensores;

    public EstacionMonitoreo() {
        this.sensores = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void procesarLecturas() {
        System.out.println("=== LECTURAS DE LOS SENSORES ===\n");
        for (Sensor sensor : sensores) {
            double lectura = sensor.tomarLectura();
            System.out.println("Sensor ID [" + sensor.getId() + "] en " + sensor.getUbicacion() +
                               " | Lectura: " + String.format("%.2f", lectura) +
                               " | Estado: " + sensor.evaluarEstado());
        }
    }

    public List<Sensor> obtenerSensoresCriticos() {
        List<Sensor> criticos = new ArrayList<>();

        for (Sensor sensor : sensores) {
            if (sensor instanceof SensorHumedadSuelo) {
                SensorHumedadSuelo sh = (SensorHumedadSuelo) sensor;
                if (sh.getHumedad() < 20.0) {
                    criticos.add(sensor);
                }
            } else if (sensor instanceof SensorTemperatura) {
                SensorTemperatura st = (SensorTemperatura) sensor;
                if (st.getCelsius() > 38.0) {
                    criticos.add(sensor);
                }
            }
        }
        return criticos;
    }
}