import java.io.*;
import java.net.*;

public class Clientepedido {
    public static void main(String[] args) {
        String servidor = "localhost";
        int puerto = 5000;

        try (Socket socket = new Socket(servidor, puerto)) {
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

          
            String pedido = "Cliente: Jesus | Pedido: 12 alitas Acevichadas, 1 papas fritas, 2 Ink.Z";
            System.out.println(" Enviando pedido: " + pedido);
            salida.println(pedido);

          
            String respuesta = entrada.readLine();
            System.out.println(" Confirmación del restaurante: " + respuesta);

            entrada.close();
            salida.close();
            socket.close();
            System.out.println(" Pedido enviado con éxito y conexión cerrada.");

        } catch (IOException e) {
            System.err.println(" Error en el cliente: " + e.getMessage());
        }
    }
}

    }
}
