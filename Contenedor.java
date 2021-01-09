
public class Contenedor {

    public int numeroObjetos;
    public volatile boolean[] bandera;
    public volatile int turno;
    
    public Contenedor(int numeroObjetos){
        this.numeroObjetos = numeroObjetos;
        this.bandera=new boolean[2];
        this.bandera[0]=false;
        this.bandera[1]=false;
    }

    public void descargarUnaPieza() { 


        this.numeroObjetos--;

    }


}
