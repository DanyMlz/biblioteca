
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArchivoDocente {

    public static void postDocente(Docente docente) {
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter(docente.getCi() + ".txt"));
            user.write("Ci:" + docente.getCi() +
                       "\nNombre:" + docente.getNombre() +
                       "\nEdad:" + docente.getEdad() +
                       "\nCargo:" + docente.getCargo() +
                       "\nCodigoDocente:" + docente.getCodDocente()
            );
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static Docente getDocente(int ci) {
        String response;
        Docente docente = new Docente("", 0, 0, "", "");
        try {
            Reader user = Files.newBufferedReader(Paths.get(ci + ".txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readUser = new BufferedReader(user);

            while((response = readUser.readLine()) != null){
                String [] dato = response.split(":");
                if(dato[0].equals("Nombre")){
                    docente.setNombre(dato[1]);
                }
                if(dato[0].equals("Ci")){
                    docente.setCi(Integer.parseInt(dato[1]));
                }
                if(dato[0].equals("Edad")){
                    docente.setEdad(Integer.parseInt(dato[1]));
                }
                if(dato[0].equals("Cargo")){
                    docente.setCargo(dato[1]);
                }
                if(dato[0].equals("CodigoDocente")){
                    docente.setCodDocente((dato[1]));
                }
            }
        } catch (IOException e) {
        }

        return docente;
    }
}