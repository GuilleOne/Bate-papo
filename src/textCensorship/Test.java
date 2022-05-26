package textCensorship;

import java.util.Arrays;
import java.util.Scanner;



public class Test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		SeparateSentence sepa = new SeparateSentence();
		String menssagem="";
		String[] vet;
		
		while(menssagem!="sair") {
			System.out.println("Escreva a mensagem: ");
			menssagem = scan.nextLine().replaceAll("[!.?]", "");;
			vet = sepa.separarFraseNormal(menssagem);
			
			for(int i =0; i<vet.length; i++) {
				for(int j=0; j<sepa.frasesFortes.length; j++) {
					if(vet[i].equals(sepa.frasesFortes[j])) {
						vet[i] = sepa.formatString(vet[i]);
					}
				}
				menssagem += ' '+vet[i];
			}
			
			System.out.println(menssagem);
		}
		
		
	}

}
