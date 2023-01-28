
public class Revista extends Material{
    public Revista(String id, String titulo, String editorial, String categoria){
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "Id: " + this.id + "\nTitulo: "+ this.titulo + "\nEditorial: " + this.editorial + "\nCategoria: " + this.categoria;
    }
}
