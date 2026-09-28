package personalFundManager.application;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static Scanner sc;

	public static void main(String[] args) {
		System.out.println("╔════════════════════════════════════════════════════════════╗");
		System.out.println("║               PROGRAMA GERENCIADOR FINANCEIRO              ║");
		System.out.println("║                                                            ║");
		System.out.println("║  Desenvolvido por: DeadKeymon449             Versão: #1    ║");
		System.out.println("╚════════════════════════════════════════════════════════════╝");
		System.out.println();
		
		System.out.print("Saldo atual: R$\s");

		sc = new Scanner(System.in);

		Double saldoEntrada = sc.nextDouble();
		if (saldoEntrada < 0d)
			throw new IllegalArgumentException("Saldo abaixo de zero!");

		System.out.println();
		
		System.out.print("Opções: \n");
		System.out.print("1) Conferir fundos essenciais. \n");
		System.out.print("2) Conferir fundos alocados. \n");
		System.out.print("3) Conferir cálculo de despesas mensais. \n");
		System.out.print("4) Salvar e sair do programa. \n");
		System.out.println();
		System.out.print("Resposta: ");

		int respostaUsuario = sc.nextInt();

		System.out.println();
		
		if (respostaUsuario == 1) {
			imprimirSessaoFundosEssenciais(saldoEntrada);
		}

		sc.close();
	}

	public static void imprimirSessaoFundosEssenciais(Double saldoEntrada) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());

		System.out.print("ENTRADA: \n");
		System.out.print("Defina um orçamento para cada item \n");
		System.out.print("Alimentação: → R$ ");
		double valorPadraoAlimentacao = sc.nextDouble();
		System.out.print("Higiene pessoal: → R$ ");
		double valorPadraoHigienePessoal = sc.nextDouble();
		System.out.print("Gás: → R$ ");
		double valorPadraoGas = sc.nextDouble();

		System.out.println();
		
		System.out.println("Depósito de valores:");
		System.out.print("Informe quanto deseja depositar em cada fundo. \n");
		System.out.print("Digite 0,00 caso não queira depositar nada. \n");
		
		System.out.print("Alimentação → R$ ");
		double entradaAlimentacao = sc.nextDouble();
		
		System.out.print("Higiene pessoal → R$ ");
		double entradaHigiene = sc.nextDouble();
		
		System.out.print("Gás → R$ ");
		double entradaGas = sc.nextDouble();

		System.out.println();
		System.out.println("Depósitos registrados com sucesso!");
		
		System.out.println();
		System.out.println("Fundos essenciais:");
		System.out.printf("Alimentação: %s → %s guardado.\n", nf.format(valorPadraoAlimentacao), nf.format(entradaAlimentacao));
		System.out.printf("Higiene pessoal: %s → %s guardado.\n", nf.format(valorPadraoHigienePessoal), nf.format(entradaHigiene));
		System.out.printf("Gás: %s → %s guardado.\n", nf.format(valorPadraoGas), nf.format(entradaGas));
		
		double fundoDisponivel = saldoEntrada - entradaAlimentacao - entradaHigiene - entradaGas;
		
		System.out.println();
		System.out.printf("Disponível → %s\n", nf.format(fundoDisponivel));
	}

}
