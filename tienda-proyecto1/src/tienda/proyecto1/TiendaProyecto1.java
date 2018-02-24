/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.proyecto1;
import java.util.Scanner;
/**
 *
 * @author Alan Hernandez
 */
public class TiendaProyecto1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        
        /* Productos */
        String nombres [] = {"Tablet   ", "Laptop   ", "PC          ", "Smartphone"};
        
        /* precios y existencias */
        int productos [][] = {{5000,10},
                              {15000,10},
                              {17000,10},
                              {8000,10}};
       
        int ventas = 0;
        int opcion;        
        
                                         
        do {
            opcion = opcion_menu();        
        
            switch (opcion) {
                case 1:
                    listar_productos(nombres, productos);
                    break;                
                case 2:
                    ventas = vender_productos(nombres, productos) + ventas;
                    break;                
                case 3:
                    mostrar_total_de_ventas(ventas);
                    break;                

                }
        } while (opcion != 0);
        
        System.out.println("Gracias por sus compras!");
        
    }
    
    static int opcion_menu() {
        int opcion;
        
        do {
            System.out.println("Elige una opción");
            System.out.println("1.- Lista de productos");
            System.out.println("2.- Venta de productos");
            System.out.println("3.- Total de ventas");
            System.out.println("0.- Salir");
            
            opcion = sc.nextInt();
            
        } while (opcion < 0 || opcion >3);
        
        return opcion;
    }
    
    
    static void listar_productos(String nombres[], int productos[][]) {
        int i = 0;
               
        System.out.println("\tProducto\tPrecio\tCantidad");
        
        for (i = 0;i<productos.length;i++) {          
            System.out.println((i+1)+".\t"+nombres[i]+"\t"+productos[i][0]+"\t"+productos[i][1]);
        }
    }
    
    static int vender_productos(String nombres[], int productos[][]) {
        int i = 0;
        int opcion;
        int existencias;
        int comprados;
        int total = 0;
   
        do {
            System.out.println("Elija el producto que desea adquirir");
            listar_productos(nombres, productos);
            
            opcion = sc.nextInt();
            
        } while (opcion < 1 || opcion > productos.length);
        
        /* Esta variable esta simplemente para facilitar la lectura del codigo y no tener que estar poniendo productos[opcion-1][1] a cada vez 
           Nota: tiene que ser opcion-1 pues en la lista de opciones de productos el conteo empieza por 1 mientras que en el arreglo el indice
           empieza en cero
        */
        existencias = productos[opcion-1][1];
                
        if(existencias > 0) {
            do {
                System.out.println("Cantidad de productos que desea adquirir (1-"+existencias+")?");
                comprados = sc.nextInt();
            
            } while (comprados < 1 || comprados > existencias);
        
        
            System.out.println("Venta: "+nombres[opcion-1]);
            
            /* Calculo del total de esta venta */
            total = productos[opcion-1][0] * comprados;
            
            System.out.println("Total a pagar: "+total);

            productos[opcion-1][1] = existencias - comprados;
        } else {            
            System.out.println("Producto sin existencia");
        }
        
        espera_tecla();
        
        return total;

    }
    
    static void mostrar_total_de_ventas(int total) {
        System.out.println("Total de todas las ventas: "+total);
        espera_tecla();
    }
  
    static void espera_tecla() {
        
        System.out.println("Presione una tecla para continuar");
              
        sc.nextLine();
        sc.nextLine();
    }
    
}
