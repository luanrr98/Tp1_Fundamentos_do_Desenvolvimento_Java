import java.util.Scanner;
public class ControleAcademico {
	private static final int TAMANHO_VETORES = 100;
	private static String[] aluno;
	private static float[] nota1;
	private static float[] nota2;
	private static Scanner in = new Scanner(System.in);
	private static int contador = 0;
	
// Método para adicionar um aluno e suas notas
	private static void adicionarAluno(){
		System.out.print("Digite o nome do(a) aluno(a): ");
		aluno[contador] = in.next();
		System.out.print("Digite a primeira nota: ");
		nota1[contador] = in.nextFloat();
		System.out.print("Digite a segunda nota: ");
		nota2[contador] = in.nextFloat();
	}

// Método para calcular e devolver a média das notas de um aluno
	private static float calcularMedia(int indice){
		return (nota1[indice]+nota2[indice])/2;
	}
	
// Método para definir e devolver a situação de um aluno, como Aprovado, Reprovado e Prova Final
	private static String definirSituacao(float media){
		if(media < 4) {
			return "Reprovado";
		}
		else if(media >= 4 && media <= 7) {
			return "Prova Final";
		}
		return "Aprovado";
	}
	
// Método para mostrar o Boletim de um aluno, verificando se ele está cadastrado
	private static void mostrarBoletin(int indice) {
		float media = calcularMedia(indice);
		System.out.printf("Nome do(a) Aluno(a): %s\n "
				+ "Nota da AV1: %.2f\n "
				+ "Nota da AV2: %.2f\n "
				+ "Média final: %.2f\n "
				+ "Situação: %s\n", 
				aluno[indice], nota1[indice], nota2[indice], media, definirSituacao(media));
		System.out.println();
	}
	
	
//Método para mostrar o boletin de todos os alunos cadastrados, verificando se não se trata de um aluno nulo	
	private static void mostrarTodosBoletins(){
			for(int i = 0; i < contador; i++) {
				mostrarBoletin(i);
			}
	}
	public static void main(String[] args){
		String opcao = null;
		aluno = new String[TAMANHO_VETORES];
		nota1 = new float[TAMANHO_VETORES];
		nota2 = new float[TAMANHO_VETORES];

		do {
			System.out.println("===============================");
			System.out.println("Bem-Vindo ao sistema acadêmico!");
			System.out.println("===============================");
			System.out.println("[1] Registrar as notas de um novo(a) aluno(a).");
			System.out.println("[2] Consultar boletim de um(a) aluno(a).");
			System.out.println("[3] Consultar notas da turma.");
			System.out.println("[4] Sair.");
			System.out.println();
			System.out.print("Digite sua opção: ");
			opcao = in.next();
			System.out.println();

			
			switch(opcao){
			case "1":
				if(contador < TAMANHO_VETORES) { // Validando se o número máximo de alunos ja não foi excedido
					adicionarAluno();
					System.out.println("O código do(a) aluno(a) "+aluno[contador]+ " é: "+contador);	
					System.out.println();
					contador++; // Uma variavél de contagem para manter o próximo indice dos arrays aluno, nota e nota 2
				}else {
					System.out.println("Operação Inválida, o número máximo de alunos será excedido!");
					System.out.println();

				}
				break;
			case "2":
				System.out.print("Digite o código do(a) aluno(a): ");
				int indice = in.nextInt();
				if(indice<TAMANHO_VETORES && aluno[indice]!=null){ // Validação para verificar se o índice digitado não está acima do limite do vetor ou se é não está "vazio"
					mostrarBoletin(indice);		
				} else {
					System.out.println("O o código digitado é inválido");
					System.out.println();

				}
				

				break;
			case "3":
				mostrarTodosBoletins();
				break;
			case "4":
				System.out.println();
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Opção inválida");
				System.out.println();
				
				break;	
			}

		}while(!"4".equals(opcao));
		in.close();

	}
	
	

}
