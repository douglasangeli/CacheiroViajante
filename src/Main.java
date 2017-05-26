/*
 * Created by: Douglas Gabriel Angeli
 *
 */
public class Main {

    /**
     * Contante que define quantas populacoes podem ser tentadas ate que o algoritmo "desista"
     */
    public static final int LIMITE_POPULACIONAL = 5000;
    public static final int LIMITE_POPULACOES_SEM_MELHORA = 250;

    public static void main(String[] args) {

        Populacao populacao = new Populacao();

        int counter = 1;
        int menorDistancia = 100000;
        int geracoesSemMelhora = 0;

        Cromossomo melhorCromossomo;

        while (counter <= LIMITE_POPULACIONAL) {

            melhorCromossomo = populacao.getMelhorCromossomo();

            int aptidao = melhorCromossomo.getAptidao();

            if (aptidao < menorDistancia) {
                menorDistancia = aptidao;
                geracoesSemMelhora = 0;
            } else {
                geracoesSemMelhora++;
            }

            System.out.print("População " + counter);

            if (geracoesSemMelhora > LIMITE_POPULACOES_SEM_MELHORA) {
                System.out.println(" Cromossomo mais APTO -> " + melhorCromossomo.toString());
                break;
            } else {
                System.out.println(" INAPTA!");

                populacao.geraNovaPopulacao();
                counter++;
            }
        }
    }

}