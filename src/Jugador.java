import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Jugador implements Serializable {

    private String nombre;
    private String apellido;
    private Equipos equipo;
    private double altura;//(cm)
    private int dorsal;
    private String fechaNacimiento; // = LocalDate.of(1994,10,25) ejemplo
    private Posiciones posicion;
    private double puntoBase;
    private int desempenoPuntos;//(1-10)
    private double rebotesBase;
    private int desempenoRebotes;
    private double asistenciasBase;
    private int desempenoAsistencias;
    private double tapasBase;
    private int desempenoTapas;
    private double perdidasBase;
    private int desempenoPerdidas;
    private int precio;
    private float  puntaje;
    private int id;
    private static int idCounter = 0;


    public Jugador() {
        this.id = ++idCounter;

    }


    public Jugador(String nombre, String apellido, String equipo, int dorsal, double altura, String fechaNacimiento, Posiciones posicion, double puntoBase,
                   double rebotesBase, double asistenciasBase, double tapasBase, double perdidasBase, int desempenoPuntos, int desempenoRebotes, int desempenoAsistencias, int desempenoTapas, int desempenoPerdidas, int precio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = Equipos.fromString(equipo);
        this.altura = altura;
        this.fechaNacimiento = fechaNacimiento;
        this.posicion = posicion; //Posiciones.fromString(posicion);
        this.puntoBase = puntoBase;
        this.rebotesBase = rebotesBase;
        this.asistenciasBase = asistenciasBase;
        this.tapasBase = tapasBase;
        this.perdidasBase = perdidasBase;
        this.dorsal = dorsal;
        this.desempenoPuntos = desempenoPuntos;
        this.desempenoRebotes = desempenoRebotes;
        this.desempenoAsistencias = desempenoAsistencias;
        this.desempenoTapas = desempenoTapas;
        this.desempenoPerdidas = desempenoPerdidas;
        this.precio=precio;
        this.id = ++idCounter;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public double getAltura() {
        return altura;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Posiciones getPosicion() {
        return posicion;
    }

    public double getPuntoBase() {
        return puntoBase;
    }

    public double getRebotesBase() {
        return rebotesBase;
    }

    public double getAsistenciasBase() {
        return asistenciasBase;
    }

    public double getTapasBase() {
        return tapasBase;
    }

    public double getPerdidasBase() {
        return perdidasBase;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public float  getPuntaje() {
        return puntaje;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", equipo=" + equipo +
                ", altura=" + altura +
                ", dorsal=" + dorsal +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", posicion=" + posicion +
                ", puntoBase=" + puntoBase +
                ", rebotesBase=" + rebotesBase +
                ", asistenciasBase=" + asistenciasBase +
                ", tapasBase=" + tapasBase +
                ", perdidasBase=" + perdidasBase +
                ", precio=" + precio +
                ",  ID= "+id+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre) && Objects.equals(apellido, jugador.apellido) && Objects.equals(fechaNacimiento, jugador.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, fechaNacimiento);
    }


    public void sumaPoint ()
    {
        puntaje=0;
        Random aleatorio=new Random(System.currentTimeMillis());
        //Suma el puntaje generado por los puntos generados al puntaje final que aporta el jugador
        int desempenioAlea=aleatorio.nextInt()%10+ desempenoPuntos;
        if (desempenioAlea<=4)
        {
            puntaje=puntaje+(float)(puntoBase*0.7F);
        }else if (desempenioAlea<=8)
        {
            puntaje=puntaje+(float)(puntoBase*1.0F);
        }else {
            puntaje=puntaje+(float)(puntoBase*1.5F);
        }
        //Suma el puntaje generado por los rebotes generados al puntaje final que aporta el jugador
        desempenioAlea=aleatorio.nextInt()%10+ desempenoRebotes;
        if (desempenioAlea<=4)
        {
            puntaje=puntaje+(float)(rebotesBase*0.7F);
        }else if (desempenioAlea<=8)
        {
            puntaje=puntaje+(float)(rebotesBase*1.0F);
        }else {
            puntaje=puntaje+(float)(rebotesBase*1.5F);
        }
        //Suma el puntaje generado por las asistencias generados al puntaje final que aporta el jugador
        desempenioAlea=aleatorio.nextInt()%10+ desempenoAsistencias;
        if (desempenioAlea<=4)
        {
            puntaje=puntaje+(float)(asistenciasBase*0.7F);
        }else if (desempenioAlea<=8)
        {
            puntaje=puntaje+(float)(asistenciasBase*1.0F);
        }else {
            puntaje=puntaje+(float)(asistenciasBase*1.5F);
        }
        //Suma el puntaje generado por los tapones generados al puntaje final que aporta el jugador
        desempenioAlea=aleatorio.nextInt()%10+ desempenoTapas;
        if (desempenioAlea<=4)
        {
            puntaje=puntaje+(float)(tapasBase*0.7F);
        }else if (desempenioAlea<=8)
        {
            puntaje=puntaje+(float)(tapasBase*1.0F);
        }else {
            puntaje=puntaje+(float)(tapasBase*1.5F);
        }
        //Resta el puntaje generado por las perdidas de balon generados al puntaje final que aporta el jugador
        desempenioAlea=aleatorio.nextInt()%10+ desempenoPerdidas;
        if (desempenioAlea<=4)
        {
            puntaje=puntaje-(float)(perdidasBase*0.7F);
        }else if (desempenioAlea<=8)
        {
            puntaje=puntaje-(float)(perdidasBase*1.0F);
        }else {
            puntaje=puntaje-(float)(perdidasBase*1.5F);
        }

    }
}
