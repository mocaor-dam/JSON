package ejercicioMatriculas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    static void main(String[] args) {
        Path path  = Path.of("src/main/java/ejercicioMatriculas/Matriculas.txt");
        Path path2 = Path.of("src/main/java/ejercicioMatriculas/MatriculasGuardadas.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Pattern p = Pattern.compile("^(?<numeros>\\d{4})\\s(?<letras>[B-Z&&[^EIOU]]{3})$");

        try(Stream<String> lineas = Files.lines(path)) {
            List<Matricula> matriculas = lineas.map(p::matcher)
                   .filter(Matcher::find)
                   .map(m -> {
                       String numeros = m.group("numeros");
                       String letras = m.group("letras");
                        return new Matricula(numeros,letras);
                   }).toList();

            String json = gson.toJson(matriculas);

            Files.writeString(path2, json, StandardOpenOption.CREATE);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
