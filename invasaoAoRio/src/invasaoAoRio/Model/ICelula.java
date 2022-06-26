package invasaoAoRio.Model;

public interface ICelula {
    public boolean isTerra();
    public boolean isAgua();
    public Barco getBarco();
    public Tanque getCanhao();
    public Tiro getTiro();

    public void addBarco(Barco barco);
    public boolean addTanque(Tanque tanque);
    public void addTiro(Tiro tiro);
    public void removerElemento();
    public boolean isVazia();

    void removerTiro();
}
