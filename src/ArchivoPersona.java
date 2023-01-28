import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArchivoPersona {

    public static void postListaPersonas(ArrayList<String> ListaPersona) {
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter("listaPersonas.txt"));
            for(String ci : ListaPersona){
                user.write(ci + "\n");
            }
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static ArrayList<String> getListaPersonas() {
        String response;
        ArrayList<String> listaPersonas = new ArrayList<String>();
        try {
            Reader lista = Files.newBufferedReader(Paths.get("listaPersonas.txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readLista = new BufferedReader(lista);

            while((response = readLista.readLine()) != null){
                listaPersonas.add(response);
            }
        } catch (IOException e) {
        }

        return listaPersonas;
    }
}