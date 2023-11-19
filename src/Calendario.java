
public class Calendario {
	
	
	
	public String[] dia = new String[31];
	public String mes[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	
	
	public Calendario() {
		for(int i = 0; i<31; i++) { this.dia[i] = Integer.toString(i+1);}
		
		
		}

	}
	
	

