package personalFundManager.application;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		System.out.print("[PROGRAMA GERENCIADOR FINANCEIRO] \n");
		System.out.print("Sendo desenvolvido por: DeadKeymon449	Versão: #1 \n");
		System.out.print("------------------------------------------------------------ \n");
		System.out.print("Digite seu saldo atual: R$\s");

		Scanner sc = new Scanner(System.in);

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

		if (respostaUsuario == 1) {
			imprimirSessaoFundosEssenciais(saldoEntrada);
		}

		sc.close();
	}

	public static void imprimirSessaoFundosEssenciais(Double saldoEntrada) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());

		// valores guardados na memória
		double alocadoAlimentacao = 500d;
		double alocadoHigiene = 200d;
		double alocadoGas = 120d;

		System.out.print("------------[FUNDOS ESSENCIAIS]------------ \n");
		System.out.print("Alimentação: " + nf.format(500d) + " (" + nf.format(alocadoAlimentacao) + " guardado) \n");
		System.out.print("Higiene pessoal: " + nf.format(200d) + " (" + nf.format(alocadoHigiene) + " guardado) \n");
		System.out.print("Gás: " + nf.format(120d) + " (" + nf.format(alocadoGas) + " guardado) \n");
		System.out.println();

		double fundoDisponivel = saldoEntrada - 500d - 200d - 120d;

		System.out.print("* Disponível: " + nf.format(fundoDisponivel));
	}

}
