import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class ArchivoMaterial {

    public static void postIdsMateriales(ArrayList<String> idsMateriales){
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter( "src/materiales/" + "materiales"+ ".txt"));

            for(String id : idsMateriales){
                user.write(id + "\n");
            }
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static ArrayList<String> getIdsMateriales() {
        String response;
        ArrayList<String> materiales = new ArrayList<String>();
        try {
            Reader user = Files.newBufferedReader(Paths.get("src/materiales/materiales" + ".txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readUser = new BufferedReader(user);
            while((response = readUser.readLine()) != null){
                materiales.add(response);
            }
        } catch (IOException e) {
        }
        return materiales;
    }

    public static void postLibros(Libro libro) {
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter( "src/materiales/libros/" + libro.id + ".txt"));

            user.write("Id:" + libro.getId() +
                       "\nTitulo:" + libro.getTitulo() +
                       "\nEditorial:" + libro.getEditorial() +
                       "\nAutor:" + libro.getAutor() +
                       "\nCategoria:" + libro.getCategoria()
            );
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static Libro getLibros(String id) {
        String response;

        Libro libro = new Libro("", "", "","", "");
        try {
            Reader user = Files.newBufferedReader(Paths.get("src/materiales/libros/"+ id + ".txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readUser = new BufferedReader(user);
            while((response = readUser.readLine()) != null){
                String [] dato = response.split(":");
                if(dato[0].equals("Id")){
                    libro.setId(dato[1]);
                }
                if(dato[0].equals("Titulo")){
                    libro.setTitulo(dato[1]);
                }
                if(dato[0].equals("Editorial")){
                    libro.setEditorial(dato[1]);
                }
                if(dato[0].equals("Autor")){
                    libro.setAutor(dato[1]);
                }
                if(dato[0].equals("Categoria")){
                    libro.setCategoria(dato[1]);
                }
            }
        } catch (IOException e) {
        }

        return libro;
    }

    public static void postRevistas(Revista revista) {
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter( "src/materiales/revistas/" + revista.id + ".txt"));

            user.write("Id:" + revista.getId() +
                       "\nTitulo:" + revista.getTitulo() +
                       "\nEditorial:" + revista.getEditorial() +
                       "\nCategoria:" + revista.getCategoria()
            );
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static Revista getRevistas(String id) {
        String response;

        Revista revista = new Revista("", "", "", "");
        try {
            Reader user = Files.newBufferedReader(Paths.get("src/materiales/revistas/"+ id + ".txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readUser = new BufferedReader(user);
            while((response = readUser.readLine()) != null){
                String [] dato = response.split(":");
                if(dato[0].equals("Id")){
                    revista.setId(dato[1]);
                }
                if(dato[0].equals("Titulo")){
                    revista.setTitulo(dato[1]);
                }
                if(dato[0].equals("Editorial")){
                    revista.setEditorial(dato[1]);
                }
                if(dato[0].equals("Categoria")){
                    revista.setCategoria(dato[1]);
                }
            }
        } catch (IOException e) {
        }

        return revista;
    }
}