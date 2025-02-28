import java.util.Scanner;

public class CompararProductos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializar objetos tipo producto
        Productos producto1 = new Productos(1829, "Televisor", 2500000, 7);
        Productos producto2 = new Productos(1523, "Bicicleta", 1500000, 10);
        Productos producto3 = new Productos(2982, "Celular", 3800000, 19);
        Productos producto4 = new Productos(4028, "Laptop", 4300000, 20);
        Productos producto5 = new Productos(2192, "Camara", 3100000, 16);
        Productos producto6 = new Productos(9823, "Escritorio", 680000, 12);
        Productos producto7 = new Productos(8763, "Silla de Escritorio", 370000, 20);
        Productos producto8 = new Productos(6371, "Equipo de sonido", 1450000, 9);
        Productos producto9 = new Productos(7252, "Auriculares", 300000, 18);
        Productos producto10 = new Productos(9238, "Mouse", 120000, 14);

        // Craer array con todos los productos
        Productos[] misProductos = {
            producto1, producto2, producto3, producto4, producto5, 
            producto6, producto7, producto8, producto9, producto10
        };

        // Crear una variable producto para guardar el retorno del metodo compararProducto
        Productos[] ordenado = compararProductos(misProductos);

        // Crear una variable producto para guardar el retorno del metodo compararProducto2
        Productos[] ordenado2 = compararProductos2(misProductos);

        // Crear una variable producto para guardar el retorno del metodo compararProducto3
        Productos[] ordenado3 = compararProductos3(misProductos);

        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("\nDigite una opcion: ");
            System.out.println("1. Ordenar lista por precio de mayor a menor " 
            + "\n2. Ordenar lista por cantidad de mayor a menor" 
            + "\n3. Buscar producto por numero de codigo"
            + "\n4. Salir");
            opcion = sc.nextInt();

            System.out.println();
            switch(opcion) {
                case 1: 
                    System.out.println("Ordenamiento burbuja por precio de mayor a menor\n");
                    // Bucle for para imprimir la informacion del array ordenado por precio de mayor precio a menor precio
                    for(int i = 0; i < ordenado.length; i++) {
                        System.out.println("Codigo: " +  ordenado[i].getCodigo() + ", Producto: " + ordenado[i].getNombre() 
                        + ", Precio: " + ordenado[i].getPrecio() + ", Cantidad: " + ordenado[i].getCantidad());
                    }
                    break;
    
                case 2:
                    System.out.println();
                    System.out.println("Ordenamiento por insercion por cantidad de mayor a menor\n");
                    // Bucle for para imprimir la informacion del array ordenado por cantidad de mayor precio a menor precio
                    for(int i = 0; i < ordenado2.length; i++) {
                        System.out.println("Codigo: " +  ordenado2[i].getCodigo() + ", Producto: " + ordenado2[i].getNombre() 
                        + ", Precio: " + ordenado2[i].getPrecio() + ", Cantidad: " + ordenado2[i].getCantidad());
                    }
                    break;
    
                case 3: 
                    System.out.println();
                    System.out.println("Ordenamiento por insercion por codigo de mayor a menor\n");
                    // Bucle for para imprimir la informacion del array ordenado por codigo de mayor precio a menor precio
                    for(int i = 0; i < ordenado3.length; i++) {
                        System.out.println("Codigo: " +  ordenado3[i].getCodigo() + ", Producto: " + ordenado3[i].getNombre() 
                        + ", Precio: " + ordenado3[i].getPrecio() + ", Cantidad: " + ordenado3[i].getCantidad());
                    }

                    // Busqueda binaria
                    System.out.println("\nDigite el codigo del producto: ");
                    int codigoP = sc.nextInt();
    
                    int indice = busquedaBinaria(ordenado3, codigoP);
                    if (indice == -1) {
                        System.out.println("El producto no se encuentra en la lista");
                    } else {
                        System.out.println("El codigo: " + codigoP + " pertenece al producto: " + ordenado3[indice].getNombre() 
                        + ", con un precio de: " + ordenado3[indice].getPrecio() + " por unidad, y una cantidad de: " 
                        + ordenado3[indice].getCantidad() + " productos");
                    }
                    break;
    
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("opcion incorrecta");
            }
        }

        sc.close();
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

            while(j >= 0 && new CompararPorCantidad().compare(misProductos[j], temp) > 0) {
                misProductos[j+1] = misProductos[j];
                j--;
            }

            misProductos[j+1] = temp;
        }

        return misProductos;
    }

    // --------------------------------- ALGORITMO INSERTION SORT --------------------------------------------------------//

    // Metodo para comparar y organizar los productos por algoritmo Insertion Sort
    public static Productos[] compararProductos3(Productos[] p) {
        int tamanio = p.length;
        Productos misProductos[] = p.clone();

        // Ordenar productos 
        for(int i = 1; i < tamanio; i++) {
            Productos temp = misProductos[i];
            int j = i - 1;

            while(j >= 0 && new CompararPorCodigo().compare(misProductos[j], temp) > 0) {
                misProductos[j+1] = misProductos[j];
                j--;
            }

            misProductos[j+1] = temp;
        }

        return misProductos;
    }

    // --------------------------------- BUSQUEDA BINARIA --------------------------------------------------------//
    public static int busquedaBinaria(Productos[] productos, int codigo) {
        int limiteInferior = 0;
        int limiteSuperior = productos.length - 1;
        int indice;

        while (limiteInferior <= limiteSuperior) {
            indice = (limiteInferior + limiteSuperior)/2;

            if(productos[indice].getCodigo() == codigo) {
                return indice;
            } else if(codigo > productos[indice].getCodigo()) {
                limiteSuperior = indice - 1;
            } 
            else {
                limiteInferior = indice + 1; 
            }
        }

        return -1;
    }
}
