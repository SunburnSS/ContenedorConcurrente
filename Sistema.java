
import java.io.IOException;

public class Sistema {

    public static void main(String[] args) throws IOException, InterruptedException {
        int a = 50;
        Contenedor contenedor = new Contenedor(a);

        Brazo brazoA = new Brazo(contenedor, 0);
        Brazo brazoB = new Brazo(contenedor, 1);
        
        brazoA.start();
        brazoB.start();
    }

}
