package controle;

import DAO.FuncionarioDAO;
import java.util.Scanner;
import util.Conexao;

public class Main {

    public static void main(String[] args) {
        Conexao.getConexao();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Procurar Funcionário por ID");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    FuncionarioDAO.cadastrarFuncionario(ControleFuncionario.cadastrar());
                    break;
                case 2:
                    ControleFuncionario.listar();
                    break;
                case 3:
                    FuncionarioDAO.atualizarFuncionario(ControleFuncionario.atualizar());
                    break;
                case 4:
                    ControleFuncionario.procurarFuncionarioPorId();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
        System.out.println("Saindo...");
    }
}
