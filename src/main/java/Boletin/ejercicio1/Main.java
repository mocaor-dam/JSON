package Boletin.ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    static void main(String[] args) {
        Videojuego videojuego = new Videojuego("Elden Ring", "From Software", 2022);

        Path path = Path.of("src/main/java/Boletin/ejercicio1/videojuego.json");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try (BufferedReader r = Files.newBufferedReader(path)) {

            String json = gson.toJson(videojuego);
            Files.writeString(path, json);
            Videojuego videojuego1 = gson.fromJson(r, Videojuego.class);
            System.out.println(videojuego1.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
