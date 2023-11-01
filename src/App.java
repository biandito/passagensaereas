import javax.swing.*;


public class App {
    public static void main(String[] args) throws Exception {
    	Voo voos[] = new Voo[10];
		int nVoo = 0;
		Aviao aero[] = new Aviao[10];
		int nAero = 0;
		
		
			
			
		  String[] options1 = { "Parâmetros do Sistema", "Reserva de Passagem","Sair" };
		  String[] options2 = { "Cadastrar Aeronave", "Cadastrar Voo","Voltar" };
		  String[] options3 = { "Fazer Reserva", "Consultar Lugares Vazios","Consultar Reservas Realizadas", "Voltar" };
		  int opcao[] = {0,0,0};
		  
		  

		  boolean sair = false;
		  do {
	      opcao[0] = JOptionPane.showOptionDialog(null, "Menu Principal", "Menu",
	          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	              null, options1, options1[0]);
	      
	     switch(opcao[0]) {
	     case 0:
	    	 opcao[1] = JOptionPane.showOptionDialog(null, "Parâmetros Sistema", "Menu",
	   	          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	   	              null, options2, options2[0]);
	    	 switch(opcao[1]) {
	    	 case 0:
	    		 String model = JOptionPane.showInputDialog("Digite o modelo do Aviao");
	    		 int lugares[] = new int[2];
	    		 lugares[0] = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de fileiras"));
	    		 lugares[1] = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de assentos por fileira"));
	    		 aero[nAero] = new Aviao(model,lugares[0],lugares[1]);
	    		 
	    		 JOptionPane.showMessageDialog(null, aero[nAero].getModelo());
	    		 nAero++;
	    		 break;
	    		 
	    	 case 1:
	    		 Aviao aeroVoo = (Aviao) JOptionPane.showInputDialog(null, "Qual aeronave?", "Escolher Aeronave", nAero, null, aero, aero[0]);
	    		 String mesVoo = JOptionPane.showInputDialog("Qual mês?");
	    		 String diaVoo = JOptionPane.showInputDialog("Qual dia?");
	    		 String horaVoo = JOptionPane.showInputDialog("Qual hora?");
	    		 voos[nVoo] = new Voo(aeroVoo, nVoo, diaVoo+"/"+mesVoo, horaVoo);
	    		 
	    		 JOptionPane.showMessageDialog(null, "Número do Voo: "+voos[nVoo].getNro()
	    		 		+ "\nAeronave: "+voos[nVoo].aero.getModelo()
	    				 +"\n Data: "+ voos[nVoo].getData()
	    				 +"\n Hora: "+ voos[nVoo].getHora());
	    		 nVoo++;

	    		 
	    		 break;
	    	 }
	    	 break;
	    	 
	     case 1:
	    	 opcao[2] = JOptionPane.showOptionDialog(null, "Reserva de Passagens", "Menu",
		   	          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		   	              null, options3, options3[0]);
	    	 break;
	    	 
	     case 2:
	    	 sair = true;
	    	 break;
	    	 
	     }
	     }
		  while(sair==false);

    }
}
