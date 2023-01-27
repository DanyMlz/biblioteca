import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {
    private String nombre;
    private String direccion;
    private Scanner scanner;
    public ArrayList<Persona> listaPersonas;

    public Biblioteca(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        scanner = new Scanner(System.in);
        listaPersonas = new ArrayList<Persona>();
    }

    public void menu(){
        System.out.println("Bienvenidos a la biblioteca " + nombre );
        System.out.println("[1] registrar personas");
        System.out.println("[2] eliminar persona");
        System.out.println("[3] editar persona");
        System.out.println("[4] mostrar personas");
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
                    editarPersona(ci);
                break;

                case 4:
                    mostrarLista();
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
        Persona persona = new Persona(nombre, ci, edad);
        listaPersonas.add(persona);
    }

    private void eliminarPersona(int ci){
        Persona persona = buscarPersona(ci);
        listaPersonas.remove(persona);
    }


    private void editarPersona(int ci){
        Persona persona = buscarPersona(ci);
        System.out.println("[1] nombre" + "\n[2] ci" + "\n[3] edad");
        int opcion = scanner.nextInt();
        if(opcion == 1){
            scanner.nextLine();
            String nombre = scanner.nextLine();
            persona.setNombre(nombre);
        }

        if(opcion == 2){
            int newCi = scanner.nextInt();
            persona.setCi(newCi);
        }

        if(opcion == 3){
            int edad = scanner.nextInt();
            persona.setEdad(edad);
        }
    }


    private void mostrarLista(){
        for(Persona persona : listaPersonas){
            System.out.println(persona);
        }
    }

    
    private Persona buscarPersona(int ci){
        for(Persona persona : listaPersonas) {
            if(persona.getCi() == ci){
                return persona;
            }
        }
        return null;
    }
}
