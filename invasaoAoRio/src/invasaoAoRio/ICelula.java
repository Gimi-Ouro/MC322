package invasaoAoRio;

public interface ICelula {
    public boolean isTerra();
    public boolean isAgua();
    public Barco getBarco();
    public Canhao getCanhao();

    public void addBarco(Barco barco);
    public void addCanhao(Canhao canhao);
}
