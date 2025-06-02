public class Resposta {
    private char opcao;

    public Resposta(char opcao) {
        this.opcao = Character.toUpperCase(opcao);
    }

    public char getOpcao() {
        return opcao;
    }
}
