
public class Contenedor {

    private int id;

    public int numeroObjetos;
    public volatile boolean[] bandera;
    public volatile int turno;
    
    public Contenedor(int numeroObjetos, int id){
        this.numeroObjetos = numeroObjetos;
        this.id=id;

        this.bandera=new boolean[2];
        this.bandera[0]=false;
        this.bandera[1]=false;
    }

    public void descargarUnaPieza() { 
        this.numeroObjetos--;
    }

    
    public int getID(){
        return this.id;
    }
}
