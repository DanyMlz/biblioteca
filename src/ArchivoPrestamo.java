import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArchivoPrestamo {

    public static void postPrestamo(String idMaterial) {
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter("listaMaterialesPrestados" + ".txt"));
            user.write(idMaterial + "\n");
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static ArrayList<String> getPrestamo() {
        String response;

        ArrayList<String> listaCodigoPrestamo = new ArrayList<String>();
        try {
            Reader user = Files.newBufferedReader(Paths.get("listaMaterialesPrestados" + ".txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readLista = new BufferedReader(user);
            while((response = readLista.readLine()) != null){
                listaCodigoPrestamo.add(response);
            }

        } catch (IOException e) {
        }

        return listaCodigoPrestamo;
    }


}