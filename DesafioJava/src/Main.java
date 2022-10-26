public class Main{

    private static final String LETTERS = "acdegilmnoprstuw";
    private static final int HASH = 7;
    private static final int FACTOR = 37;

    //Encontre uma palavra de 7 letras que contenha apenas as letras ‘acdegilmnoprstuw’ de forma que
    //hash(string) é 695527946727. Onde o hash é definido pelo seguinte código:

    public static void main(String[] args) {
        System.out.println("Valor recuperado do hash: " + removeHash(695527946727l));
        // System.out.println("Obter o hash: " + getHash("segredo"));
    }

    public static String removeHash(long hashToDecod) {
        String hashDecoded = "";

        while (hashToDecod > HASH) { //enquanto o numero hashToDecod for maior do que 7 (numero em que iniciou o hash) tire o hash
            int restDivision = (int) (hashToDecod % FACTOR); //faz o inverso do hash, ao inves de multiplicar:
                                                            // divide o hash por 37 e pega o que sobrou/restante
            char setPosition = LETTERS.charAt(restDivision);

            hashDecoded =  setPosition + hashDecoded;

            hashToDecod = hashToDecod / FACTOR;
        }
        return hashDecoded;

        //% resto da divisao
        //695527946727 / 37 = 18798052614
        //695527946727 % 37 = 9
        //18798052614 / 37 = 508055476
        //18798052614 % 37 = 2
    }

    private static long getHash(String word) {
        long hash = HASH; //inicia com 7
        int wordSize = word.length(); //pegar tamanho da palavra

        for (int letterPosition = 0; letterPosition < wordSize; letterPosition++) { // percorrer letra por letra

            char letter = word.charAt(letterPosition); //pega letra a partir da posicao do for
            int setPosition = LETTERS.indexOf(letter); //pega a posicao da letra no LETTERS,
            // ou seja, busca em que index/lugar está a letra em "acdegilmnoprstuw"

            //regra do hash: hash que inicia com 7 * 37 + pega a posicao da letra no LETTERS
            hash = hash * FACTOR + setPosition;
        }
        return hash;
    }
}