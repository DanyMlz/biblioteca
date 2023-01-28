import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Prestamo {
    private String codigoPrestamo;
    private String idMaterial;
    private String categoria;
    private String codPersona;
    private Scanner scanner;

    public Prestamo(){
        scanner = new Scanner(System.in);
    }


    public void prestarMaterial(){
        System.out.println("Ingrese su codigo persona");
        this.codPersona = scanner.nextLine();
        System.out.println("Ingrese la categoria del material");
        this.categoria = scanner.nextLine();
        System.out.println("Ingrese el nombre del material");
        String nombreLibroMaterial = scanner.nextLine();
        this.codigoPrestamo = generarId();
        String idMaterial = "";
        this.idMaterial = buscarIdMaterial(categoria, nombreLibroMaterial);
        ArchivoPrestamo.postPrestamo(codigoPrestamo, idMaterial, categoria, codPersona);
    }

    private String buscarIdMaterial(String categoria, String nombreMaterial){
        String idMaterial = "";
        ArrayList<String> idsMaterial = ArchivoMaterial.getIdsMateriales();
        for(String id : idsMaterial){
            Libro libro = ArchivoMaterial.getLibros(id);
            if(libro.getCategoria().equals(categoria) && libro.getTitulo().equals(nombreMaterial)){
                idMaterial = libro.getId();
            }
            Revista revista = ArchivoMaterial.getRevistas(id);
            if(revista.getCategoria().equals(categoria) && revista.getTitulo().equals(nombreMaterial)){
                idMaterial = revista.getId();
            }
        }

        return idMaterial;
    }






    @Override
    public String toString(){
        return "codido de Prestamo: " + codigoPrestamo + "\nCodigo de persona: " + codPersona + "Id del material: " + idMaterial;
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
}
