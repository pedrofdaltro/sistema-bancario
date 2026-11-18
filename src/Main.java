

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String [] nomes = new String[50];
        int[] numeros = new int[50];
        double[] saldos = new double[50];
        int quantidadeContas = 0;
        int opcao = 1;
        String nome;
        int numeroBusca;




        do{
            System.out.println("=========================");
            System.out.println("       BANCO GUTO     ");
            System.out.println("=========================");

            System.out.println("1 - Criar conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Consultar dados da conta");
            System.out.println("6 - Listar contas");
            System.out.println("0 - Sair");

            System.out.println("\nEscolha uma opção: ");
            opcao = sc.nextInt();


            if (opcao == 0){
                System.out.println("\nObrigado por utilizar o banco guto!");
            }
            else if((opcao > 6) || (opcao<0)){
                System.out.println("Essa opção não existe.");
            }
            else{
                switch (opcao){
                    case 1:
                        System.out.println(" BANCO GUTO ");
                        System.out.println("Você escolheu: Criar conta");

                        if(quantidadeContas >= 50){
                            System.out.println("Limite de contas aringido. ");
                        }
                        else{
                            sc.nextLine();

                            System.out.println("Digite o nome do titular: ");
                            nome = sc.nextLine();


                            nomes[quantidadeContas] = nome;
                            numeros[quantidadeContas] = quantidadeContas + 1;
                            saldos[quantidadeContas] = 0.0;

                            quantidadeContas++;

                            System.out.println("Conta criada com sucesso!");
                            System.out.println("\nNúmero da conta: " + numeros[quantidadeContas - 1] );
                            System.out.println("Titular: " + nome);
                            System.out.println("Saldo: R$ 0,00");
                        }
                        break;

                    case 2:
                        System.out.println(" BANCO GUTO ");
                        System.out.println("Você escolheu: Consultar saldo");
                        System.out.println("\nDigite o numero da conta: ");
                        numeroBusca = sc.nextInt();
                        boolean encontrado = false;

                        for(int i = 0; i<quantidadeContas; i++){
                           if(numeros[i] == numeroBusca){
                               System.out.println("Titular: " + nomes[i]);
                               System.out.println("Número da conta: "+ numeroBusca);
                               System.out.println("Saldo: R$ " + saldos[i]);
                               encontrado = true;
                           }
                        }
                        if(!encontrado){
                            System.out.println("Conta não encontrada.");
                        }
                        break;

                    case 3:
                        System.out.println("Você escolheu: Depositar");
                        break;

                    case 4:
                        System.out.println("Você escolheu: Sacar");
                        break;

                    case 5:
                        System.out.println("Você escolheu: Consultar dados da conta");
                        break;

                    case 6:
                        System.out.println("Listar contas");
                        break;
                }
            }
        } while(opcao != 0);

    }
}
