import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ComunicacionJson {

    private String MapaJugadoresJson;

    public ComunicacionJson() {
        {

        }}
    public static void guardarMapaToJson(MapaJugadores mapa,String archivo)  {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(archivo);
        try {
            mapper.writeValue(file,mapa);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }


    }


    public static MapaJugadores cargarMapaFromJson(String archivo)  {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(archivo);
        try {
            return mapper.readValue(file,MapaJugadores.class);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static <T extends Usuario> void guardarListToJson(ArrayList<T> arrayList,String archivo)
    {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(archivo);
        try {
            mapper.writeValue(file,arrayList);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public static <T extends Usuario> ArrayList<T> cargarListFromJson(String archivo, Class<T> clase)
    {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> users = new ArrayList<>();
        File file = new File(archivo);
        try {
//           users=mapper.readValue(file, new TypeReference<ArrayList<T>>() {});
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            users = mapper.readValue(file,mapper.getTypeFactory().constructCollectionType(ArrayList.class, clase));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return users;

    }

    public static void guardarAdminToJson(Admin admin, String archivo)
    {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(archivo);

        try {
            mapper.writeValue(file,admin);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Admin cargarClaseFromJson(String archivo)
    {
        ObjectMapper mapper = new ObjectMapper();
        Admin admin = new Admin();
        File file = new File(archivo);

        try {
            admin = mapper.readValue(file,Admin.class);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return admin;
    }
}

