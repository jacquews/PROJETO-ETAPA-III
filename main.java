import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🚀 Bem-vindo ao QUIZ JAVA!");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        Usuario usuario = new Usuario(nome);
        Quiz quiz = new Quiz(usuario);

        quiz.iniciar();
    }
}
