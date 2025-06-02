public class Pergunta {
    private String enunciado;
    private String[] alternativas;
    private char respostaCorreta;
    private String capitulo;

    public Pergunta(String enunciado, String[] alternativas, char respostaCorreta, String capitulo) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
        this.capitulo = capitulo;
    }

    public void exibirPergunta() {
        System.out.println("\n📖 " + enunciado + " (Capítulo: " + capitulo + ")");
        for (String alternativa : alternativas) {
            System.out.println(alternativa);
        }
    }

    public boolean verificarResposta(char respostaUsuario) {
        return Character.toUpperCase(respostaUsuario) == respostaCorreta;
    }

    public char getRespostaCorreta() {
        return respostaCorreta;
    }

    public String getCapitulo() {
        return capitulo;
    }
}
