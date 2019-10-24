package gerenciamento.garagem.GEEstacionamentos.models.enums;

public enum TipoCliente {

    VAGAANTECIPADA(1, "Vaga Antecipada"),
    VAGATEMPORARIA(2, "Vaga Temporaria");

    private int codigo;
    private String tipovaga;

    TipoCliente(int codigo, String tipovaga) {
        this.codigo = codigo;
        this.tipovaga = tipovaga;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getTipovaga() { return tipovaga; }
    public void setTipovaga(String tipovaga) { this.tipovaga = tipovaga; }
}
