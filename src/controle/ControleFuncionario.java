package controle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import modelo.Funcionario;
import DAO.FuncionarioDAO;

public class ControleFuncionario {

    private static final Scanner scanner = new Scanner(System.in);

    // Método para cadastrar um novo funcionário
    public static Funcionario cadastrar() {
        Funcionario funcionario = new Funcionario();

        System.out.println("Nome do funcionário: ");
        funcionario.setNome(scanner.nextLine());

        System.out.println("CPF do funcionário (Apenas números): ");
        funcionario.setCpf(scanner.nextLine());

        funcionario.setSituacao('A');
        funcionario.setDataAlteracao(LocalDateTime.now());

        return funcionario;
    }

    public static void procurarFuncionarioPorId() {
        System.out.println("Digite o ID do funcionário que deseja procurar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Funcionario funcionario = FuncionarioDAO.buscarFuncionarioPorId(id);

        if (funcionario != null) {
            System.out.println("ID: " + funcionario.getId_funcionario());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Situação(A - Ativo, I - Inativo): " + funcionario.getSituacao());
            System.out.println("Última modificação: " + funcionario.getDataAlteracao());
        } else {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
        }
    }

    // Método para listar todos os funcionários
    public static void listar() {
        List<Funcionario> funcionarios = FuncionarioDAO.listarFuncionarios();

        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId_funcionario());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Situação(A - Ativo, I - Inativo): " + funcionario.getSituacao());
            System.out.println("Última modificação: " + funcionario.getDataAlteracao());
            System.out.println("------------------------------------------------------------");
        }
    }

    // Método para atualizar funcionário
    public static Funcionario atualizar() {
        System.out.println("Digite o ID do funcionário que deseja atualizar: ");
        int id = scanner.nextInt();

        Funcionario funcionario = new Funcionario();
        funcionario.setId_funcionario(id);

        System.out.println("Novo nome do funcionário: ");
        funcionario.setNome(scanner.nextLine());

        System.out.println("Novo CPF do funcionário (Apenas números): ");
        funcionario.setCpf(scanner.nextLine());

        System.out.println("Situação do funcionário (A - Ativo, I - Inativo): ");
        funcionario.setSituacao(scanner.nextLine().charAt(0));

        funcionario.setDataAlteracao(LocalDateTime.now());

        return funcionario;
    }

    /* Método para deletar funcionário
    public static int deletar() {
        System.out.println("Digite o ID do funcionário que deseja deletar: ");
        return Integer.parseInt(scanner.nextLine());
    }*/
}
