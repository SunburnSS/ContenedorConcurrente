
public class Contenedor {

    public int numeroObjetos;
    public boolean Bandera = true;
    public boolean[] banderas;
    public int turno;
    
    public Contenedor(int numeroObjetos){
        this.numeroObjetos = numeroObjetos;
        this.banderas=new boolean[2];
        this.banderas[0]=false;
        this.banderas[1]=false;
        this.turno=0;
    }

    public void descargarUnaPieza() throws InterruptedException{ 
        if( numeroObjetos == 0){
            System.out.println("Se ha descargado por completo el contenedor.");
            System.exit(0);
        }else{
            numeroObjetos--;
        }
        Thread.sleep(200);
        
    }
}
