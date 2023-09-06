package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;


public class Program {

	public static void main(String[] args) throws ParseException {
			
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			List<Lesson> list = new ArrayList<>();
			
			System.out.print("Quantas aulas tem o curso? ");
			int n = sc.nextInt();
			
			for (int i=1; i<=n; i++) {
				System.out.println("Dados da " + i + "a aula:");
				System.out.print("Conteúdo ou Tarefa (c/t)? ");
				char type = sc.next().charAt(0);
				
				if (type == 'c') {
					System.out.print("Título: ");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("URL do vídeo: ");
					String url = sc.nextLine();
					System.out.print("Duração em segundos: ");
					int seconds = sc.nextInt();
					list.add(new Video(title, url, seconds));	
					
				}
				else {
					System.out.print("Título: ");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("Descrição: ");
					String descricao = sc.nextLine();
					System.out.print("Quantidade de questões: ");
					int qtdQuestao = sc.nextInt();
					list.add(new Task(title, descricao, qtdQuestao));	
				}
			}

			double totalCurso = 0.0;
			System.out.println();
			
			for (Lesson ln : list) {
				double duration = ln.duration();
				//System.out.println(ln.duration());
				totalCurso += duration;
			}
			
			System.out.println();
			System.out.println("DURAÇÃO TOTAL DO CURSO = " +  totalCurso + "segundos ");
			
			sc.close();
		}
	}