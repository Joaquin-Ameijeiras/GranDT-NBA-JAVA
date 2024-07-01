import com.sun.source.tree.ArrayAccessTree;

import java.util.Scanner;

public class InterfazApp {
    private Scanner sc = new Scanner(System.in);

    public InterfazApp() {
    }

    public void interfazAdminInicio() {
        boolean salir = false;
        while(!salir) {
            System.out.println("\n1. Ver lista de usuarios\n2. Modificar usuario\n3. Eliminar usuario\n4. Agregar Jugador\n5. Eliminar Jugador\n6.Jugar semana\n7. Ver ranking semanal\n8. Ver ranking general\n9. Salir");
            String name;
            int opc = sc.nextInt();
            switch (opc) {
                case 1:
                    Admin.mostrarUsuarios();
                    break;

                case 2:
                    System.out.println("Ingrese el nombre de usuario a Modificar: ");
                    name = sc.next();
                    Admin.modificarUsuario(name);
                    break;

                case 3:
                    System.out.println("Ingrese el nombre de usuario a Eliminar: ");
                    name = sc.next();
                    Admin.eliminarUsuario(name);
                    break;

                case 4:
                    Admin.agregar();
                    break;

                case 5:
                    Admin.borrar();
                    break;

                case 6:
                    Admin.jugarSemana();
                    break;

                case 7:
                    Admin.rankingSemanal();
                    break;

                case 8:
                    Admin.rankingGeneral();
                    break;

                case 9:
                    salir = true;
                    break;

                default:
                    System.out.println("Numero incorrecto vuelve a intentarlo.");
                    break;
            }
        }
    }

    public void interfazPlayerInicio(Player player)
    {
        /*if(player.getEquipo()==null)
        {
            //cree su equipo newbie
            //presentar jugadores disponibles
            //elegir jugadores 5
            //listo para jugar
        }*/

        boolean salir = false;
        while(!salir) {
            System.out.println("\n1. Ver mi equipo\n2. Modificar equipo\n3.Ver puntuacion semanal\n4.Ver puntuacion total\n5. Ver ranking semanal\n6. Ver ranking general\n7. Salir");
            String name;
            int opc = sc.nextInt();
            int opc2=0;
            int opc3=0;
            int opc4=0;
            int opc5=0;
            int opc6=0;
            int opc7 =0;
            int opc8=0;
            int opc9=0;
            int opc10=0;

            switch (opc) {
                case 1:
                    player.verMiEquipo();
                    break;

                case 2:
                    System.out.println("1. Vender\n2. Comprar ");
                    opc2= sc.nextInt();
                    while(opc2 < 1 || opc2 > 2) {
                        System.out.println("Opcion incorrecta, vuelve a intentarlo.");
                        opc2= sc.nextInt();
                    }
                    switch(opc2) {
                        case 1:
                            //Agregar atributo ID
                            player.verMiEquipo();
                            System.out.println("Ingrese el id del jugador que desea vender: \n");
                            opc3= sc.nextInt();
                            /*for (Jugador j:player.getEquipo())
                            {
                                if (name.equalsIgnoreCase(j.getNombre()))
                                {
                                    player.getEquipo().remove(j);
                                    player.setPresupuesto(player.getPresupuesto()+j.getPrecio());
                                }
                            }*/

                            player.borrar(opc3);
                            break;

                        case 2:
                            System.out.println("Elija el tipo de jugador que desea comprar: 1. Base\n2. Escolta\n3. Alero\n4. Ala-Pivot\n5. Pivot");
                            opc4 = sc.nextInt();
                            switch (opc4)
                            {
                                case 1:
                                    player.verJugadoresBases();
                                    System.out.println("Ingrese el id del jugador que desea comprar: ");
                                    opc5 = sc.nextInt();
                                    try {
                                        player.comprarJugadorBase(opc5);
                                    } catch (DineroInsuficienteException e) {
                                        throw new RuntimeException(e);
                                    } catch (EquipoCompletoException e) {
                                        throw new RuntimeException(e);
                                    } catch (JugadorRepetidoException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;

                                case 2:
                                    player.verJugadoresEscoltas();
                                    System.out.println("Ingrese el id del jugador que desea comprar: ");
                                    opc6 = sc.nextInt();
                                    try {
                                        player.comprarJugadorEscolta(opc6);
                                    } catch (DineroInsuficienteException e) {
                                        throw new RuntimeException(e);
                                    } catch (EquipoCompletoException e) {
                                        throw new RuntimeException(e);
                                    } catch (JugadorRepetidoException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;

                                case 3:
                                    player.verJugadoresAleros();
                                    System.out.println("Ingrese el id del jugador que desea comprar: ");
                                    opc7 = sc.nextInt();
                                    try {
                                        player.comprarJugadorAlero(opc7);
                                    } catch (DineroInsuficienteException e) {
                                        throw new RuntimeException(e);
                                    } catch (EquipoCompletoException e) {
                                        throw new RuntimeException(e);
                                    } catch (JugadorRepetidoException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;

                                case 4:
                                    player.verJugadoresAlaPivot();
                                    System.out.println("Ingrese el id del jugador que desea comprar: ");
                                    opc8 = sc.nextInt();
                                    try {
                                        player.comprarJugadorAla(opc8);
                                    } catch (DineroInsuficienteException e) {
                                        throw new RuntimeException(e);
                                    } catch (EquipoCompletoException e) {
                                        throw new RuntimeException(e);
                                    } catch (JugadorRepetidoException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;

                                case 5:
                                    player.verJugadoresPivot();
                                    System.out.println("Ingrese el id del jugador que desea comprar: ");
                                    opc9 = sc.nextInt();
                                    try {
                                        player.comprarJugadorPivot(opc9);
                                    } catch (DineroInsuficienteException e) {
                                        throw new RuntimeException(e);
                                    } catch (EquipoCompletoException e) {
                                        throw new RuntimeException(e);
                                    } catch (JugadorRepetidoException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;

                                default:
                                    System.out.println("Numero incorrecto vuelve a intentarlo.");
                                    break;

                            }
                            break;
                    }

                case 3:
                    System.out.println("Puntaje semanal: " + player.getPuntajeSemanal());

                    break;

                case 4:
                    System.out.println("Puntaje total: " + player.getPuntajeAcumulado());
                    break;

                case 5:
                    Admin.rankingSemanal();
                    break;

                case 6:
                    Admin.rankingGeneral();
                    break;

                case 7:
                    salir = true;
                    break;

                default:
                    System.out.println("Numero incorrecto vuelve a intentarlo.");
                    break;
            }
        }

    }
}
