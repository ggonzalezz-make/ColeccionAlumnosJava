public class Alumno {

    //En esta parte se crea la entidad o la clase llamada Alumnos


    //Aca se definen los atributos
    private String carnet;
    private String nombre;

    //Aca se les asigna los parametros a la entidad
    public Alumno(String carnet, String nombre) {
        this.carnet = carnet;
        this.nombre = nombre;
    }

      //Aca se crea el metodo para poder consultar el carnet del alumno
    public String getCarnet() {
        return carnet;
    }

    //aca se crea el metodo para consultar el nombre del alumno
    public String getNombre() {
        return nombre;
    }

    
//esto define el metodo to string para definir como se mostraran los objetos 
    @Override
    public String toString() {
        return "Carnet: " + carnet + 
               " | Nombre: " + nombre;
    }
}