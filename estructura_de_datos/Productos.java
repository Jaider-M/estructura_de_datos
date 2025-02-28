import java.util.Comparator;

public class Productos implements Comparable<Productos>{
    private String nombre;
    private double precio;
    private int codigo, cantidad;

    // Constructor
    public Productos (int codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Metodos Getters
    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
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

class CompararPorCantidad implements Comparator<Productos> {
    @Override
    public int compare(Productos p1, Productos p2) {
        if(p1.getCantidad() < p2.getCantidad()) {
            return 1;
        } else {
            if(p1.getCantidad() > p2.getCantidad()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

class CompararPorCodigo implements Comparator<Productos> {
    @Override
    public int compare(Productos p1, Productos p2) {
        if(p1.getCodigo() < p2.getCodigo()) {
            return 1;
        } else {
            if(p1.getCodigo() > p2.getCodigo()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

