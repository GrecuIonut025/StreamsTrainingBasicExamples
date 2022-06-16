public class Ristorante {
    private String nome;
    private TipoRistorante tipo;
    private int coperti;
    public Ristorante(){

    }
    public Ristorante(String nome, TipoRistorante tipo, int coperti)
    {
        this.nome = nome; this.coperti = coperti; this.tipo = tipo;
    }

    public Ristorante(String nome, int coperti) {
        this.nome=nome; this.coperti=coperti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoRistorante getTipo() {
        return tipo;
    }

    public void setTipo(TipoRistorante tipo) {
        this.tipo = tipo;
    }

    public int getCoperti() {
        return coperti;
    }

    public void setCoperti(int coperti) {
        this.coperti = coperti;
    }

    @Override
    public String toString() {
        return "Ristorante{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", coperti=" + coperti +
                '}';
    }
}

