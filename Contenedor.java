
public class Contenedor {

    public String id;
    public int numeroObjetos;
    public volatile boolean[] bandera;
    public volatile int turno;
    
    public Contenedor(int numeroObjetos, String id){
        this.id = id;
        this.numeroObjetos = numeroObjetos;
        this.bandera = new boolean[2];
        this.bandera[0] = false;
        this.bandera[1] = false;
    }

    public void descargarUnaPieza() { 
        this.numeroObjetos--;
    }
}
