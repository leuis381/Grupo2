import java.io.*;
import java.net.*;

public class Servidorpedido {
    public static void main(String[] args) {
        int puerto = 5000;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println(" [Legua Wings] Servidor de recepción de pedidos iniciado en el puerto " + puerto);

            Socket socket = servidor.accept();
            System.out.println("Nuevo cliente conectado desde: " + socket.getInetAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String pedido = entrada.readLine();
            System.out.println(" Pedido recibido: " + pedido);

          
            String confirmacion = "Pedido confirmado. En preparación: " + pedido;
            salida.println(confirmacion);

            entrada.close();
            salida.close();
            socket.close();
            System.out.println("Conexión finalizada con el cliente.");

        } catch (IOException e) {
            System.err.println(" Error en el servidor: " + e.getMessage());
        }
    }
}
