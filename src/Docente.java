
public class Docente extends Persona {
    private String codDocente;
    public Docente(String nombre, int ci, int edad, String cargo, String codDocente) {
        super(nombre, ci, edad, cargo);
        this.codDocente = codDocente;
    }

    public String getCodDocente(){
        return this.codDocente;
    }

    public void setCodDocente(String codDocente) {
        this.codDocente = codDocente;
    }

    @Override
    public String toString(){
        return "Codigo Docente: " + this.codDocente + "\nNombre: "+ this.nombre + "\nCi: " + this.ci + "\nEdad: " + this.edad + "\nCargo: " + this.cargo;
    }

}