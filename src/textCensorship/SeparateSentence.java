package textCensorship;


import java.util.Arrays;

public class SeparateSentence {
	
	private String[] frasesFortes = {"fuder"};
	
	public String[] separarFraseNormal(String e) {
		
		String[] vet = e.split(" ");
		
		return vet;
	}
	
	
	
	public String formatString(String e) {
		String[] vetor = e.split("");
		String novaWord="";
		
		for(int i = 0; i<vetor.length; i++) {
			vetor[i] = "*";
			novaWord += vetor[i];
		}
		
		
		
		return novaWord;
		
	}
	
	
	

	public String comparaPalavra(String e) {
		
		String novaString;
		
		for(int i =0; i < frasesFortes.length; i++) {
			
			if(e.equals(frasesFortes[i])) {
				novaString = 
			}
			
		}
		
		return novaString; 
	}
	

}
