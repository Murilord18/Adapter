package BancoAdapter;


public class TransacaoExtrato implements ITransacao {

    private String tipo;

    @Override
    public String getTipoTransacao() {
        return this.tipo;
    }

    @Override
    public void setTipoTransacao(String tipo) {
        this.tipo = tipo;
    }
}
