package ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {


        Cliente cliente = new Cliente("Pepe", "234325Q", 667874576);
        Cliente cliente2 = new Cliente("Juana", "12361791X", 66534566);
        Cliente cliente3 = new Cliente("Mateo", "234325Q", 123490812);
        Cliente cliente4 = new Cliente("Lucas", "345631234I", 12316567);
        Cliente cliente5 = new Cliente("Marcos", "34353425Q", 88899234);
        Cliente cliente6 = new Cliente("Juan", "2346525Q", 23444442);

        List<Cliente> clientes = List.of(cliente, cliente2, cliente3, cliente4, cliente5, cliente6);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        String json = gson.toJson(clientes);

        Path ruta = Path.of("src/main/java/ejercicio1/salidas.json");

        try {
            Files.writeString(ruta, json, StandardOpenOption.CREATE);
            System.out.println("Realizado con exito");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
