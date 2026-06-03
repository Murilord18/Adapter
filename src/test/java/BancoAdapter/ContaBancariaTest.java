package BancoAdapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void setUp() {
        conta = new ContaBancaria("João Silva", 1000.00);
    }


    // Testes de tipo de transação (String → conversão pelo Adapter)


    @Test
    void deveRetornarTipoCreditoAposTransacaoCredito() {
        conta.registrarTransacao("CRÉDITO", 500.00);

        assertEquals("CRÉDITO", conta.getTipoUltimaTransacao());
    }

    @Test
    void deveRetornarTipoDebitoAposTransacaoDebito() {
        conta.registrarTransacao("DÉBITO", 200.00);

        assertEquals("DÉBITO", conta.getTipoUltimaTransacao());
    }


    // Testes de valor numérico de referência (Adapter → double)


    @Test
    void deveRetornarValorPositivoParaCredito() {
        conta.registrarTransacao("CRÉDITO", 300.00);

        assertEquals(1.0, conta.getValorReferenciaTransacao());
    }

    @Test
    void deveRetornarValorNegativoParaDebito() {
        conta.registrarTransacao("DÉBITO", 150.00);

        assertEquals(-1.0, conta.getValorReferenciaTransacao());
    }


    // Testes de saldo após transações


    @Test
    void deveAumentarSaldoAposCredito() {
        conta.registrarTransacao("CRÉDITO", 500.00);

        assertEquals(1500.00, conta.getSaldo());
    }

    @Test
    void deveDiminuirSaldoAposDebito() {
        conta.registrarTransacao("DÉBITO", 200.00);

        assertEquals(800.00, conta.getSaldo());
    }

    @Test
    void deveCalcularSaldoAposMultiplasTransacoes() {
        conta.registrarTransacao("CRÉDITO", 500.00); // saldo: 1500
        conta.registrarTransacao("DÉBITO", 300.00);  // saldo: 1200
        conta.registrarTransacao("CRÉDITO", 100.00); // saldo: 1300

        assertEquals(1300.00, conta.getSaldo());
    }


    // Testes de dados do titular


    @Test
    void deveRetornarNomeDoTitularCorretamente() {
        assertEquals("João Silva", conta.getTitular());
    }

    @Test
    void deveInicializarSaldoCorretamente() {
        ContaBancaria novaConta = new ContaBancaria("Maria Souza", 2500.00);

        assertEquals(2500.00, novaConta.getSaldo());
    }
}
