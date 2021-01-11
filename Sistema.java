
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sistema {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingresa el tamanio del contenedor: ");
        String piezasContenedor = br.readLine(); 
        int a = Integer.parseInt(piezasContenedor);

        Contenedor contenedor = new Contenedor(a);

        Runnable brazoA = new Brazo(contenedor, 0);
        Runnable brazoB = new Brazo(contenedor, 1);
        
        new Thread(brazoA).start();
        new Thread(brazoB).start();
    }
}
