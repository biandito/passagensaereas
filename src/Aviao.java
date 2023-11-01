public class Aviao extends Aeronave {
	
	public Passageiro[][] Lugares;
	
	//Construtor
	public Aviao(String modelo, int fileiras, int lugares) {
		super(modelo);
		this.Lugares = new Passageiro[fileiras][lugares];
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
