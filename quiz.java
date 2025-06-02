import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Pergunta> perguntas;
    private Usuario usuario;
    private Scanner scanner;

    public Quiz(Usuario usuario) {
        this.usuario = usuario;
        this.perguntas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        carregarPerguntas();
    }

    public void iniciar() {
        System.out.println("\n🎯 Bem-vindo(a) ao Quiz de Java, " + usuario.getNome() + "!");
        System.out.println("📚 As perguntas são sorteadas dos capítulos do livro.\n");

        Collections.shuffle(perguntas); // Sorteia a ordem das perguntas

        for (Pergunta pergunta : perguntas) {
            pergunta.exibirPergunta();
            System.out.print("Sua resposta (A, B, C ou D): ");
            char respostaUsuario = scanner.nextLine().toUpperCase().charAt(0);

            if (pergunta.verificarResposta(respostaUsuario)) {
                System.out.println("✔️ Correto!\n");
                usuario.acertou();
            } else {
                System.out.println("❌ Incorreto! Resposta correta: " + pergunta.getRespostaCorreta() + "\n");
                usuario.errou();

                if (usuario.getErros() >= 4) {
                    System.out.println("😅 PERDEU, PLAYBOY!");
                    mostrarResultado();
                    return;
                }
            }
        }

        mostrarResultado();
    }

    private void mostrarResultado() {
        int total = perguntas.size();
        double percentual = (usuario.getAcertos() * 100.0) / total;

        System.out.println("✅ Quiz finalizado!");
        System.out.println("🎯 Total de acertos: " + usuario.getAcertos() + " de " + total);
        System.out.printf("📊 Aproveitamento: %.2f%%\n", percentual);
    }

    private void carregarPerguntas() {
        perguntas.add(new Pergunta(
                "O que é uma classe em Java?",
                new String[]{"A) Um tipo de variável.", "B) Um arquivo de configuração.", "C) Um modelo para criar objetos.", "D) Um componente da interface gráfica."},
                'C',
                "Capítulo 2 - Classes e Objetos"
        ));

        perguntas.add(new Pergunta(
                "Qual é a principal função do padrão Observer?",
                new String[]{"A) Permitir que uma classe tenha múltiplos construtores.", "B) Notificar múltiplos objetos quando o estado de outro muda.", "C) Manter classes pequenas e rápidas.", "D) Criar GUIs com mais facilidade."},
                'B',
                "Capítulo 10 - Padrões de Projeto"
        ));

        perguntas.add(new Pergunta(
                "O que faz a palavra-chave synchronized em Java?",
                new String[]{"A) Cria um loop automático.", "B) Garante que apenas uma thread acesse um bloco de código por vez.", "C) Inicia uma nova thread.", "D) Define uma variável como final."},
                'B',
                "Capítulo 11 - Concorrência e Threads"
        ));

        perguntas.add(new Pergunta(
                "O que é encapsulamento?",
                new String[]{"A) Ocultar a estrutura do banco de dados.", "B) Dividir o programa em arquivos menores.", "C) Proteger os dados internos de uma classe, acessando-os apenas por métodos.", "D) Comprimir os arquivos .class."},
                'C',
                "Capítulo 4 - Encapsulamento"
        ));

        perguntas.add(new Pergunta(
                "O que significa herança em Java?",
                new String[]{"A) Um método herdado de outra classe.", "B) Uma classe pode adquirir comportamentos e atributos de outra.", "C) Compartilhar variáveis com todos os métodos.", "D) Repetir código dentro da mesma classe."},
                'B',
                "Capítulo 5 - Herança"
        ));

        perguntas.add(new Pergunta(
                "O que acontece quando usamos == para comparar objetos em Java?",
                new String[]{"A) Compara se os objetos são do mesmo tipo.", "B) Compara o conteúdo dos objetos.", "C) Compara se duas variáveis referem-se ao mesmo objeto.", "D) Cria uma nova cópia do objeto."},
                'C',
                "Capítulo 6 - Comparação de Objetos"
        ));

        perguntas.add(new Pergunta(
                "Qual é a principal diferença entre uma interface e uma classe abstrata?",
                new String[]{"A) Interfaces não podem ter métodos.", "B) Interfaces não suportam herança.", "C) Classes abstratas podem ter implementações; interfaces não (antes do Java 8).", "D) Interfaces só existem em bibliotecas externas."},
                'C',
                "Capítulo 7 - Interfaces e Classes Abstratas"
        ));

        perguntas.add(new Pergunta(
                "Qual é a principal vantagem do polimorfismo?",
                new String[]{"A) Executar métodos mais rapidamente.", "B) Permitir que um objeto se comporte como vários tipos.", "C) Criar classes mais curtas.", "D) Eliminar a necessidade de interfaces."},
                'B',
                "Capítulo 8 - Polimorfismo"
        ));

        perguntas.add(new Pergunta(
                "Qual afirmação sobre Threads em Java está correta?",
                new String[]{"A) Uma thread sempre bloqueia o programa principal.", "B) Threads só funcionam com métodos estáticos.", "C) Threads permitem execução concorrente de tarefas.", "D) Threads precisam de um construtor público."},
                'C',
                "Capítulo 11 - Concorrência e Threads"
        ));

        perguntas.add(new Pergunta(
                "O que é o Garbage Collector em Java?",
                new String[]{"A) Um coletor de arquivos temporários.", "B) Um algoritmo de ordenação.", "C) Um processo que remove objetos não utilizados da memória.", "D) Uma função para limpar variáveis locais."},
                'C',
                "Capítulo 9 - Gerenciamento de Memória"
        ));

        perguntas.add(new Pergunta(
                "Qual a função do método main em Java?",
                new String[]{"A) Inicializar variáveis globais.", "B) Criar a interface do usuário.", "C) Ser o ponto de entrada do programa.", "D) Compilar o código."},
                'C',
                "Capítulo 1 - Introdução ao Java"
        ));

        perguntas.add(new Pergunta(
                "Qual é a função da palavra-chave new em Java?",
                new String[]{"A) Declarar um novo método.", "B) Criar uma nova variável primitiva.", "C) Instanciar um novo objeto.", "D) Iniciar um loop."},
                'C',
                "Capítulo 2 - Classes e Objetos"
        ));
    }
}
