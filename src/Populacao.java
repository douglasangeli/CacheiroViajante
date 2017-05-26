import java.util.*;

public class Populacao {

    private int tamanho = 5;
    private ArrayList<Cromossomo> cromossomos;

    public Populacao() {
        this.cromossomos = new ArrayList<>();

        for (int i = 0; i < tamanho; i++) {
            this.cromossomos.add(new Cromossomo());
        }
    }

    @Override
    public String toString() {
        String retorno = "";

        if(this.cromossomos == null){
            return  retorno;
        }

        for (Cromossomo item : this.cromossomos) {
            retorno += item + "\n";
        }

        return retorno;
    }

    public Cromossomo getMelhorCromossomo() {
        Collections.sort(this.cromossomos);
        return this.cromossomos.get(0);
    }

    private ArrayList<Cromossomo> crossover(Cromossomo pai, Cromossomo mae) {

        ArrayList<Cromossomo> retorno = new ArrayList<>();
        String genesPai = pai.getGenes();
        String genesMae = mae.getGenes();
        String filho1 = "";
        String filho2 = "";

        //filho 1, primeira metade do pai e o resto da mae
        filho1 += genesPai.substring(0, 3);
        for (int i = 0; filho1.length() < genesPai.length(); i++) {
            String m = genesMae.charAt(i) + "";
            if (!filho1.contains(m)) {
                filho1 += m;
            }
        }

        //filho 2, primeira metade da mae e o resto do pai
        filho2 += genesMae.substring(0, 3);
        for (int i = 0; filho2.length() < genesMae.length(); i++) {
            String m = genesPai.charAt(i) + "";
            if (!filho2.contains(m)) {
                filho2 += m;
            }
        }

        // Faz mutacao trocando dois pontos randomicos
        Random rand = new Random();
        int pontoMutacao1 = rand.nextInt(genesPai.length());
        int pontoMutacao2 = rand.nextInt(genesPai.length());

        StringBuilder f1 = new StringBuilder(filho1);
        f1.setCharAt(pontoMutacao1, filho1.charAt(pontoMutacao2));
        f1.setCharAt(pontoMutacao2, filho1.charAt(pontoMutacao1));
        filho1 = f1.toString();

        StringBuilder f2 = new StringBuilder(filho2);
        f2.setCharAt(pontoMutacao1, filho2.charAt(pontoMutacao2));
        f2.setCharAt(pontoMutacao2, filho2.charAt(pontoMutacao1));
        filho2 = f2.toString();
        //
        retorno.add(new Cromossomo(filho1));
        retorno.add(new Cromossomo(filho2));
        return retorno;
    }

    public void geraNovaPopulacao() {

        ArrayList<Cromossomo> geracao = new ArrayList<>();

        // Pega melhor cromossomo e passa direto
        Collections.sort(this.cromossomos);

        geracao.add(this.cromossomos.get(0));

        // Pega os dois melhores e faz crossover
        geracao.addAll(this.crossover(this.cromossomos.get(0), this.cromossomos.get(1)));


        // Pega outros dois aleatoriamente e faz o crossover para completar
        Random rand = new Random();
        int pai = rand.nextInt(tamanho - 1) + 1;
        int mae = rand.nextInt(tamanho - 1) + 1;
        while (mae == pai) {
            mae = rand.nextInt(tamanho - 1) + 1;
        }

        geracao.addAll(this.crossover(this.cromossomos.get(pai), this.cromossomos.get(mae)));

        // Define a populacao com a nova geracao
        this.cromossomos = geracao;
    }
}
