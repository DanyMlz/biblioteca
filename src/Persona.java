public class Persona {
    private String nombre;
    private int ci;
    private int edad;

    public Persona(String nombre, int ci, int edad){
        this.nombre = nombre;
        this.ci = ci;
        this.edad = edad;
    }

    public int getCi(){
        return this.ci;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCi(int ci){
        this.ci = ci;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    @Override
    public String toString(){
        return "nombre: " + nombre + "\nci: " + ci + "\nedad: " + edad;
    }
}
