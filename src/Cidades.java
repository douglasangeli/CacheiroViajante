import java.util.Random;

public class Cidades {
    public static final String CIDADES = "ABCDEFGH";

    private static int[][] distancias = new int[][]
            {
                    {0, 10, 153, 42, 37, 920, 410, 13},
                    {10, 0, 8, 27, 93, 45, 21, 18},
                    {153, 8, 0, 3, 21, 97, 410, 38},
                    {42, 27, 3, 0, 22, 45, 81, 6},
                    {37, 93, 21, 22, 0, 19, 80, 13},
                    {920, 45, 97, 45, 19, 0, 18, 23},
                    {410, 21, 410, 81, 80, 18, 0, 5},
                    {13, 18, 38, 6, 13, 23, 5, 0}
            };


    public static int indexByChar(char c) {
        return CIDADES.indexOf(c);
    }

    public static char charByIndex(int i) {
        return CIDADES.charAt(i);
    }

    public static int getDistancia(char origem, char destino) {
        int i = indexByChar(origem);
        int j = indexByChar(destino);

        return distancias[i][j];
    }

    public static int getDistanciaTotal(String percurso) {

        int distanciaTotal = 0;

        for (int i = 0; i < percurso.length(); i++) {

            char destino = (i < percurso.length() - 1) ? percurso.charAt(i + 1) : percurso.charAt(0);

            int distancia = Cidades.getDistancia(percurso.charAt(i), destino);

            distanciaTotal += distancia;
        }

        return distanciaTotal;
    }

    public static String getPercursoAleatorio() {
        String percurso = "";
        do {

            Random r = new Random();
            int i = r.nextInt(CIDADES.length());
            String cidadeSorteada = CIDADES.charAt(i) + "";

            if (!percurso.contains(cidadeSorteada)) {
                percurso += cidadeSorteada;
            }

        } while (percurso.length() < CIDADES.length());
        return percurso;
    }
}
