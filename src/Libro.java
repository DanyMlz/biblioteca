public class Libro extends Material{
    private String autor;

    public Libro(String id, String titulo, String editorial, String autor, String categoria){
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    @Override
    public String toString(){
        return "Id: " + this.id + "\nTitulo: "+ this.titulo + "\nEditorial: " + this.editorial + "\nAutor: " + this.autor + "\nCategoria: " + this.categoria;
    }

}
