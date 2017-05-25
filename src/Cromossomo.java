import java.util.ArrayList;
import java.util.Arrays;

public class Cromossomo implements Comparable<Cromossomo> {

    private ArrayList<Character> genes;

    public Cromossomo() {
        this(Cidades.getPercursoAleatorio());
    }

    public Cromossomo(String percurso) {
        this.genes = new ArrayList(Arrays.asList(percurso.toCharArray()));
    }

    @Override
    public String toString() {
        return getStringRepresentation() + " distancia: " + this.getAptidao();
    }

    public String getStringRepresentation() {
        StringBuilder builder = new StringBuilder(this.genes.size());
        for (Object ch : (ArrayList)this.genes) {
            builder.append(ch);
        }
        return builder.toString();
    }

    public int getAptidao() {
        return Cidades.getDistanciaTotal(getStringRepresentation());
    }

    public ArrayList<Character> getGenes() {
        return genes;
    }

    @Override
    public int compareTo(Cromossomo o) {
        if (this.getAptidao() > o.getAptidao()) {
            return 1;
        } else if (this.getAptidao() < o.getAptidao()) {
            return -1;
        }
        return 0;
    }
}
