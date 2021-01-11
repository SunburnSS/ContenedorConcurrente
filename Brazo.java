
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Brazo implements Runnable{
    
    private Contenedor[] contenedores;
    private Contenedor contenedor;
    public int id;
    private int idContenedor;
    public int totalPiezas;
    
    public Brazo(Contenedor[] contenedores, int id) throws IOException{
        this.contenedores=contenedores;


        
        this.id=id;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // System.out.println("Ingrese el id: ");
        // String ide = br.readLine(); 
        // this.id = Integer.parseInt(ide);

        System.out.println("Ingrese el id del contenedor a tomar por el brazo "+id+": ");
        String idContenedor = br.readLine(); 
        this.contenedor = obtenerContenedor(contenedores, Integer.parseInt(idContenedor));

        System.out.println("Ingrese el total de piezas a tomar por el brazo "+id+": ");
        String piezas = br.readLine(); 
        this.totalPiezas = Integer.parseInt(piezas);

        
    }
    
    public void run() {
        int descargas=0;
        for(int i=0; i < totalPiezas; i++){
            contenedor.bandera[this.id] = true;
            int j=1000;
            //System.out.println("Hilo intentando entrar a seccion critica: " +this.id);
            if(this.id==0){
                contenedor.turno=1;
                j=1;
            }
            else{
                contenedor.turno=0;
                j=0;
            }
            while(contenedor.bandera[j] && contenedor.turno==j){
                //No hace nada
            }//El id de los brazo necesariamente es 0 y 1      
            //seccion critica            
            try{
                Thread.sleep( 400 );
            }catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }

            if(contenedor.numeroObjetos > 0){ //Evita que el brazo siga descargando cuando el contenedor esté vacío
                contenedor.descargarUnaPieza();
                descargas++;
                System.out.println("Brazo "+id + " descarga pieza numero "+descargas + ". Piezas restantes "+contenedor.numeroObjetos);
            }else{
                
                System.out.println("El contenedor esta vacio.");
                i=totalPiezas;
                //System.exit(0);
            }   
            contenedor.bandera[this.id] = false;
            //Fin de la sección critica
        }    
        if(contenedor.numeroObjetos > 0){
            System.out.println("El contenedor aun tiene: "+contenedor.numeroObjetos+" piezas.");
        }
        System.out.println("Brazo "+id+" ha finalizado.");
    }

    private Contenedor obtenerContenedor(Contenedor[] contenedores, int id){
        for(Contenedor contenedor : contenedores){
            if(contenedor.getID() == id){
                return contenedor;
            }
        }
        return null;
    }
}