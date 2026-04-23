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

    public int getRegistro() {
        return registro;

    }

                public void mostrarDados() {
                System.out.println("Registro: " + registro);
                System.out.println("Nome: " + nome);
                System.out.println("Tipo: " + tipo);
                System.out.println("Salário Final: R$ " + String.format("%.2f", salarioFinal));
                System.out.println("-----------------------------");
                }
            }
        
        public class SistemaSalarios {

    private ArrayList<Colaborador> colaboradores = new ArrayList<>();

    public void cadastrarColaborador(Scanner sc) {

        System.out.println("\n=== Cadastro de Colaborador ===");

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
            return;
        }

        double salarioFinal = salarioBase;
        String tipo = "";

        switch (opcao) {
            case 1:
                tipo = "Funcionário padrão";
                break;

            case 2:
                tipo = "Funcionário comissionado";

                System.out.print("Valor de vendas: ");
                double vendas = sc.nextDouble();

                System.out.print("Percentual (%): ");
                double percentual = sc.nextDouble();

                salarioFinal += vendas * (percentual / 100);
                break;

            case 3:
                tipo = "Funcionário de produção";

                System.out.print("Valor por peça: ");
                double valorPeca = sc.nextDouble();

                System.out.print("Quantidade produzida: ");
                int quantidade = sc.nextInt();

                salarioFinal += valorPeca * quantidade;
                break;
        }

        Colaborador c = new Colaborador(registro, nome, tipo, salarioBase, salarioFinal);
        colaboradores.add(c);

        System.out.println("✔ Colaborador cadastrado com sucesso!");
    }

    public void listarColaboradores() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        System.out.println("\n=== LISTA DE COLABORADORES ===");

        for (Colaborador c : colaboradores) {
            c.mostrarDados();
        }
    }

    public void buscarColaborador(int registro) {
        for (Colaborador c : colaboradores) {
            if (c.getRegistro() == registro) {
                System.out.println("\nColaborador encontrado:");
                c.mostrarDados();
                return;
            }
        }

        System.out.println("Colaborador não encontrado.");
    }
}

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaSalarios sistema = new SistemaSalarios();

        int opcao;

        do {
            System.out.println("\n=================================");
            System.out.println("   SISTEMA DE GESTÃO SALARIAL   ");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar colaborador");
            System.out.println("2 - Listar colaboradores");
            System.out.println("3 - Buscar colaborador");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    sistema.cadastrarColaborador(sc);
                    break;

                case 2:
                    sistema.listarColaboradores();
                    break;

                case 3:
                    System.out.print("Digite o registro: ");
                    int registro = sc.nextInt();
                    sistema.buscarColaborador(registro);
                    break;

                case 4:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        sc.close();
    }
}