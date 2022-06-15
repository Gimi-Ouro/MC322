package invasaoAoRio;

public interface ICelula {
    public boolean isTerra();
    public boolean isAgua();
    public Barco getBarco();
    public Equipamento getEquipamento();

    public void addBarco(Barco barco);
    public void addEquipamento(Equipamento equipamento);
}
