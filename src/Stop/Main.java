package Stop;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import Stop.model.Jogador;

public class Main 
{
    private static final int EASY_TIME_LIMIT = 30; // facil
    private static final int MEDIUM_TIME_LIMIT = 20; // medio
    private static final int HARD_TIME_LIMIT = 10; // dificil

    public static void main(String[] args) 
    {
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("Vamos cadastrar o jogador: ");
    	System.out.println("");
    	System.out.println("");
    	
    		
    	
    	Jogador jogador = new Jogador(Nome, Apelido, Nascimento, Sexo);
    	
        System.out.print("Informe o número de categorias para o stop: ");
        int numcat = scanner.nextInt();
        scanner.nextLine();

        String[] categorias = new String[numcat];
        for (int i = 0; i < numcat; i++) 
        {
            System.out.print("Insira o nome da categoria: ");
            String nomeCategoria = scanner.nextLine();
            categorias[i] = nomeCategoria;
        }

        Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'A');
        System.out.println("O stop é: " + letra);

        String[] respostas = new String[numcat];
        Timer timer = new Timer();
        TimerTask task = new TimerTask() 
        {
            int timeLimit = getTimeLimit(numcat);

            @Override
            public void run() 
            {
                if (timeLimit > 0) 
                {
                    System.out.println("Tempo restante: " + timeLimit + " segundos");
                    timeLimit--;
                } 
                else 
                {
                    System.out.println("Tempo esgotado!");
                    timer.cancel();
                    scanner.close();
                    System.exit(0);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);

        for (int j = 0; j < numcat; j++) 
        {
            System.out.print(categorias[j] + ": ");
            String resposta = scanner.nextLine();
            respostas[j] = resposta;
        }

        timer.cancel();
        scanner.close();
        System.out.print("Preencheu todas as categorias e quer dar stop? 1- Sim\n 2- Não\n");
        int x = scanner.nextInt();

        if (x == 1) 
        {
            System.out.print("Stop!");
        } 
        else 
        {
            System.out.print("Perdeu!");
        }
    }

    private static int getTimeLimit(int numcat) 
    {
        int timeLimit;
        if (numcat <= 3) 
        {
            timeLimit = EASY_TIME_LIMIT;
        } 
        else if (numcat <= 6) 
        {
            timeLimit = MEDIUM_TIME_LIMIT;
        }
        else 
        {
            timeLimit = HARD_TIME_LIMIT;
        }
        return timeLimit;
    }
    
    private static String cadastroJogador(String nome, String apelido, String nascimento, String sexo)
    {
    	System.out.println("Informe o Nome do jogador: ");
    	
    	Scanner scanner = new Scanner(System.in);
    	nome = scanner.nextLine();
    	
    	System.out.println("Informe o Apelido do jogador: ");
    	apelido = scanner.nextLine();
    	
    	System.out.println("Informe a Data de Nascimento (dd/mm/aa): ");
    	nascimento = scanner.nextLine();
    	
    	System.out.println("Informe o Sexo (Masculino, Feminino, Outro): ");
    	sexo = scanner.nextLine();
    }
}
