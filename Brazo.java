
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Brazo implements Runnable{
    
    private Contenedor primerContenedor;
    private Contenedor segundoContenedor;
    public int id;
    public int numeroPiezasAMontar;
    
    public Brazo(Contenedor contenedorA, Contenedor contenedorB, int id) throws IOException{


        this.id=id;

        if(this.id==0){
            this.primerContenedor = contenedorA;
            this.segundoContenedor = contenedorB;
        }
        else{
            this.primerContenedor = contenedorB;
            this.segundoContenedor = contenedorA;
        }




        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("Ingrese el id: ");
        // String ide = br.readLine(); 
        // this.id = Integer.parseInt(ide);
        System.out.println("Ingrese el total de piezas a montar por el brazo "+id+": ");
        String piezas = br.readLine(); 
        this.numeroPiezasAMontar = Integer.parseInt(piezas);
    }
    
    public void run() {
        int montajes=0;
        boolean bandera;


        for(int i=0; i < numeroPiezasAMontar; i++){
            this.primerContenedor.bandera[this.id] = true;
            int j=1000;
            //System.out.println("Hilo intentando entrar a seccion critica: " +this.id);
            if(this.id==0){
                this.primerContenedor.turno=1;
                j=1;
            }
            else{
                this.primerContenedor.turno=0;
                j=0;
            }
            while(this.primerContenedor.bandera[j] && this.primerContenedor.turno==j){
                //No hace nada
            }//El id de los brazo necesariamente es 0 y 1      
            //seccion critica            
            try{
                Thread.sleep( 400 );
            }catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }

            if(this.primerContenedor.numeroObjetos > 0){ //Evita que el brazo siga descargando cuando el contenedor esté vacío
                System.out.println("Brazo "+id+": ha descargado una pieza del contenedor "+this.primerContenedor.id);
                this.primerContenedor.descargarUnaPieza();
            }else{
                System.out.println("El contenedor "+this.primerContenedor.id+" esta vacio.");
                break;
                //System.exit(0);
            } 
            //Fin de la seccion critica     
            this.primerContenedor.bandera[this.id] = false;


             //

            this.segundoContenedor.bandera[this.id] = true;
            
            //System.out.println("Hilo intentando entrar a seccion critica: " +this.id);
            if(this.id==0){
                this.segundoContenedor.turno=1;
                j=1;
            }
            else{
                this.segundoContenedor.turno=0;
                j=0;
            }
            while(this.segundoContenedor.bandera[j] && this.segundoContenedor.turno==j){
                //No hace nada
            }//El id de los brazo necesariamente es 0 y 1      
            //seccion critica            
            try{
                Thread.sleep( 400 );
            }catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }

            if(this.segundoContenedor.numeroObjetos > 0){ //Evita que el brazo siga descargando cuando el contenedor esté vacío
                System.out.println("Brazo "+id+": ha descargado una pieza del contenedor "+this.segundoContenedor.id);
                this.segundoContenedor.descargarUnaPieza();

            }else{
                System.out.println("El contenedor "+this.segundoContenedor.id+" esta vacio.");
                break;
                //System.exit(0);
            }
            //Fin de la seccion critica   
            this.segundoContenedor.bandera[this.id] = false;     
            montajes++;
            System.out.println("Brazo "+this.id+": ha montado su producto "+montajes+" de "+this.numeroPiezasAMontar);
        }    
        if(this.primerContenedor.numeroObjetos > 0){
            //System.out.println("El contenedor aun tiene: "+contenedor.numeroObjetos+" piezas.");
        }
        System.out.println("Brazo "+id+" ha finalizado.");
    }
}