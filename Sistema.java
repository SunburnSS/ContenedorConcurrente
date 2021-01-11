
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sistema {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingresa el numero de contenedores deseados: ");
        String entrada = br.readLine(); 
        int numeroContenedores = Integer.parseInt(entrada);



        Contenedor[] contenedores = new Contenedor[numeroContenedores];

        for(int i=0; i<numeroContenedores; i++){
            System.out.println("Ingresa el tamanio para el contenedor"+ i +": ");
            entrada = br.readLine(); 
            int numeroObjetos = Integer.parseInt(entrada);
            contenedores[i] = new Contenedor(numeroObjetos, i);
        }




        Runnable brazoA = new Brazo(contenedores, 0);
        Runnable brazoB = new Brazo(contenedores, 1);
        
        new Thread(brazoA).start();
        new Thread(brazoB).start();
    }

}
