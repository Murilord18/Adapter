# Sistema Bancário — Padrão de Projeto Adapter

## Descrição

Projeto Maven em Java demonstrando o **Padrão Estrutural Adapter** aplicado a um sistema bancário simples.

O problema resolvido: o sistema legado armazena transações como **valores numéricos** (`double`), mas a interface do sistema exige **tipos textuais** (`String` — "CRÉDITO", "DÉBITO"). O Adapter faz a ponte entre os dois formatos.

---

## Estrutura de Classes

```
padroesestruturais.adapter
│
├── ITransacao              ← Interface alvo (Target)
├── TransacaoExtrato        ← Implementação concreta do Target
├── TransacaoValor          ← Classe legada (Adaptee) — trabalha com double
├── TransacaoAdapter        ← ADAPTER (herda Adaptee + usa Target)
└── ContaBancaria           ← Cliente que usa o Adapter
```

### Papéis do Padrão Adapter

| Papel         | Classe do Projeto    | Equivalente do Professor  |
|---------------|----------------------|---------------------------|
| Target        | `ITransacao`         | `IAvaliacao`              |
| Adaptee       | `TransacaoValor`     | `AvaliacaoNota`           |
| Adapter       | `TransacaoAdapter`   | `AvaliacaoAdapter`        |
| Concrete Target | `TransacaoExtrato` | `AvaliacaoConceito`       |
| Client        | `ContaBancaria`      | `Aluno`                   |

---

## Como Executar

### Pré-requisitos
- Java 11+
- Maven 3.6+

### Compilar e testar
```bash
cd banco-adapter
mvn clean test
```

### Apenas compilar
```bash
mvn compile
```

---

## Testes (JUnit 5)

Os testes estão em `ContaBancariaTest.java` e cobrem:

- Conversão de tipo textual CRÉDITO/DÉBITO
- Valor numérico de referência (+1.0 / -1.0) pelo Adapter
- Cálculo de saldo após múltiplas transações
- Inicialização correta de titular e saldo

---


