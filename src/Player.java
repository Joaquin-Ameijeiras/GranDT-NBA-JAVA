import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;



public class Player extends Usuario implements Serializable {

    private ArrayList<Jugador>equipo;

    private float puntajeSemanal =0;
    private float puntajeAcumulado=0;

    private int presupuesto = 200;



    public Player() {
        equipo = new ArrayList<>();
    }

    public Player(String user, String password) {
        super(user, password);
        setRol("Player");
        equipo = new ArrayList<>();
    }


    public ArrayList<Jugador> getEquipo() {
        return equipo;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }



    public float getPuntajeSemanal() {
        return puntajeSemanal;
    }


    public float getPuntajeAcumulado() {
        return puntajeAcumulado;
    }


    public void verJugadoresCompleto()
    {
        MapaJugadores mapaJugadores = new MapaJugadores();
        mapaJugadores = ComunicacionJson.cargarMapaFromJson("mapaJugadores.json");
        mapaJugadores.imprimirJugadoresPorPosicion();

    }


    public void verJugadoresBases()
    {
        MapaJugadores mapaJugadores = new MapaJugadores();
        mapaJugadores = ComunicacionJson.cargarMapaFromJson("mapaJugadores.json");
        HashSet<Jugador>jugadores = new HashSet<>();
        jugadores = mapaJugadores.obtenerJugadoresPorPosicion(Posiciones.Base);

        for (Jugador jugador : jugadores)
        {
            System.out.println(jugador.toString());
        }
    }
    public void verJugadoresEscoltas()
    {
        MapaJugadores mapaJugadores = new MapaJugadores();
        mapaJugadores = ComunicacionJson.cargarMapaFromJson("mapaJugadores.json");
        HashSet<Jugador>jugadores = new HashSet<>();
        jugadores = mapaJugadores.obtenerJugadoresPorPosicion(Posiciones.Escolta);

        for (Jugador jugador : jugadores)
        {
            System.out.println(jugador.toString());
        }
    }
    public void verJugadoresAleros()
    {
        MapaJugadores mapaJugadores = new MapaJugadores();
        mapaJugadores = ComunicacionJson.cargarMapaFromJson("mapaJugadores.json");
        HashSet<Jugador>jugadores = new HashSet<>();
        jugadores = mapaJugadores.obtenerJugadoresPorPosicion(Posiciones.Alero);

        for (Jugador jugador : jugadores)
        {
            System.out.println(jugador.toString());
        }
    }
    public void verJugadoresAlaPivot()
    {
        MapaJugadores mapaJugadores = new MapaJugadores();
        mapaJugadores = ComunicacionJson.cargarMapaFromJson("mapaJugadores.json");
        HashSet<Jugador>jugadores = new HashSet<>();
        jugadores = mapaJugadores.obtenerJugadoresPorPosicion(Posiciones.Alapivot);

        for (Jugador jugador : jugadores)
        {
            System.out.println(jugador.toString());
        }
    }
    public void verJugadoresPivot()
    {
        MapaJugadores mapaJugadores = new MapaJugadores();
        mapaJugadores = ComunicacionJson.cargarMapaFromJson("mapaJugadores.json");
        HashSet<Jugador>jugadores = new HashSet<>();
        jugadores = mapaJugadores.obtenerJugadoresPorPosicion(Posiciones.Pivot);

        for (Jugador jugador : jugadores)
        {
            System.out.println(jugador.toString());
        }
    }

   /* public Jugador buscarJugadorNombre(String nombre,String apellido, Posiciones posicion, String archivo)
    {
        MapaJugadores mapaJugadores = new MapaJugadores();
        mapaJugadores = ComunicacionJson.cargarMapaFromJson(archivo);
        HashSet<Jugador>jugadores = new HashSet<>();
        jugadores = mapaJugadores.obtenerJugadoresPorPosicion(posicion);

        for (Jugador jugador : jugadores)
        {
            if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido))
            {
                return jugador;
            }
        }
        try {
            throw new PersonaNoEncontradaException("El jugador no fue encontrado");
        } catch (PersonaNoEncontradaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }*/

    /*public Jugador buscarJugadorNombre(int id ,Posiciones posicion,String archivo) throws PersonaNoEncontradaException {
        MapaJugadores mapaJugadores = ComunicacionJson.cargarMapaFromJson(archivo);
        HashSet<Jugador> jugadores = mapaJugadores.obtenerJugadoresPorPosicion(posicion);

        for (Jugador jugador : jugadores) {
            if (jugador.getId()==id) {
                return jugador;
            }
        }

        throw new PersonaNoEncontradaException("El jugador no fue encontrado");
    }*/

    public Jugador buscarJugadorID(int id ,Posiciones posicion,String archivo) throws PersonaNoEncontradaException {
        MapaJugadores mapaJugadores = ComunicacionJson.cargarMapaFromJson(archivo);
        HashSet<Jugador> jugadores = mapaJugadores.obtenerJugadoresPorPosicion(posicion);

        for (Jugador jugador : jugadores) {
            if (jugador.getId()==id) {
                return jugador;
            }
        }

        throw new PersonaNoEncontradaException("El jugador no fue encontrado");
    }


   /* public void comprarJugador(String nombre, String apellido, Posiciones posicion, String archivo)throws DineroInsuficienteException,EquipoCompletoException {
        Jugador jugador = buscarJugadorNombre(nombre, apellido, posicion, archivo);

        if (jugador != null) {
            if (equipo.size() < 5) {
                if (jugador.getPrecio() <= this.presupuesto) {
                    equipo.add(jugador);
                    setPresupuesto(this.presupuesto-jugador.getPrecio());
                    System.out.println("El jugador fue comprado con exito");
                } else {
                    throw new DineroInsuficienteException("Dinero insuficiente para commprar al jugador");
                }
            } else {
                throw new EquipoCompletoException("El equipo esta completo, no se pueden agregar mas jugadores");
            }
        }
    }*/

    public void comprarJugadorBase(int id) throws DineroInsuficienteException, EquipoCompletoException, JugadorRepetidoException {
        Jugador jugador = buscarJugadorEnMiEquipo(id);

        if(jugador != null)
        {
            throw new JugadorRepetidoException("El jugador que intenta comprar ya se encuentra en su equipo");
        }

        try {
            jugador = buscarJugadorID(id, Posiciones.Base,"mapaJugadores.json");
        } catch (PersonaNoEncontradaException e) {
            throw new RuntimeException(e);
        }

        if (jugador == null) {
            System.out.println("El jugador no fue encontrado.");
            return;
        }

        if (equipo.size() >= 5) {
            throw new EquipoCompletoException("El equipo está completo, no se pueden agregar más jugadores.");
        }

        if (jugador.getPrecio() > this.presupuesto) {
            throw new DineroInsuficienteException("Dinero insuficiente para comprar al jugador.");
        }

        equipo.add(jugador);
        setPresupuesto(this.presupuesto - jugador.getPrecio());
        System.out.println("El jugador fue comprado con éxito");
    }

    public void comprarJugadorEscolta(int id) throws DineroInsuficienteException, EquipoCompletoException, JugadorRepetidoException {
        Jugador jugador = buscarJugadorEnMiEquipo(id);

        if(jugador != null)
        {
            throw new JugadorRepetidoException("El jugador que intenta comprar ya se encuentra en su equipo");
        }

        try {
            jugador = buscarJugadorID(id, Posiciones.Escolta,"mapaJugadores.json");
        } catch (PersonaNoEncontradaException e) {
            throw new RuntimeException(e);
        }

        if (jugador == null) {
            System.out.println("El jugador no fue encontrado.");
            return;
        }

        if (equipo.size() >= 5) {
            throw new EquipoCompletoException("El equipo está completo, no se pueden agregar más jugadores.");
        }

        if (jugador.getPrecio() > this.presupuesto) {
            throw new DineroInsuficienteException("Dinero insuficiente para comprar al jugador.");
        }

        equipo.add(jugador);
        setPresupuesto(this.presupuesto - jugador.getPrecio());
        System.out.println("El jugador fue comprado con éxito");
    }

    public void comprarJugadorAlero(int id) throws DineroInsuficienteException, EquipoCompletoException, JugadorRepetidoException {
        Jugador jugador = buscarJugadorEnMiEquipo(id);

        if(jugador != null)
        {
            throw new JugadorRepetidoException("El jugador que intenta comprar ya se encuentra en su equipo");
        }

        try {
            jugador = buscarJugadorID(id, Posiciones.Alero,"mapaJugadores.json");
        } catch (PersonaNoEncontradaException e) {
            throw new RuntimeException(e);
        }

        if (jugador == null) {
            System.out.println("El jugador no fue encontrado.");
            return;
        }

        if (equipo.size() >= 5) {
            throw new EquipoCompletoException("El equipo está completo, no se pueden agregar más jugadores.");
        }

        if (jugador.getPrecio() > this.presupuesto) {
            throw new DineroInsuficienteException("Dinero insuficiente para comprar al jugador.");
        }

        equipo.add(jugador);
        setPresupuesto(this.presupuesto - jugador.getPrecio());
        System.out.println("El jugador fue comprado con éxito");
    }

    public void comprarJugadorAla(int id) throws DineroInsuficienteException, EquipoCompletoException, JugadorRepetidoException {
        Jugador jugador = buscarJugadorEnMiEquipo(id);

        if(jugador != null)
        {
            throw new JugadorRepetidoException("El jugador que intenta comprar ya se encuentra en su equipo");
        }

        try {
            jugador = buscarJugadorID(id, Posiciones.Alapivot,"mapaJugadores.json");
        } catch (PersonaNoEncontradaException e) {
            throw new RuntimeException(e);
        }

        if (jugador == null) {
            System.out.println("El jugador no fue encontrado.");
            return;
        }

        if (equipo.size() >= 5) {
            throw new EquipoCompletoException("El equipo está completo, no se pueden agregar más jugadores.");
        }

        if (jugador.getPrecio() > this.presupuesto) {
            throw new DineroInsuficienteException("Dinero insuficiente para comprar al jugador.");
        }

        equipo.add(jugador);
        setPresupuesto(this.presupuesto - jugador.getPrecio());
        System.out.println("El jugador fue comprado con éxito");
    }

    public void comprarJugadorPivot(int id) throws DineroInsuficienteException, EquipoCompletoException, JugadorRepetidoException {
        Jugador jugador = buscarJugadorEnMiEquipo(id);

        if(jugador != null)
        {
            throw new JugadorRepetidoException("El jugador que intenta comprar ya se encuentra en su equipo");
        }

        try {
            jugador = buscarJugadorID(id, Posiciones.Pivot,"mapaJugadores.json");
        } catch (PersonaNoEncontradaException e) {
            throw new RuntimeException(e);
        }

        if (jugador == null) {
            System.out.println("El jugador no fue encontrado.");
            return;
        }

        if (equipo.size() >= 5) {
            throw new EquipoCompletoException("El equipo está completo, no se pueden agregar más jugadores.");
        }

        if (jugador.getPrecio() > this.presupuesto) {
            throw new DineroInsuficienteException("Dinero insuficiente para comprar al jugador.");
        }

        equipo.add(jugador);
        setPresupuesto(this.presupuesto - jugador.getPrecio());
        System.out.println("El jugador fue comprado con éxito");
    }


    public void verMiEquipo()
    {
        System.out.println("Equipo: ");
        for(Jugador jugador : equipo)
        {
            System.out.println(jugador.toString());
        }
    }

    public Jugador buscarJugadorEnMiEquipo(int id)
    {

        for (Jugador jugador: getEquipo())
        {
            if(jugador.getId()==id)
            {
                return jugador;
            }
        }
        try {
            throw new PersonaNoEncontradaException("El jugador no fue encontrado en su equipo");
        }
        catch (PersonaNoEncontradaException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void borrar(int id) {
        Jugador jugador = buscarJugadorEnMiEquipo(id);
        if(jugador != null)
        {
            equipo.remove(jugador);
            presupuesto = presupuesto + jugador.getPrecio();
            System.out.println("Jugador removido con exito");
        }

    }

    public void setPuntajeSemanal()
    {
        float puntaje = 0;

        for(Jugador jugador: equipo)
        {
            jugador.sumaPoint();
            puntaje += jugador.getPuntaje();
        }
        this.puntajeSemanal = puntaje;
    }

    public void setPuntajeAcumulado()
    {
        this.puntajeAcumulado =puntajeAcumulado + puntajeSemanal;
    }


    public void mostrarPlayer() {
        System.out.println("\nPlayer{" +
                "user='" + getUser() + '\'' +
                ", password='" + getPassword() + '\'' +
                " puntajeSemanal=" + puntajeSemanal +
                ", puntajeAcumulado=" + puntajeAcumulado +
                ", presupuesto=" + presupuesto +
                "} ");
        verMiEquipo();
    }
}

