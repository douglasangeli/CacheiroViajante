public class Cromossomo implements Comparable<Cromossomo> {

    private String genes;

    public Cromossomo() {
        this(Cidades.getPercursoAleatorio());
    }

    public Cromossomo(String percurso) {
        this.genes = percurso;
    }

    @Override
    public String toString() {
        return this.genes + this.genes.charAt(0) + " distancia: " + this.getAptidao();
    }

    public int getAptidao() {
        return Cidades.getDistanciaTotal(this.genes);
    }

    public String getGenes() {
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
