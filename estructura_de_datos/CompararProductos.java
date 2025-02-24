public class CompararProductos {
    public static void main(String[] args) {

        // Inicializar objetos tipo producto
        Productos producto1 = new Productos("Televisor", 2500000);
        Productos producto2 = new Productos("Bicicleta", 1500000);
        Productos producto3 = new Productos("Celular", 3800000);
        Productos producto4 = new Productos("Laptop", 4300000);
        Productos producto5 = new Productos("Camara", 3100000);
        Productos producto6 = new Productos("Escritorio", 680000);
        Productos producto7 = new Productos("Silla de Escritorio", 370000);
        Productos producto8 = new Productos("Equipo de sonido", 1450000);
        Productos producto9 = new Productos("Auriculares", 300000);
        Productos producto10 = new Productos("Mouse", 120000);

        // Craer array con todos los productos
        Productos[] misProductos = {
            producto1, producto2, producto3, producto4, producto5, 
            producto6, producto7, producto8, producto9, producto10
        };

        // Crear una variable producto para guardar el retorno del metodo compararProducto
        Productos[] ordenado = compararProductos(misProductos);

        // Bucle for para imprimir la informacion del array ordenado por precio de mayor precio a menor precio
        for(int i = 0; i < ordenado.length; i++) {
            System.out.println((i+1) + ".Producto: " + ordenado[i].getNombre() + ", Precio: " + ordenado[i].getPrecio());
        }

        // Crear una variable producto para guardar el retorno del metodo compararProducto2
        Productos[] ordenado2 = compararProductos2(misProductos);

        // Bucle for para imprimir la informacion del array ordenado por precio de mayor precio a menor precio
        for(int i = 0; i < ordenado2.length; i++) {
            System.out.println((i+1) + ".Producto: " + ordenado2[i].getNombre() + ", Precio: " + ordenado2[i].getPrecio());
        }
    } 
    

    // --------------------------------- ALGORITMO BURBUJA --------------------------------------------------------//

    // Metodo para comparar y organizar los productos por algoritmo burbuja
    public static Productos[] compararProductos(Productos[] p) {
        int tamanio = p.length;
        Productos misProductos[] = p.clone();

        // Ordenar productos 
        for(int i = 0; i < tamanio-1; i++) {
            for(int j = 0; j < tamanio-1-i; j++) {
                if(misProductos[j].compareTo(misProductos[j+1]) > 0) {
                    Productos temp = misProductos[j];
                    misProductos[j] = misProductos[j+1];
                    misProductos[j+1] = temp;
                }
            }
        }

        return misProductos;
    }

    // --------------------------------- ALGORITMO INSERTION SORT --------------------------------------------------------//

    // Metodo para comparar y organizar los productos por algoritmo Insertion Sort
    public static Productos[] compararProductos2(Productos[] p) {
        int tamanio = p.length;
        Productos misProductos[] = p.clone();

        // Ordenar productos 
        for(int i = 1; i < tamanio; i++) {
            Productos temp = misProductos[i];
            int j = i - 1;

            while(j >= 0 && misProductos[j].compareTo(temp) > 0) {
                misProductos[j+1] = misProductos[j];
                j--;
            }

            misProductos[j+1] = temp;
        }

        return misProductos;
    }
}
