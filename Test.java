public class Test {
    public static void main(String[] args){


        Contenedor contenedor = new Contenedor();

        Brazo brazoA = new Brazo(contenedor, "A", 5);
        Brazo brazoB = new Brazo(contenedor, "B", 5);

        brazoA.start();
        brazoB.start();

        

    }
}
