public class Test {
    public static void main(String[] args){


        Contenedor contenedor = new Contenedor();

        Brazo brazoA = new Brazo(contenedor);
        Brazo brazoB = new Brazo(contenedor);

        brazoA.start();
        brazoB.start();

    }
}
