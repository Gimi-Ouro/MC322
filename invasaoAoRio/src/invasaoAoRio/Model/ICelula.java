package invasaoAoRio.Model;

public interface ICelula {
    public boolean isTerra();
    public boolean isAgua();
    public Barco getBarco();
    public Tanque getCanhao();

    public void addBarco(Barco barco);
    public void addTanque(Tanque tanque);
    public void removerElemento();
    public boolean isVazia();
}
