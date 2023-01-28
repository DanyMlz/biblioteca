import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArchivoPrestamo {

    public static void postPrestamo(String codigoPrestamo,String idMaterial,String categoria,String codPersona) {
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter(codigoPrestamo + ".txt"));
            user.write(codigoPrestamo + "\n");
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static ArrayList<String> getPrestamo(String codigoPrestamo) {
        String response;

        ArrayList<String> listaCodigoPrestamo = new ArrayList<String>();
        try {
            Reader user = Files.newBufferedReader(Paths.get(codigoPrestamo + ".txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readLista = new BufferedReader(user);
            while((response = readLista.readLine()) != null){
                listaCodigoPrestamo.add(response);
            }

        } catch (IOException e) {
        }

        return listaCodigoPrestamo;
    }


}