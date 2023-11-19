import javax.swing.*;

public class Aviao extends Aeronave {
	
	public Passageiro[][] Lugares;
	
	//Construtor
	public Aviao(String modelo, int fileiras, int lugares) {
		super(modelo);
		this.Lugares = new Passageiro[fileiras][lugares];
	}
	
	public Aviao() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void setAero(int nAero, Aviao[] aero) {
		String aeroModel[] = new String[nAero];
		 for(int i = 0; i<nAero; i++) {aeroModel[i]=aero[i].modelo;}
		 String aeroVooModel = (String) JOptionPane.showInputDialog(null, "Qual aeronave?", "Escolher Aeronave", 2, null, aeroModel, aeroModel[0]);
		 for(int j = 0; j<nAero; j++) {if(aeroVooModel==aero[j].modelo) {
			 this.modelo = aero[j].modelo;
			 this.Lugares= aero[j].Lugares;
			 }}
	}
	//Retornar informações do passageiro naquele lugar
	public Passageiro getPassageiro(int fileira, int lugar) {
		return Lugares[fileira][lugar];
	}
	
	//Verificar se há um passageiro naquele lugar
	public boolean verificaLugarOcupado(int fileira, int lugar) {
		if(getPassageiro(fileira, lugar) == null) {return false;}
		else {return true;}
	}
	
	//Registrar um passageiro em um lugar(fileira e lugar na fileira)
	public void setPassageiro(int fileira, int lugar, Passageiro passageiro) {
		this.Lugares[fileira][lugar] = passageiro;
	}
	
	
    
}
