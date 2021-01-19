
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sistema {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingresa el tamanio de los contenedores: ");
        String piezasContenedor = br.readLine(); 
        int a = Integer.parseInt(piezasContenedor);

        Contenedor contenedorA = new Contenedor(a, "A");
        Contenedor contenedorB = new Contenedor(a, "B");

        Runnable brazoA = new Brazo(contenedorA, contenedorB, 0);
        Runnable brazoB = new Brazo(contenedorA, contenedorB, 1);
        
        new Thread(brazoA).start();
        new Thread(brazoB).start();
    }
}
