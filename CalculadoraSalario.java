import java.util.ArrayList;
import java.util.Scanner;

class Colaborador {
    int registro;
    String nome;
    String tipo;
    double salarioBase;
    double salarioFinal;

    public Colaborador(int registro, String nome, String tipo, double salarioBase, double salarioFinal) {
        this.registro = registro;
        this.nome = nome;
        this.tipo = tipo;
        this.salarioBase = salarioBase;
        this.salarioFinal = salarioFinal;
    }

                public void mostrarDados() {
                System.out.println("Registro: " + registro);
                System.out.println("Nome: " + nome);
                System.out.println("Tipo: " + tipo);
                System.out.println("Salário Final: R$ " + String.format("%.2f", salarioFinal));
                System.out.println("-----------------------------");
                }
            }
        
        class SistemaSalarios {

            public static void main(String[] args) {
                Scanner sc = new Scanner (System.in);
                ArrayList<Colaborador> colaboradores = new ArrayList<>();

                int opcaoMenu;

do {
    System.out.println("\n MENU PRINCIPAL");
    System.out.println("1 - Cadastrar colaborador");
    System.out.println("2 - Listar colaboradores");
    System.out.println("3 - Buscar colaborador");
    System.out.println("4 - Sair");
    System.out.print("Escolha: ");

    opcaoMenu = sc.nextInt();

    switch (opcaoMenu) {

        case 1:
            // CADASTRAR
            System.out.println("\nCadastro do colaborador");

            System.out.print("Número de registro: ");
            int registro = sc.nextInt();
            sc.nextLine();

            System.out.print("Nome completo: ");
            String nome = sc.nextLine();

            double salarioBase = 2000.0;
            System.out.println("Salário base fixo: R$ 2000.00");

            System.out.println("\nTipo de colaborador:");
            System.out.println("1 - Funcionário padrão");
            System.out.println("2 - Funcionário comissionado");
            System.out.println("3 - Funcionário de produção");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();

            if (opcao < 1 || opcao > 3) {
                System.out.println("Opção inválida!");
                break;
            }

            double salarioFinal = salarioBase;
            String tipo = "";

            switch (opcao) {
                case 1:
                    tipo = "Funcionário padrão";
                    break;

                case 2:
                    tipo = "Funcionário comissionado";

                    System.out.print("Vendas: ");
                    double vendas = sc.nextDouble();

                    System.out.print("Percentual (%): ");
                    double percentual = sc.nextDouble();

                    salarioFinal += vendas * (percentual / 100);
                    break;

                case 3:
                    tipo = "Funcionário de produção";

                    System.out.print("Valor por peça: ");
                    double valorPeca = sc.nextDouble();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    salarioFinal += valorPeca * quantidade;
                    break;
            }

            Colaborador c = new Colaborador(registro, nome, tipo, salarioBase, salarioFinal);
            colaboradores.add(c);

            System.out.println("Colaborador Cadastrado com sucesso!");
            break;

        case 2:
            // LISTAR
            if (colaboradores.isEmpty()) {
                System.out.println("Nenhum colaborador cadastrado.");
            } else {
                System.out.println("\n--- LISTA ---");
                for (Colaborador col : colaboradores) {
                    col.mostrarDados();
                }
            }
            break;

        case 3:
            // BUSCAR
            System.out.print("Digite o registro: ");
            int busca = sc.nextInt();

            boolean encontrado = false;

            for (Colaborador col : colaboradores) {
                if (col.registro == busca) {
                    col.mostrarDados();
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Colaborador não encontrado.");
            }
            break;

        case 4:
            System.out.println("Encerrando sistema...");
            break;

        default:
            System.out.println("Opção inválida!");
    }

} while (opcaoMenu != 4);

                        sc.close();
                    }
            }