import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArchivoEstudiante {

    public static void postEstudiante(Estudiante estudiante) {
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter(estudiante.getCi() + ".txt"));
            user.write("Ci:" + estudiante.getCi() +
                       "\nNombre:" + estudiante.getNombre() +
                       "\nEdad:" + estudiante.getEdad() +
                       "\nCargo:" + estudiante.getCargo() +
                       "\nCodigoSys:" + estudiante.getCodSys()
            );
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static Estudiante getEstudiante(int ci) {
        String response;

        Estudiante estudiante = new Estudiante("", 0, 0, "", "");
        try {
            Reader user = Files.newBufferedReader(Paths.get(ci + ".txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readUser = new BufferedReader(user);
            while((response = readUser.readLine()) != null){
                String [] dato = response.split(":");
                if(dato[0].equals("Nombre")){
                    estudiante.setNombre(dato[1]);
                }
                if(dato[0].equals("Ci")){
                    estudiante.setCi(Integer.parseInt(dato[1]));
                }
                if(dato[0].equals("Edad")){
                    estudiante.setEdad(Integer.parseInt(dato[1]));
                }
                if(dato[0].equals("Cargo")){
                    estudiante.setCargo(dato[1]);
                }
                if(dato[0].equals("CodigoSys")){
                    estudiante.setCodSys((dato[1]));
                }
            }
        } catch (IOException e) {
        }

        return estudiante;
    }
}