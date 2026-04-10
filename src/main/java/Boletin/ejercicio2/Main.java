package Boletin.ejercicio2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("Juan", "2025", 5.0));
        estudiantes.add(new Estudiante("Mateo", "2024", 7.0));
        estudiantes.add(new Estudiante("Lucas", "2026", 9.0));


        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        Path path = Path.of("src/main/java/Boletin/ejercicio2/estudiantes.json");

        if (!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        try (BufferedReader r = Files.newBufferedReader(path)){

            String json = gson.toJson(estudiantes);
            Files.writeString(path, json);

            Type tipoLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();

            List<Estudiante> estudianteList = gson.fromJson(r, tipoLista);


            System.out.println(estudianteList);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
