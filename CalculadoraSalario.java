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

        public class SistemaSalarios {

            public static void main(String[] args) {
                Scanner sc = new Scanner (System.in);
                ArrayList<Colaborador> colaboradores = new ArrayList<>();

                int contador = 0;
                while (contador < 3) {

                    System.out.println("\nCadastro do colaborador " + (contador + 1));
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
                    System.out.println("3 - Funcionario de produção");
                    System.out.print("Escolha: ");
                    int opcao = sc.nextInt();

                    if (opcao < 1 || opcao > 3) {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                    }
    
                    double salarioFinal = salarioBase;
                    String tipo = "";

                    switch (opcao) {
                    case 1:
                        tipo = "Funcionário padrão";
                        salarioFinal = salarioBase;
                        break;

                        case 2:
                            tipo = "Funcionário comissionado";

                            System.out.print("Valor total de vendas no mês: ");
                            double vendas = sc.nextDouble();

                            System.out.print("Percentual de comissão (%): ");
                            double percentual = sc.nextDouble();

                            double comissao = vendas * (percentual / 100);
                            salarioFinal = salarioBase + comissao;
                            break;

                            case 3:
                                tipo = "Funcionário de produção";

                                System.out.print("Valor por peça produzida: ");
                                int valorPeca = sc.nextInt();

                                System.out.print("Quantidade de peças produzidas: ");
                                int quantidade = sc.nextInt();

                                double bonus = valorPeca * quantidade / 100;
                            salarioFinal = salarioBase + bonus;
                            break;

                            default:
                                System.out.println("Opção inválida!");
                }

                Colaborador c = new Colaborador(registro, nome, tipo, salarioBase, salarioFinal);
                colaboradores.add(c);

                contador++;
            }
            System.out.println("\n--- Relatório de Colaboradores ---");

            for (Colaborador c : colaboradores) {
                c.mostrarDados();
            }
                    sc.close();
                }
            }
        }