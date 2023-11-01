public class Voo {
    public Aeronave aviao; 
    public int nro;
    public String data;
    public String hora;

    public Voo(Aeronave aero, int nro, String data, String hora) {
    	this.aero = aero;
    	this.nro = nro;
    	this.data = data;
    	this.hora = hora;
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

