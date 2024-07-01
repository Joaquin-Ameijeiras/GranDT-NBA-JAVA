import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opc;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        String user;
        String password;
        InterfazApp interfaz = new InterfazApp();
        ArrayList<Player> users = new ArrayList<>();

        while (!salir) {

            System.out.println("GRAN DT NBA\n1. Iniciar Sesión\n2. Registrarse\n3. Salir");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número.");
                sc.next();
            }
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Usuario: ");
                    user = sc.next();
                    System.out.print("Contraseña: ");
                    password = sc.next();

                    Usuario usuario = confirmarUsuario(user, password);

                    if (usuario != null) {
                        if (usuario.getRol().equals("Player")) {
                            interfaz.interfazPlayerInicio((Player) usuario);
                        } else {
                            interfaz.interfazAdminInicio();
                        }
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }
                    break;

                case 2:
                    System.out.print("Crear Usuario: ");
                    user = sc.next();
                    System.out.print("Crear Contraseña: ");
                    password = sc.next();
                    if (verificarNombre(user, "archivoPlayers.Json")) {
                        System.out.println("Lo sentimos, ya existe un usuario con ese nombre. Vuelve a intentarlo.");
                    } else {
                        //users = leerJsonUsuarios();
                        users = ComunicacionJson.cargarListFromJson("archivoPlayers.Json", Player.class);
                        users.add(new Player(user, password));
                        ComunicacionJson.guardarListToJson(users, "archivoPlayers.Json");
                    }
                    break;

                case 3:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción incorrecta. Por favor vuelve a intentarlo\n");
                    break;
            }


        }


    }

    public static boolean verificarNombre(String user,String archivo) {
        ArrayList<Usuario> users = ComunicacionJson.cargarListFromJson(archivo,Usuario.class);
        if (users != null) {
            for (Usuario usuario : users) {
                if (usuario.getUser().equals(user)) {
                    return true;
                }
            }
        }
        return false;
    }

 public static Usuario confirmarUsuario(String user, String password) {
        ArrayList<Player> p =ComunicacionJson.cargarListFromJson("archivoPlayers.Json",Player.class);
        Admin a=ComunicacionJson.cargarClaseFromJson("archivoAdmin.Json");
        if (a != null) {

                if (a.getUser().equals(user) && a.getPassword().equals(password)) {
                    return a;
                }
        }if(p!=null) {
            for (Player player : p) {

                if (player.getUser().equals(user) && player.getPassword().equals(password)) {
                    return player;
                }
            }

        }

        return null;
    }
}