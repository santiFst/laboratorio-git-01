public class Main {
    public static void main(String[] args) {
        // Crear la estación de monitoreo
        EstacionMonitoreo estacion = new EstacionMonitoreo();

        // Registrar sensores de la Orinoquía
        estacion.agregarSensor(new SensorHumedadSuelo(12, "Puerto López", true));
        estacion.agregarSensor(new SensorTemperatura(72, "Puerto Gaitán", true));

        // Procesar la telemetría en tiempo real
        estacion.procesarLecturas();
    }
}