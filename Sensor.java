public abstract class Sensor{
    private int id;
    private String ubicacion;
    private boolean activo;
    

    public Sensor(int id, String ubicacion, boolean activo){
        this.id = id;
        this.ubicacion = ubicacion;
        this.activo = activo;
    }

    public abstract double tomarLectura();
    public abstract String evaluarEstado();
    


    //GETTERS
    public int getId() {
        return id;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public boolean isActivo() {
        return activo;
    }
    //SETTERS
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}