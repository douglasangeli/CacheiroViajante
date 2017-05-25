
public class Main {

    /**
     * Contante que define quantas populacoes podem ser tentadas ate que o algoritmo "desista"
     */
    public static final int LIMITE_POPULACIONAL = 500;

    public static void main(String[] args) {

//        String percurso = Cidades.getPercursoAleatorio();
//        System.out.println(percurso);
//        System.out.println(Cidades.getDistanciaTotal(percurso));

        System.out.println("Incializar a populacao...");
        Populacao populacao = new Populacao();

        int counter = 1;
        Cromossomo melhorCromossomo;

        while (counter <= LIMITE_POPULACIONAL) {

            melhorCromossomo = populacao.getMelhorCromossomo();

            System.out.print("População " + counter);

            int aptidao = melhorCromossomo.getAptidao();

            if (aptidao < 100) {
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