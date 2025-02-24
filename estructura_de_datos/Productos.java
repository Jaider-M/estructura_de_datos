public class Productos implements Comparable<Productos>{
    private String nombre;
    private double precio;

    // Constructor
    public Productos (String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Metodos Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Sobrescribimos el metodo compareTo para comparar por precio
    @Override
    public int compareTo(Productos p) {
        if(this.getPrecio() < p.getPrecio()) {
            return 1;
        } else {
            if(this.getPrecio() > p.getPrecio()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}