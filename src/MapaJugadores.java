import java.util.HashMap;
import java.util.HashSet;

public class MapaJugadores {

    private HashMap<Posiciones, HashSet<Jugador>> jugadoresPorPosicion;

    public MapaJugadores() {
        jugadoresPorPosicion = new HashMap<>();
        for (Posiciones posicion : Posiciones.values())
        {
            jugadoresPorPosicion.put(posicion,new HashSet<>());
        }

    }

    public HashMap<Posiciones, HashSet<Jugador>> getJugadoresPorPosicion() {
        return jugadoresPorPosicion;
    }

    public void agregarJugador(Jugador jugador) throws JugadorInvalidoException, PosicionInvalidaException {
        if (jugador == null) {
            throw new JugadorInvalidoException("El jugador es nulo y no puede ser agregado.");
        }

        Posiciones posicion = jugador.getPosicion();

        if (posicion == null) {
            throw new JugadorInvalidoException("La posición del jugador no puede ser nula.");
        }

        if (!jugadoresPorPosicion.containsKey(posicion)) {
            throw new PosicionInvalidaException("La posición " + posicion + " no es válida.");
        }

        HashSet<Jugador> jugadores = jugadoresPorPosicion.get(posicion);
        jugadores.add(jugador);
    }

    public HashSet<Jugador> obtenerJugadoresPorPosicion(Posiciones posicion)
    {
        return jugadoresPorPosicion.get(posicion);

    }

    public Jugador buscarJugador(int id)
    {
        for (Posiciones posicion : jugadoresPorPosicion.keySet())
        {
            HashSet<Jugador> jugadores = jugadoresPorPosicion.get(posicion);
            for (Jugador j : jugadores)
            {
                if(id == j.getId())
                {
                    return j;
                }
            }
        }
        return null;
    }

    public void removerJugador(int id)
    {
        Jugador jugador =null;
        jugador = buscarJugador(id);
        if(jugador != null)
        {
            for (Posiciones posicion : jugadoresPorPosicion.keySet())
            {
                HashSet<Jugador>jugadores = jugadoresPorPosicion.get(posicion);
                if(jugadores.remove(jugador))
                {
                    System.out.println("Jugador removido con exito");
                    break;
                }

            }
        }
    }

    public void imprimirJugadoresPorPosicion()
    {
        for(Posiciones posicion: jugadoresPorPosicion.keySet())
        {
            System.out.println("Posicion: " + posicion);
            for (Jugador jugador: jugadoresPorPosicion.get(posicion))
            {
                System.out.println(jugador.toString());
            }
        }
    }
}

