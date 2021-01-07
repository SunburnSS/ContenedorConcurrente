public class Contenedor {
    private int numeroObjetos;

    public Contenedor(){
        this.numeroObjetos=5;
    }

    public Contenedor(int numeroObjetos){
        this.numeroObjetos=numeroObjetos;
    }

    //Region critica
    //Implementación de la exclusión mutua
    public synchronized boolean descargar(Brazo brazo){
        if(this.numeroObjetos>0){

            try{
                Thread.sleep( (long) (Math.random()*3000));
            }catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }
            
            System.out.println("El brazo "+brazo.getID() + " descarga la pieza "+ this.numeroObjetos + " faltan " + (this.numeroObjetos=this.numeroObjetos-1) + " por descargar");


            

            return true;
        }else{
            return false;
        }

    }
}
