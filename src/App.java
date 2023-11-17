
import javax.swing.*;


public class App {
    public static void main(String[] args) throws Exception {
    	Voo voos[] = new Voo[10];
		int nVoo = 0;
		Aviao aero[] = new Aviao[10];
		int nAero = 0;
		
		
			
		//OPÇÕES DOS MENUS
		  String[] options1 = { "Parâmetros do Sistema", "Reserva de Passagem","Sair" };
		  String[] options2 = { "Cadastrar Aeronave", "Cadastrar Voo","Voltar" };
		  String[] options3 = { "Fazer Reserva", "Consultar Lugares Vazios","Consultar Reservas Realizadas", "Voltar" };
		  int opcao[] = {0,0,0};
		  
		  boolean sair = false;
		  
		  
		  do {
			  //MENU PRINCIPAL
			  opcao[0] = JOptionPane.showOptionDialog(null, "Menu Principal", "Menu",
	          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	              null, options1, options1[0]);
	      
	     switch(opcao[0]) {
	     //MENU DE PARÂMETROS DO SISTEMA
	     case 0:
	    	 opcao[1] = JOptionPane.showOptionDialog(null, "Parâmetros Sistema", "Menu",
	   	          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	   	              null, options2, options2[0]);
	    	 switch(opcao[1]) {
	    	 //CADASTRO DE AERONAVE
	    	 case 0:
	    		 String model = JOptionPane.showInputDialog("Digite o modelo do Aviao");
	    		 for(int i=0; i< nAero; i++) if(model.equals(aero[i].modelo)) {JOptionPane.showMessageDialog(null, "Modelo existe");}
	    		 int lugares[] = new int[2];
				 try {
					lugares[0] = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de fileiras"));
					lugares[1] = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de assentos por fileira"));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro ao ler os dados. Certifique-se de inserir números válidos.");
					return; 
				} finally {
					
	    		 JOptionPane.showMessageDialog(null, aero[nAero].getModelo());
	    		 nAero++; }
	    		 break;
	    		 
	    	 //CADASTRO DE VOO
	    	 case 1:
	    		 
	    		/* String aeroModel[] = new String[nAero];
	    		 for(int i = 0; i<nAero; i++) {aeroModel[i]=aero[i].modelo;}
	    		 String aeroVooModel = (String) JOptionPane.showInputDialog(null, "Qual aeronave?", "Escolher Aeronave", nAero, null, aeroModel, aeroModel[0]);
	    		 Aviao aeroVoo = null;
	    		 for(int j = 0; j<nAero; j++) {if(aeroVooModel==aero[j].modelo) {aeroVoo= aero[j];}}*/
	    		 Aviao aeroVoo = new Aviao();
	    		 aeroVoo.setAero(nAero, aero);
				 try {
				 String mesVoo = JOptionPane.showInputDialog("Qual mês?");
	    		 String diaVoo = JOptionPane.showInputDialog("Qual dia?");
	    		 String horaVoo = JOptionPane.showInputDialog("Qual hora?");
	    		 voos[nVoo] = new Voo(aeroVoo, nVoo, diaVoo+"/"+mesVoo, horaVoo);
	    		 
	    		 JOptionPane.showMessageDialog(null, "Número do Voo: "+voos[nVoo].getNro()
	    		 		+ "\nAeronave: "+voos[nVoo].aeronave.getModelo()
	    				 +"\n Data: "+ voos[nVoo].getData()
	    				 +"\n Hora: "+ voos[nVoo].getHora()
	    				 +"\n Fileiras: "+ voos[nVoo].aeronave.Lugares.length
	    				 +"\n Assentos: "+ voos[nVoo].aeronave.Lugares[0].length);
	    		 
	    		 nVoo++;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro ao ler dados numéricos. Certifique-se de inserir números válidos.");
					return;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro desconhecido ao cadastrar voo.");
					return;
				}
				break; 

	    		}
	    	 break;
	    	 
	    //MENU RESERVA DE PASSAGENS
	     case 1:
	    	 opcao[2] = JOptionPane.showOptionDialog(null, "Reserva de Passagens", "Menu",
		   	          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		   	              null, options3, options3[0]);
	    	 
	    	 switch(opcao[2]) {
	    	 
	    	 //FAZER RESERVA
			 case 0:
			 String vooStr[] = new String[nVoo];
			 for (int i = 0; i < nVoo; i++) {
				 vooStr[i] = voos[i].aeronave.modelo + ", " + voos[i].data + ", " + voos[i].hora;
			 }
			 String escVooStr = (String) JOptionPane.showInputDialog(null, "Escolha um voo", "Escolher Voo", nVoo, null, vooStr, vooStr[0]);
			 Voo escVoo = new Voo();
		 
			 for (int j = 0; j < nVoo; j++) {
				 if ((voos[j].aeronave.modelo + ", " + voos[j].data + ", " + voos[j].hora).equals(escVooStr)) {
					 escVoo = voos[j];
				 }
			 }
 		 
			 String nome, cpf;
			 nome = JOptionPane.showInputDialog("Digite seu nome");
			 cpf = JOptionPane.showInputDialog("Digite seu cpf");
			 int lugar[] = new int[2];
		 
			 try {
				 lugar[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual fileira?"));
				 lugar[1] = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual assento?"));
			 } catch (NumberFormatException e) {
				 JOptionPane.showMessageDialog(null, "Erro ao ler dados numéricos. Certifique-se de inserir números válidos.");
				 return;
			 } finally {
				 escVoo.aeronave.setPassageiro(lugar[0] - 1, lugar[1] - 1, new Passageiro(nome, cpf));
			 }
			 break;		 
	    		 
	    	 //CONSULTAR NUMERO DE LUGARES VAZIOS
			 case 1:
			 try {
				 String verVooStr[] = new String[nVoo];
				 for (int i = 0; i < nVoo; i++) {
					 verVooStr[i] = voos[i].aeronave.modelo + ", " + voos[i].data + ", " + voos[i].hora;
				 }
		 
				 String verStr = (String) JOptionPane.showInputDialog(
						 null, "Escolha um voo", "Escolher Voo", nVoo, null, verVooStr, verVooStr[0]);
		 
				 Voo verVoo = new Voo();
				 for (int j = 0; j < nVoo; j++) {
					 if ((voos[j].aeronave.modelo + ", " + voos[j].data + ", " + voos[j].hora).equals(verStr)) {
						 verVoo = voos[j];
					 }
				 }
		 		int nLugares = 0;
				 for (int i = 0; i < verVoo.aeronave.Lugares.length; i++) {
					 for (int j = 0; j < verVoo.aeronave.Lugares[0].length; j++) {
						 if (!verVoo.aeronave.verificaLugarOcupado(i, j)) {
							 nLugares++;
						 }
					 }
				 }
		 
				 JOptionPane.showMessageDialog(null, "Numero de lugares livres: " + nLugares);
			 } catch (NumberFormatException e) {
				 JOptionPane.showMessageDialog(null, "Erro ao ler dados. Certifique-se de inserir números válidos.");
				 return;
			 } catch (Exception e) {
				 JOptionPane.showMessageDialog(null, "Erro ao consultar lugares vazios.");
				 return;
			 } finally {
			}
			 break;
	    		 
	    		 
	    	 //CONSULTAR RESERVAS
	    	 case 2:
	    		 
	    		 String lugVooStr[] = new String[nVoo];
	    		 for(int i = 0; i<nVoo; i++) {lugVooStr[i]=voos[i].aeronave.modelo+", "+ voos[i].data+", " + voos[i].hora;}
	    		 String lugStr = (String) JOptionPane.showInputDialog(null, "Escolha um voo", "Escolher Voo", nVoo, null, lugVooStr, lugVooStr[0]);
	    		 Voo lugVoo = new Voo();
	    		 for(int j = 0; j<nVoo; j++) {if((voos[j].aeronave.modelo+", "+ voos[j].data+", " + voos[j].hora).equals(lugStr)){
	    			 lugVoo= voos[j];}}
	    		 
	    		 /*Voo lugVoo = (Voo) JOptionPane.showInputDialog(null, "Escolha um voo", "Escolher Voo", nVoo, null, voos, voos[0]);*/
	    		 String matriz = "";
	    		 for(int i = 0; i< lugVoo.aeronave.Lugares.length; i++) {
	    			 for(int j = 0; j<lugVoo.aeronave.Lugares[0].length; j++) {
	    				 
	    				 if(!lugVoo.aeronave.verificaLugarOcupado(i, j)) {matriz = matriz + "||"+ (i+1) + "," + (j+1) + "||   ";}
	    				 else{matriz = matriz + "|Ocp|   ";}
	    				 
	    			 }
	    			 
	    			 matriz= matriz +"\n";
	    			 
	    			 
	    		 }
    			 JOptionPane.showMessageDialog(null, matriz);

	    		
	    		 break;
	    	 
	    	 }
	    	 break;
	    	
	    //ENCERRAR
	     case 2:
	    	 sair = true;
	    	 break;
	    	 
	     }
	     }
		  while(sair==false);

    }
}
