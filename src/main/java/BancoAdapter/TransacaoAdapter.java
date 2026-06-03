package BancoAdapter;


public class TransacaoAdapter extends TransacaoValor {

    private ITransacao transacaoExtrato;

    public TransacaoAdapter(ITransacao transacaoExtrato) {
        this.transacaoExtrato = transacaoExtrato;
    }


    public String recuperarTipo() {
        double valor = this.getValor();

        if (valor > 0) {
            transacaoExtrato.setTipoTransacao("CRÉDITO");
        } else if (valor < 0) {
            transacaoExtrato.setTipoTransacao("DÉBITO");
        } else {
            transacaoExtrato.setTipoTransacao("NEUTRO");
        }

        return transacaoExtrato.getTipoTransacao();
    }


    public void salvarTipo() {
        String tipo = transacaoExtrato.getTipoTransacao();

        if ("CRÉDITO".equalsIgnoreCase(tipo)) {
            this.setValor(1.0);
        } else if ("DÉBITO".equalsIgnoreCase(tipo)) {
            this.setValor(-1.0);
        } else {
            this.setValor(0.0);
        }
    }
}
