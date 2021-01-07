
import java.io.IOException;

public class Sistema {

    public static void main(String[] args) throws IOException, InterruptedException {
        int a = 50;
	System.out.println("Holi, prueba de Github");
        Contenedor contenedor = new Contenedor(a);

        Brazo brazoA = new Brazo(contenedor);
        Brazo brazoB = new Brazo(contenedor);
        
        brazoA.start();
        brazoB.start();
    }

}
