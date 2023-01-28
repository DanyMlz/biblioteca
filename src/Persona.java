public class Persona {
    protected String nombre;
    protected int ci;
    protected int edad;
    protected String cargo;

    public Persona(String nombre, int ci, int edad, String cargo) {
        this.nombre = nombre;
        this.ci = ci;
        this.edad = edad;
        this.cargo = cargo;
    }

    protected int getCi(){
        return this.ci;
    }

    protected String getCargo(){
        return this.cargo;
    }

    protected String getNombre(){
        return this.nombre;
    }

    protected int getEdad(){
        return this.edad;
    }

    protected void setNombre(String nombre){
        this.nombre = nombre;
    }

    protected void setCi(int ci){
        this.ci = ci;
    }

    protected void setEdad(int edad){
        this.edad = edad;
    }

    protected void setCargo(String cargo){
        this.cargo = cargo;
    }

    @Override
    public String toString(){
        return "\nNombre: "+ this.nombre + "\nCi: " + this.ci + "\nEdad: " + this.edad + "\nCargo: " + this.cargo;
    }

}
