import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Material {
    private ArrayList<Libro> listaLibros;
    private ArrayList<Revista> listaRevista;
    protected String titulo;
    protected String editorial;
    protected String id;
    private Scanner scanner;
    protected String categoria;
    public Material(){
        scanner = new Scanner(System.in);
        listaLibros = new ArrayList<Libro>();
        scanner = new Scanner(System.in);
        listaRevista = new ArrayList<Revista>();
    }
    public void menu(){
        System.out.println("Bienvenido" );
        System.out.println("[1] Añadir material");
        System.out.println("[2] Eliminar material ");
        System.out.println("[3] mostrar Lista de material");
        System.out.println("[4] prestar material");
        System.out.println("[5] mostrar materiales prestamos");
        System.out.println("[0] salir");
    }
    public void iniciar(){
        int opcion;
        do{
            menu();
            opcion = scanner.nextInt();

            switch(opcion){
                case 0:
                    Biblioteca biblioteca = new Biblioteca("UMSS", "Jordan y Oquendo");
                    biblioteca.iniciar();
                break;

                case 1:
                    anadirMateriales();
                break;

                case 2:
                    scanner.nextLine();
                    System.out.println("tipo de categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.println("ingrese el id: ");
                    String id = scanner.nextLine();
                    eliminarMaterial(categoria, id);
                break;

                case 3:
                    mostrarMateriales();
                break;
                case 4:
                    Prestamo prestamo = new Prestamo();
                    prestamo.prestarMaterial();
                break;

                case 5:
                    Prestamo prestamo2 = new Prestamo();
                    prestamo2.materialesPrestados();
                break;

                default:
            }

        }while(opcion != 0);
    }

    private void anadirMateriales(){
        String id;
        System.out.println("[1] Libros\n[2] Revistas");
        int opcion = scanner.nextInt();
        if(opcion == 1){
            scanner.nextLine();
            System.out.println("Titulo: ");
            String titulo = scanner.nextLine();
            System.out.println("Editorial: ");
            String editorial = scanner.nextLine();
            System.out.println("Autor: ");
            String autor = scanner.nextLine();
            id = generarId();
            Libro libro = new Libro(id, titulo, editorial, autor, "libros");
            ArchivoMaterial.postLibros(libro);
            ArrayList<String> idsMateriales = ArchivoMaterial.getIdsMateriales();
            idsMateriales.add(libro.getId());
            ArchivoMaterial.postIdsMateriales(idsMateriales);
        }

        if(opcion == 2){
            scanner.nextLine();
            System.out.println("Titulo: ");
            String titulo = scanner.nextLine();
            System.out.println("Editorial: ");
            String editorial = scanner.nextLine();
            id = generarId();
            Revista revista = new Revista(id, titulo, editorial, "revistas");
            ArchivoMaterial.postRevistas(revista);
            ArrayList<String> idsMateriales = ArchivoMaterial.getIdsMateriales();
            idsMateriales.add(revista.getId());
            ArchivoMaterial.postIdsMateriales(idsMateriales);
        }

    }

    private void eliminarMaterial(String categoria, String id){
        if(categoria.equals("libros")){
            String fileNombre = "src/materiales/libros/" + id + ".txt";
            Path path = Paths.get(fileNombre);
            try{
                ArrayList<String> newIdsLibros =ArchivoMaterial.getIdsMateriales();
                for(String idLibro : ArchivoMaterial.getIdsMateriales()){
                    if(idLibro.equals(id)){
                        newIdsLibros.remove(idLibro);
                        ArchivoMaterial.postIdsMateriales(newIdsLibros);
                    }
                }
                Files.delete(path);
            }catch(IOException e){
            }
        }
        if(categoria.equals("revistas")){
            String fileNombre = "src/materiales/revistas/" + id + ".txt";
            Path path = Paths.get(fileNombre);
            try{
                ArrayList<String> newIdsLibros =ArchivoMaterial.getIdsMateriales();
                for(String idLibro : ArchivoMaterial.getIdsMateriales()){
                    if(idLibro.equals(id)){
                        newIdsLibros.remove(idLibro);
                        ArchivoMaterial.postIdsMateriales(newIdsLibros);
                    }
                }
                Files.delete(path);
            }catch(IOException e){
            }
        }
    }

    private void mostrarMateriales(){
        ArrayList<String> idsMateriales = ArchivoMaterial.getIdsMateriales();
        for(String id : idsMateriales){
            Revista revista = ArchivoMaterial.getRevistas(id);
            Libro libro = ArchivoMaterial.getLibros(id);
            if(libro.getCategoria().equals("libros")){
                System.out.println(libro);
            }else if(revista.getCategoria().equals("revistas")){
                System.out.println(revista);
            }
        }
    }


    private  String generarId() {
        String hash = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena = "";
        for (int x = 0; x < 5; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, hash.length() - 1);
            char caracterAleatorio = hash.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }
    private int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
    protected String getId(){
        return this.id;
    }
    protected String getTitulo(){
        return this.titulo;
    }
    protected String getEditorial(){
        return this.editorial;
    }
    protected void setId(String id){
        this.id = id;
    }
    protected void setTitulo(String titulo){
        this.titulo = titulo;
    }
    protected void setEditorial(String editorial){
        this.editorial = editorial;
    }
    protected String getCategoria(){
        return this.categoria;
    }
    protected void setCategoria(String categoria){
        this.categoria = categoria;
    }
}
