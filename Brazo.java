public class Brazo extends Thread{

    private Contenedor contenedor;
    private String id;
    private int numeroDeDescargas;

    public Brazo(Contenedor contenedor, String id, int numeroDeDescargas){
        this.contenedor=contenedor;
        this.id=id;
        this.numeroDeDescargas=numeroDeDescargas;
    }

    public void run() {
        //Todo el codigo concurrente aquí
        for(int i=1; i<=this.numeroDeDescargas && contenedor.descargar(this) ; i++){
            System.out.println("El brazo "+this.id+" ha descargado "+ i +"/"+this.numeroDeDescargas);
        }
        
    }

    public String getID(){
        return this.id;
    }

    public int getNumeroDeDescargas(){
        return this.numeroDeDescargas;
    }

}
