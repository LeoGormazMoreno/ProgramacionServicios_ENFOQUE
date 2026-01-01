/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programacionservicios_enfoque;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Leo
 */
public class Concesionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Semaphore semaforo = new Semaphore(4);
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente("Antonio"));
        listaClientes.add(new Cliente("Rocio"));
        listaClientes.add(new Cliente("Manuel"));
        listaClientes.add(new Cliente("Alejandro"));
        listaClientes.add(new Cliente("Estrella"));
        listaClientes.add(new Cliente("Irene"));
        listaClientes.add(new Cliente("Fernando"));
        listaClientes.add(new Cliente("Francisco"));
        listaClientes.add(new Cliente("Maria"));
        
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Vehiculo("Seat Leon"));
        listaVehiculos.add(new Vehiculo("Ford Focus"));
        listaVehiculos.add(new Vehiculo("Mazda CX-5"));
        listaVehiculos.add(new Vehiculo("BMW S3"));
        
        for (int i = 0; i < listaClientes.size(); i++) {
            final String clientes = listaClientes.get(i).getNombre();
            final String coches = listaVehiculos.get(i % listaVehiculos.size()).getModeloVehiculo();
            
          new Thread(new Runnable() {
            @Override
            public void run() {
            try {
                semaforo.acquire();
                System.out.println(clientes + " probando el vehiculo " + coches);
                Thread.sleep(2000);
                System.out.println(clientes + " termino de probar el vehiculo " + coches);
                semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        }).start();
        }
    }
       
    }
    

