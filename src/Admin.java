import java.io.Serializable;
import java.util.*;


public class Admin extends Usuario implements Serializable {

    public Admin() {
    }

    public Admin(String user, String password) {
        super(user, password);
        setRol("Admin");
    }

    public static void agregar() {
        // AGREGA UN NUEVO JUGADOR AL JSON DE JUGADORES
        MapaJugadores map =  new MapaJugadores();
        map = ComunicacionJson.cargarMapaFromJson("mapaJugadores.Json");
        Scanner sc = new Scanner(System.in);

        String nombre;
        String apellido;
        String equipo;
        int dorsal;
        double altura;
        String fechaNacimiento;
        double puntoBase;
        double reboteBase;
        double asistenciasBase;
        double tapasBase;
        double perdidasBase;
        int desempenoPuntos;
        int desempenoRebotes;
        int desempenoAsistencias;
        int desempenoTapas;
        int desempenoPerdidas;
        int precio;
        int opc;

        System.out.println("Creacion del nuevo Jugador");
        System.out.println("Ingrese nombre: ");
        nombre = sc.next();
        System.out.println("Ingrese apellido: ");
        apellido = sc.next();
        System.out.println("Ingrese equipo: ");
        equipo = sc.next();
        System.out.println("Ingrese dorsal: ");
        dorsal = sc.nextInt();
        System.out.println("Ingrese altura: ");
        altura = sc.nextDouble();
        System.out.println("Ingrese fecha de nacimiento: ");
        fechaNacimiento = sc.next();
        System.out.println("Puntos promedio por partido: ");
        puntoBase = sc.nextDouble();
        System.out.println("Rebotes promedio por partido: ");
        reboteBase = sc.nextDouble();
        System.out.println("Asistencia promedio por partido: ");
        asistenciasBase = sc.nextDouble();
        System.out.println("Tapadas promedio por partido: ");
        tapasBase = sc.nextDouble();
        System.out.println("Pelotas perdida por partido: ");
        perdidasBase = sc.nextDouble();
        System.out.println("Desempeño de puntos por partido (de 1 / 3): ");
        desempenoPuntos = sc.nextInt();



        while(desempenoPuntos < 1 || desempenoPuntos > 3) {
            System.out.println("Ingrese un desempeño del 1 al 3. Vuelve a intentarlo.\n\tDesempeño de puntos por partido (de 1 / 3): ");
            desempenoPuntos = sc.nextInt();
        }

        System.out.println("Desempeño de rebotes por partido (de 1 / 3): ");
        desempenoRebotes = sc.nextInt();
        while(desempenoRebotes < 1 || desempenoRebotes > 3) {
            System.out.println("Ingrese un desempeño del 1 al 3. Vuelve a intentarlo.\n\tDesempeño de rebotes por partido (de 1 / 3): ");
            desempenoRebotes = sc.nextInt();
        }

        System.out.println("Desempeño de asistencias por partido (de 1 / 3): ");
        desempenoAsistencias = sc.nextInt();
        while(desempenoAsistencias < 1 || desempenoAsistencias > 3) {
            System.out.println("Ingrese un desempeño del 1 al 3. Vuelve a intentarlo.\n\tDesempeño de asistencias por partido (de 1 / 3): ");
            desempenoAsistencias = sc.nextInt();
        }
        System.out.println("Desempeño de tapas por partido (de 1 / 3): ");
        desempenoTapas = sc.nextInt();
        while(desempenoTapas < 1 || desempenoTapas > 3) {
            System.out.println("Ingrese un desempeño del 1 al 3. Vuelve a intentarlo.\n\tDesempeño de tapas por partido (de 1 / 3): ");
            desempenoTapas = sc.nextInt();
        }

        System.out.println("Desempeño de perdidas por partido (de 1 / 3): ");
        desempenoPerdidas = sc.nextInt();
        while(desempenoPerdidas < 1 || desempenoPerdidas > 3) {
            System.out.println("Ingrese un desempeño del 1 al 3. Vuelve a intentarlo.\n\tDesempeño de perdidas por partido (de 1 / 3): ");
            desempenoPerdidas = sc.nextInt();
        }

        System.out.println("Ingrese precio del jugador: ");
        precio = sc.nextInt();

        System.out.println("Ingrese posicion\n\t1. Base\n\t2. Escolta\n\t3. Alero\n\t4. Alapivot\n\t5. Pivot: ");
        opc = sc.nextInt();
        while(opc < 1 || opc > 5) {
            System.out.println("Ingrese un numero del 1 al 5. Vuelve a intentarlo: ");
            opc = sc.nextInt();
        }

        switch(opc) {
            case 1:
                Jugador base = new Jugador(nombre, apellido, equipo, dorsal, altura, fechaNacimiento, Posiciones.Base, puntoBase, reboteBase, asistenciasBase, tapasBase, perdidasBase, desempenoPuntos, desempenoRebotes, desempenoAsistencias, desempenoTapas, desempenoPerdidas, precio);
                try {
                    map.agregarJugador(base);
                } catch (PosicionInvalidaException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (JugadorInvalidoException e)
                {
                    System.out.println(e.getMessage());
                }
                ComunicacionJson.guardarMapaToJson(map,"mapaJugadores.Json");
                System.out.println("Jugador agregador correctamente.");
                break;

            case 2:
                Jugador escolta = new Jugador(nombre, apellido, equipo, dorsal, altura, fechaNacimiento, Posiciones.Escolta, puntoBase, reboteBase, asistenciasBase, tapasBase, perdidasBase, desempenoPuntos, desempenoRebotes, desempenoAsistencias, desempenoTapas, desempenoPerdidas, precio);
                try {
                    map.agregarJugador(escolta);
                } catch (PosicionInvalidaException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (JugadorInvalidoException e)
                {
                    System.out.println(e.getMessage());
                }
                ComunicacionJson.guardarMapaToJson(map,"mapaJugadores.Json");
                System.out.println("Jugador agregador correctamente.");
                break;

            case 3:
                Jugador alero = new Jugador(nombre, apellido, equipo, dorsal, altura, fechaNacimiento, Posiciones.Alero, puntoBase, reboteBase, asistenciasBase, tapasBase, perdidasBase, desempenoPuntos, desempenoRebotes, desempenoAsistencias, desempenoTapas, desempenoPerdidas, precio);
                try {
                    map.agregarJugador(alero);
                } catch (PosicionInvalidaException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (JugadorInvalidoException e)
                {
                    System.out.println(e.getMessage());
                }
                ComunicacionJson.guardarMapaToJson(map,"mapaJugadores.Json");
                System.out.println("Jugador agregador correctamente.");
                break;

            case 4:
                Jugador alapivot = new Jugador(nombre, apellido, equipo, dorsal, altura, fechaNacimiento, Posiciones.Alapivot, puntoBase, reboteBase, asistenciasBase, tapasBase, perdidasBase, desempenoPuntos, desempenoRebotes, desempenoAsistencias, desempenoTapas, desempenoPerdidas, precio);
                try {
                    map.agregarJugador(alapivot);
                } catch (PosicionInvalidaException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (JugadorInvalidoException e)
                {
                    System.out.println(e.getMessage());
                }
                ComunicacionJson.guardarMapaToJson(map,"mapaJugadores.Json");
                System.out.println("Jugador agregador correctamente.");
                break;

            case 5:
                Jugador pivot = new Jugador(nombre, apellido, equipo, dorsal, altura, fechaNacimiento, Posiciones.Pivot, puntoBase, reboteBase, asistenciasBase, tapasBase, perdidasBase, desempenoPuntos, desempenoRebotes, desempenoAsistencias, desempenoTapas, desempenoPerdidas, precio);
                try {
                    map.agregarJugador(pivot);
                } catch (PosicionInvalidaException e)
                {
                    System.out.println(e.getMessage());
                }
                catch (JugadorInvalidoException e)
                {
                    System.out.println(e.getMessage());
                }
                ComunicacionJson.guardarMapaToJson(map,"mapaJugadores.Json");
                System.out.println("Jugador agregador correctamente.");
                break;

            default:
                System.out.println("Posicion incorrecta. Vuelve a intentarlo");
                break;
        }
    }

    public static void borrar() {
        Scanner sc = new Scanner(System.in);
        MapaJugadores map = new MapaJugadores();
        // ELIMINA UN JUGADOR DEL JSON DE JUGADORES
        System.out.println("Ingrese ID del jugador a eliminar: ");
        int id = sc.nextInt();
        map = ComunicacionJson.cargarMapaFromJson("mapaJugadores.Json");
        // HACER METODO PARA ENCONTRAR UN JUGADOR EN EL MAPA DE JUGADORES Y LUEGO REMOVERLO
        map.removerJugador(id);

        ComunicacionJson.guardarMapaToJson(map,"mapaJugadores.Json");
    }

    public static void eliminarUsuario(String user) {
        // ELIMINA UN USUARIO DEL JSON DE USUARIOS
        ArrayList<Player> users = ComunicacionJson.cargarListFromJson("archivoPlayers.Json", Player.class);
        Usuario encontrado = null;
        boolean flag = false;
        for(Usuario usuario: users) {
            if(usuario.getUser().equals(user)) {
                encontrado = usuario;
                flag = true;
            }
        }


        if(flag) {
            users.remove(encontrado);
            ComunicacionJson.guardarListToJson(users,"archivoPlayers.Json");
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Lo siento el usuario no fue encontrado. Vuelve a intentarlo");
        }
    }

    public static void modificarUsuario(String user) {
        // MODIFICA CONTRASEÑA O USERNAME DE UN USUARIO DEL JSON DE USUARIOS
        ArrayList<Player> users = ComunicacionJson.cargarListFromJson("archivoPlayers.Json", Player.class);

        Scanner scanner = new Scanner(System.in);
        int opc;
        boolean flag = false;
        for(Usuario usuario: users) {
            if(usuario.getUser().equals(user)) {
                System.out.println("1. Cambiar contraseña\n2. Cambiar nombre de usuario");
                opc = scanner.nextInt();
                switch(opc) {
                    case 1:
                        System.out.println("Nueva contraseña: ");
                        String password = scanner.next();
                        usuario.setPassword(password);
                        ComunicacionJson.guardarListToJson(users,"archivoPlayers.Json");
                        flag = true;
                        break;

                    case 2:
                        System.out.println("Nuevo nombre de usuario: ");
                        String name = scanner.next();
                        usuario.setUser(name);
                        ComunicacionJson.guardarListToJson(users,"archivoPlayers.Json");
                        flag = true;
                        break;

                    default:
                        System.out.println("Opcion incorrecta. Vuelve a intentarlo.");
                        break;
                }
            }
        }

        if(flag) {
            System.out.println("Usuario modificado correctamente.");
        } else {
            System.out.println("Lo sentimos, no se encontro al usuario. Vuelve a intentarlo");
        }
    }


    public static void mostrarUsuarios() {
        ArrayList<Player> users = ComunicacionJson.cargarListFromJson("archivoPlayers.Json", Player.class);
        for(Player user: users) {
            user.mostrarPlayer();        }
    }

    public static void jugarSemana()
    {
        ArrayList<Player>users = ComunicacionJson.cargarListFromJson("archivoPlayers.Json", Player.class);
        for (Player player : users)
        {
            player.setPuntajeSemanal();
            player.setPuntajeAcumulado();
        }
        System.out.println("Semana jugada con exito");
        ComunicacionJson.guardarListToJson(users,"archivoPlayers.Json");
    }

    public static void rankingSemanal()
    {
        ArrayList<Player>users = ComunicacionJson.cargarListFromJson("archivoPlayers.Json",Player.class);
        HashMap<String,Float>map = new HashMap<>();

        for(Player player: users)
        {
            map.put(player.getUser(), player.getPuntajeSemanal());
        }

        LinkedHashMap<String,Float> sortedMap = sortByValue(map);

        for (Map.Entry<String,Float>entry : sortedMap.entrySet())
        {
            System.out.println("Usuario: " + entry.getKey() + " Puntaje semanal " + entry.getValue());
        }

    }

    public static LinkedHashMap<String, Float> sortByValue(HashMap<String, Float> map) {
        // Crear una lista a partir de las entradas del mapa
        List<Map.Entry<String, Float>> list = new ArrayList<>(map.entrySet());

        // Ordenar la lista con un comparador personalizado
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Crear un LinkedHashMap para mantener el orden de las entradas
        LinkedHashMap<String, Float> result = new LinkedHashMap<>();
        for (Map.Entry<String, Float> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void rankingGeneral()
    {
        ArrayList<Player>users = ComunicacionJson.cargarListFromJson("archivoPlayers.Json",Player.class);
        HashMap<String,Float>map = new HashMap<>();

        for(Player player: users)
        {
            map.put(player.getUser(), player.getPuntajeAcumulado());
        }

        LinkedHashMap<String,Float> sortedMap = sortByValue(map);

        for (Map.Entry<String,Float>entry : sortedMap.entrySet())
        {
            System.out.println("Usuario: " + entry.getKey() + " Puntaje general " + entry.getValue());
        }

    }


}

