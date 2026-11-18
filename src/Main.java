

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String [] nomes = new String[50];
        String nome;
        int[] numeros = new int[50];
        int quantidadeContas = 0;
        int opcao = 1;
        int numeroBusca;
        double[] saldos = new double[50];
        double valorDeposito;
        double valorSaque;


        do{
            exibirMenu();

            System.out.println("\nEscolha uma opção: ");
            opcao = sc.nextInt();


            if (opcao == 0){
                System.out.println("\nObrigado por utilizar o JAVA BANK");
            }
            else if((opcao > 6) || (opcao<0)){
                System.out.println("Essa opção não existe.");
            }
            else{
                switch (opcao){
                    case 1:
                        quantidadeContas = criarConta(sc, nomes, numeros, saldos, quantidadeContas);
                        break;

                    case 2:
                        consultarSaldo(sc, nomes, numeros, saldos, quantidadeContas);
                        break;

                    case 3:
                        depositar(sc, numeros, saldos, quantidadeContas);
                        break;

                    case 4:
                        sacar(sc, numeros, saldos, quantidadeContas);
                        break;

                    case 5:
                        consultarDados(sc, nomes, numeros, saldos, quantidadeContas);
                        break;

                    case 6:
                        listarContas(nomes, numeros, saldos, quantidadeContas);
                        break;
                }
            }
        } while(opcao != 0);
        sc.close();
    }



    public static void exibirMenu(){
        System.out.println("=========================");
        System.out.println("       JAVA BANK     ");
        System.out.println("=========================");

        System.out.println("1 - Criar conta");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Consultar dados da conta");
        System.out.println("6 - Listar contas");
        System.out.println("0 - Sair");

    }
    public static int criarConta(Scanner sc, String nomes[], int numeros[], double saldos[], int quantidadeContas){

        String nome;
        System.out.println("   JAVA BANK ");
        System.out.println("Você escolheu: Criar conta");

        if(quantidadeContas >= 50){
            System.out.println("Limite de contas aringido. ");
        }
        else{
            sc.nextLine();

            System.out.println("Digite o nome do titular: ");
            nome = sc.nextLine();

            if(nome.trim().isEmpty()){
                System.out.println("Nome inválido! Digite um nome válido.");
            }
            else{
                nomes[quantidadeContas] = nome;
                numeros[quantidadeContas] = quantidadeContas + 1;
                saldos[quantidadeContas] = 0.0;

                quantidadeContas++;

                System.out.println("Conta criada com sucesso!");
                System.out.println("\nNúmero da conta: " + numeros[quantidadeContas - 1] );
                System.out.println("Titular: " + nome);
                System.out.println("Saldo: R$ 0,00");
            }
        }
        return quantidadeContas;
    }

    public static void consultarSaldo(Scanner sc, String[] nomes, int[] numeros, double[] saldos, int quantidadeContas){

        System.out.println(" JAVA BANK ");
        System.out.println("Você escolheu: Consultar saldo");
        System.out.println("\nDigite o numero da conta: ");
        int numeroBusca = sc.nextInt();
        boolean encontrado = false;

        for(int i = 0; i<quantidadeContas; i++){
            if(numeros[i] == numeroBusca){
                System.out.println("Titular: " + nomes[i]);
                System.out.println("Número da conta: "+ numeroBusca);
                System.out.printf("\nSaldo: R$ %.2f%n", saldos[i]);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Conta não encontrada.");
        }

    }

    public static void depositar(Scanner sc, int[] numeros, double[] saldos, int quantidadeContas){

        int numeroBusca;
        double valorDeposito;
        boolean encontrado = false;

        System.out.println("    JAVA BANK    ");
        System.out.println("Você escolheu: Depositar");
        System.out.println("Digite o número da conta: ");
        numeroBusca = sc.nextInt();

        for (int i = 0; i<quantidadeContas; i++){
            if(numeros[i] == numeroBusca){
                System.out.println("Digite o valor do depósito: ");
                valorDeposito = sc.nextDouble();
                encontrado = true;
                if((valorDeposito > 0)){
                    saldos[i] += valorDeposito;
                    System.out.println("Depósito realizado com sucesso! ");
                    System.out.printf("Saldo atualizado: R$ %.2f%n", saldos[i]);
                }
                else{
                    System.out.println("Digite um valor válido.");
                }
            }
        }
        if(!encontrado){
            System.out.println("Conta não encontrada.");
        }

    }

    public static void sacar(Scanner sc, int[] numeros, double[] saldos, int quantidadeContas){

        int numeroBusca;
        double valorSaque;
        boolean encontrado = false;

        System.out.println("   JAVA BANK    ");
        System.out.println("Você escolheu: Sacar");
        System.out.println("Digite o número da conta: ");
        numeroBusca = sc.nextInt();


        for(int i = 0; i<quantidadeContas; i++){
            if(numeros[i] == numeroBusca){
                System.out.println("Digite o valor do saque: ");
                valorSaque = sc.nextDouble();
                encontrado = true;
                if((valorSaque <= saldos[i]) && (valorSaque > 0)){
                    saldos[i] -= valorSaque;
                    System.out.println("Saque realizado com sucesso!");
                    System.out.printf("Saldo atualizado: R$ %.2f%n", saldos[i]);
                }
                else{
                    System.out.println("Valor inválido ou Saldo insuficiente.");
                }
            }
        }
        if(!encontrado){
            System.out.println("Conta não encontrada.");
        }
    }

    public static void consultarDados(Scanner sc, String[] nomes, int[] numeros, double[] saldos, int quantidadeContas){

        int numeroBusca;
        boolean encontrado = false;

        System.out.println("    JAVA BANK    ");
        System.out.println("Você escolheu: Consultar dados da conta");
        System.out.println("Digite o número da conta: ");
        numeroBusca = sc.nextInt();

        for(int i = 0; i<quantidadeContas; i++){
            if(numeros[i] == numeroBusca){
                System.out.println("Titular da conta: " + nomes[i]);
                System.out.println("Número da conta: " + numeros[i]);
                System.out.printf("Saldo atual: R$ %.2f%n ", saldos[i]);
                encontrado = true;
            }

        }
        if(!encontrado){
            System.out.println("Conta não encontrada.");
        }
    }

    public static void listarContas(String[] nomes, int numeros[], double[] saldos, int quantidadeContas){
        System.out.println("Listar contas");
        if (quantidadeContas > 0){
            for(int i = 0; i < quantidadeContas; i++){
                System.out.println("\nConta: " + numeros[i]);
                System.out.println("Titular da conta: " + nomes[i]);
                System.out.printf("Saldo: R$ %.2f%n ", saldos[i]);


                System.out.println("\n-----------------------------");

            }

        }
        else{
            System.out.println("Ainda não existem contas cadastradas.");
        }
    }
}
