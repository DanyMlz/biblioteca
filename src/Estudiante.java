public class Estudiante extends Persona{
    private String codSys;

    public Estudiante(String nombre, int ci, int edad, String cargo,String codSys){
        super(nombre, ci, edad, cargo);
        this.codSys = codSys;
    }

    public String getCodSys(){
        return this.codSys;
    }

    public void setCodSys(String codSys){
        this.codSys = codSys;
    }

    @Override
    public String toString(){
        return "Codigo Sys: " + this.codSys + "\nNombre: "+ this.nombre + "\nCi: " + this.ci + "\nEdad: " + this.edad + "\nCargo: " + this.cargo;
    }

}
