public enum Equipos {

    Hawks("Atlanta Hawks"),Celtics("Boston Celtics"),Nets("Brooklyn nets"),Hornets("Charlotte Hornets"),
    Bulls("Chicago Bulls"),Cavaliers("Cleveland Cavaliers"),Pistons("Detroit Pistons"),Pacers("Indiana Pacers"),
    Heat("Miami Heat"),Bucks("Milwaukee bucks"),Knicks("New York Knicks"),Magic("Orlando Magic"),Sixers("Philadelphia 76ers"),
    Raptors("Toronto Raptors"),Wizards("Washington Wizards"),Mavericks("Dallas Mavericks"),Nuggets("Denver Nuggets"),
    Warriors("Golden State Warriors"),Rockets("Houston Rockets"),Clippers("Los Angeles Clippers"),Lakers("Los Angeles Lakers"),
    Grizzlies("Memphis Grizzlies"),Timberwolves("Minnesota Timberwolves"),Pelicans("New Orleans Pelicans"),
    Thunder("Oklahoma City Thunder"),Suns("Phoenix Suns"),Blazers("Portland Trail Blazers"),Kings("Sacramento Kings"),
    Spurs("San Antonio Spurs"),Jazz("Utah Jazz");

    private final String equipo;

    private Equipos(String equipo) {
        this.equipo = equipo;
    }

    public String getEquipo()
    {
        return equipo;
    }

    public static Equipos fromString(String descripcion) {
        for (Equipos equipo : Equipos.values()) {
            if (equipo.equipo.equalsIgnoreCase(descripcion)) {
                return equipo;
            }
        }
        throw new IllegalArgumentException("Equipo no válido: " + descripcion);
    }
}

