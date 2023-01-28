    import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {
    private String nombre;
    private String direccion;
    private Scanner scanner;
    private ArrayList<Prestamo> materialesPrestados;
    private ArrayList<String> listaPersonas;

    public Biblioteca(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        scanner = new Scanner(System.in);
        materialesPrestados = new ArrayList<Prestamo>();
    }

    public void menu(){
        System.out.println("Bienvenidos a la biblioteca " + nombre );
        System.out.println("[1] registrar personas");
        System.out.println("[2] eliminar persona");
        System.out.println("[3] editar persona");
        System.out.println("[4] mostrar personas");
        System.out.println("[5] materiales");
        System.out.println("[o] salir");
    }

    public void iniciar(){
        int opcion;
        do{
            menu();
            opcion = scanner.nextInt();
            int ci;

            switch(opcion){
                case 0:
                    System.out.println("El sistema se esta cerrando");
                break;

                case 1:
                    registrarPersona();
                break;

                case 2:
                    System.out.println("Ingresa el ci: ");
                    ci = scanner.nextInt();
                    eliminarPersona(ci);
                break;

                case 3:
                    System.out.println("Ingresa el ci: ");
                    ci = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese su cargo");
                    String cargo = scanner.nextLine();
                    editarPersona(ci, cargo);
                break;

                case 4:
                    mostrarLista();
                break;

                case 5:
                    Material material = new Material();
                    material.iniciar();
                break;

                default:
            }

        }while(opcion != 0);
    }

    private void registrarPersona(){
        System.out.println("nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        System.out.println("ci: ");
        int ci = scanner.nextInt();
        System.out.println("edad: ");
        int edad = scanner.nextInt();
        System.out.println("cargo: \n[1] Estudiante\n[2]docente");
        int cargo = scanner.nextInt();
        if(cargo == 1){
            scanner.nextLine();
            System.out.println("ingrese su codigo sys");
            String codSys = scanner.nextLine();
            Estudiante estudiante = new Estudiante(nombre, ci, edad, "estudiante", codSys);
            ArchivoEstudiante.postEstudiante(estudiante);
            listaPersonas = ArchivoPersona.getListaPersonas();
            listaPersonas.add(estudiante.getCi() + "");
            ArchivoPersona.postListaPersonas(listaPersonas);
        }

        if(cargo == 2){
            scanner.nextLine();
            System.out.println("ingrese su codigo docente");
            String codDocente = scanner.nextLine();
            Docente docente = new Docente(nombre, ci, edad, "docente", codDocente);
            ArchivoDocente.postDocente(docente);
            listaPersonas = ArchivoPersona.getListaPersonas();
            listaPersonas.add(docente.getCi() + "");
            ArchivoPersona.postListaPersonas(listaPersonas);
        }

    }

    private void eliminarPersona(int ci){
        String fileNombre = ci + ".txt";
        Path path = Paths.get(fileNombre);
        try{
            ArrayList<String> newListPersonas = ArchivoPersona.getListaPersonas();
            for(String personaCi : ArchivoPersona.getListaPersonas()){
                if(Integer.parseInt(personaCi) == ci){
                    newListPersonas.remove(personaCi);
                    ArchivoPersona.postListaPersonas(newListPersonas);
                }
            }

            Files.delete(path);

        }catch(IOException e){

        }
    }


    private void editarPersona(int ci, String categoria){

        if(categoria.equals("estudiante")){
            Estudiante estudiante = ArchivoEstudiante.getEstudiante(ci);
            System.out.println("[1] nombre" + "\n[2] ci" + "\n[3] edad" + "\n[4] cargo" + "\n[5] codigo Sys");
            int opcion = scanner.nextInt();

            if(opcion == 1){
                scanner.nextLine();
                String nombre = scanner.nextLine();
                estudiante.setNombre(nombre);
            }

            if(opcion == 2){
                int newCi = scanner.nextInt();
                estudiante.setCi(newCi);
                eliminarPersona(ci);
                listaPersonas = ArchivoPersona.getListaPersonas();
                listaPersonas.add(estudiante.getCi() + "");
                ArchivoPersona.postListaPersonas(listaPersonas);
            }

            if(opcion == 3){
                int edad = scanner.nextInt();
                estudiante.setEdad(edad);
            }

            if(opcion == 4){
                scanner.nextLine();
                String cargo = scanner.nextLine();
                estudiante.setCargo(cargo);
            }
            if(opcion == 5){
                String codSys = scanner.nextLine();
                estudiante.setCodSys(codSys);
            }

            ArchivoEstudiante.postEstudiante(estudiante);

        }else{
            Docente docente = ArchivoDocente.getDocente(ci);
            System.out.println("[1] nombre" + "\n[2] ci" + "\n[3] edad" + "\n[4] cargo" + "\n[5] codigo Docente");
            int opcion = scanner.nextInt();

            if(opcion == 1){
                scanner.nextLine();
                String nombre = scanner.nextLine();
                docente.setNombre(nombre);
            }

            if(opcion == 2){
                int newCi = scanner.nextInt();
                docente.setCi(newCi);
            }

            if(opcion == 3){
                int edad = scanner.nextInt();
                docente.setEdad(edad);
            }

            if(opcion == 4){
                scanner.nextLine();
                String cargo = scanner.nextLine();
                docente.setCargo(cargo);
            }
            if(opcion == 5){
                String codDocente = scanner.nextLine();
                docente.setCodDocente(codDocente);
            }

            ArchivoDocente.postDocente(docente);

        }
    }

    private void mostrarLista(){
        listaPersonas =  ArchivoPersona.getListaPersonas();
        for(String ci : listaPersonas){
            Docente docente = ArchivoDocente.getDocente(Integer.parseInt(ci));
            Estudiante estudiante = ArchivoEstudiante.getEstudiante(Integer.parseInt(ci));
            if(docente.getCargo().equals("docente")){
                System.out.println(docente);
            }

            if(estudiante.getCargo().equals("estudiante")){
                System.out.println(estudiante);
            }
        }
    
    }
}
