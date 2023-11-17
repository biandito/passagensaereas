import javax.swing.*;


public class Voo {
    public Aviao aeronave; 
    public int nro;
    public String data;
    public String hora;
    
    public Voo(Aviao aeronave, int nro, String data, String hora) {
    	this.aeronave = aeronave;
    	this.nro = nro;
    	this.data = data;
    	this.hora = hora;
    }
    
    public Voo() {
    	
    }
    
    public void setVoo(int nVoo, Voo[] voos) {
    	String vooStr[] = new String[nVoo];
		 for(int i = 0; i<nVoo; i++) {vooStr[i]=voos[i].aeronave.modelo+", "+ voos[i].data+", " + voos[i].hora;}
		 String escVooStr = (String) JOptionPane.showInputDialog(null, "Escolha um voo", "Escolher Voo", nVoo, null, vooStr, vooStr[0]);
		 for(int j = 0; j<nVoo; j++) {if(String.valueOf(voos[j].aeronave.modelo+", "+ voos[j].data+", " + voos[j].hora) == escVooStr ) 
		 {
			 this.aeronave= voos[j].aeronave;
			 this.data = voos[j].data;
			 this.hora = voos[j].hora;
			 this.nro = voos[j].nro;
		 }
		 }
    }
    
    public int getNro() {
        return nro;
    }
    public void setNro(int nro) {
        this.nro = nro;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
}

