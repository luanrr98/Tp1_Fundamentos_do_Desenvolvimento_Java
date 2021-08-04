import java.util.Scanner;
public class ControleAcademico {
	static String[] aluno = new String[100];
	static float[] nota1 = new float[100];
	static float[] nota2 = new float[100];
	static Scanner in = new Scanner(System.in);
	static String opcao;
	static int contador = 0;

// Método para adicionar um aluno e suas notas
	public static void adicionarAluno(){
		System.out.print("Digite o nome do(a) aluno(a): ");
		aluno[contador] = in.next();
		System.out.print("Digite a primeira nota: ");
		nota1[contador] = in.nextFloat();
		System.out.print("Digite a segunda nota: ");
		nota2[contador] = in.nextFloat();
	}

// Método para calcular e devolver a média das notas de um aluno
	public static float calcularMedia(int indice){
		return (nota1[indice]+nota2[indice])/2;
	}
	
// Método para definir e devolver a situação de um aluno, como Aprovado, Reprovado e Prova Final
	public static String definirSituacao(float media){
		if(media < 4) {
			return "Reprovado";
		}
		else if(media >= 4 && media <= 7) {
			return "Prova Final";
		}
		return "Aprovado";
	}
	
// Método para mostrar o Boletim de um aluno, verificando se ele está cadastrado
	public static void mostrarBoletin(int indice) {
		if(aluno[indice]==null) {
			System.out.println("ALUNO NÃO CADASTRADO!");
		}else {
		
			float media = calcularMedia(indice);
			System.out.println("Nome do(a) Aluno(a): "+aluno[indice]);
			System.out.println("Nota da AV1: "+nota1[indice]);
			System.out.println("Nota da Av2: "+nota2[indice]);
			System.out.printf("Média final: %.2f\n", media);
			System.out.println("Situação: "+definirSituacao(media));
			System.out.println();
		}
	}
	
//Método para mostrar o boletin de todos os alunos cadastrados, verificando se não se trata de um aluno nulo	
	public static void mostrarTodosBoletins(){
			for(int i = 0; i < aluno.length; i++) {
				if(aluno[i]==null) {
					break;
				}
				mostrarBoletin(i);
			}
	}
	public static void main(String[] args){
		do {
			
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
				adicionarAluno();
				System.out.println("O código do(a) aluno(a) "+aluno[contador]+ " é: "+contador);	
				System.out.println();
				contador++; // Uma variavél de contagem para manter o próximo indice dos arrays aluno, nota e nota 2
				break;
			case "2":
				System.out.print("Digite o código do(a) aluno(a): ");
				int indice = in.nextInt();
				mostrarBoletin(indice);		

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
				break;
					
			}

		}while(opcao != "4");
		in.close();

	}
	
	

}
