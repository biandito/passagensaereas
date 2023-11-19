import javax.swing.*;


public class PainelHoras {
	
	private String[] hora = new String[24];
	private String[] minuto = new String[60];
	public 	JPanel horasP = new JPanel();
	public JComboBox<String> horas;
    public JComboBox<String> minutos;
	
	public PainelHoras() {
		
		for(int j = 0; j<24; j++) { this.hora[j] = Integer.toString(j);}
		for(int k = 0; k<60; k++) { this.minuto[k] = Integer.toString(k);}
		
		this.horas = new JComboBox<>(hora);
		this.minutos = new JComboBox<>(minuto);
		
	    
	      this.horasP.add(new JLabel("Horario: "));
	      this.horasP.add(horas);
	      this.horasP.add(new JLabel(":"));
	      this.horasP.add(minutos);
	


}
	}
