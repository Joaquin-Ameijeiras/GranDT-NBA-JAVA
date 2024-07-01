import java.net.PortUnreachableException;

public class PersonaNoEncontradaException extends Exception{

    public PersonaNoEncontradaException(String mensaje)
    {
        super(mensaje);
    }


}