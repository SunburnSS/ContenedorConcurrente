
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Brazo extends Thread{
    
    private Contenedor contenedor;
    public int id;
    public int totalPiezas;
    
    public Brazo(Contenedor contenedor) throws IOException{
        this.contenedor = contenedor;
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el id: ");
        String ide = br.readLine(); 
        this.id = Integer.parseInt(ide);
        //System.out.println("Ingrese el total de piezas a tomar por el brazo "+id+": ");
        //String piezas = br.readLine(); 
        //this.totalPiezas = Integer.parseInt(piezas);
    }
    
    public void run() {
        int descargas = 0; // Total de descargas que lleva el brazo actual
        while( descargas <= totalPiezas ){ 
            try {
                //Inicio exclusión mutua
                int j; 
                do{
                    contenedor.banderas[this.id]=true;
                   
                    if(this.id==0){
                        contenedor.turno=1;
                        j=1;
                    }
                    else{
                        contenedor.turno=0;
                        j=0;
                    }

                    while(contenedor.banderas[j] && contenedor.turno==j){//El id de los brazo necesariamente es 0 y 1

                        contenedor.descargarUnaPieza();

                        descargas++;
            
                        System.out.println("Brazo "+id+" descarga pieza "+descargas+" Faltan: "+contenedor.numeroObjetos);
                    }

                    contenedor.banderas[this.id]=false;
                    
                   
                }while(contenedor.numeroObjetos != 0);
                //contenedor.Bandera = true;
                //Thread.sleep(500);
                //Final exclusión mutua
            } catch (InterruptedException ex) {
                System.out.println("Falló al descargar el contenedor.");
            }
            
        }
        if(contenedor.numeroObjetos != 0){
            System.out.println("El contenedor aún tiene: "+contenedor.numeroObjetos+" piezas.");
        }
        System.out.println("Brazo "+id+" ha finaliado.");
    }
}
