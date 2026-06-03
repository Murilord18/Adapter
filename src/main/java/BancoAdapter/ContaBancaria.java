package BancoAdapter;


public class ContaBancaria {

    private String titular;
    private double saldo;

    private ITransacao transacao;
    private TransacaoAdapter persistencia;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.transacao = new TransacaoExtrato();
        this.persistencia = new TransacaoAdapter(transacao);
    }


    public void registrarTransacao(String tipo, double valor) {
        transacao.setTipoTransacao(tipo);
        persistencia.salvarTipo();

        if ("CRÉDITO".equalsIgnoreCase(tipo)) {
            this.saldo += valor;
        } else if ("DÉBITO".equalsIgnoreCase(tipo)) {
            this.saldo -= valor;
        }
    }


    public String getTipoUltimaTransacao() {
        return persistencia.recuperarTipo();
    }


    public double getValorReferenciaTransacao() {
        return persistencia.getValor();
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
