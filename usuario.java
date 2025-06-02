public class Usuario {
    private String nome;
    private int acertos;
    private int erros;

    public Usuario(String nome) {
        this.nome = nome;
        this.acertos = 0;
        this.erros = 0;
    }

    public void acertou() {
        acertos++;
    }

    public void errou() {
        erros++;
    }

    public String getNome() {
        return nome;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }
}
