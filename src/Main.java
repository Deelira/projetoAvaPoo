import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Concessionaria concessionaria = new Concessionaria("AutoShop Premium");

        System.out.println("=== SISTEMA DA CONCESSIONÁRIA ===\n");

        System.out.println("1. CADASTRANDO VEÍCULO:");
        Veiculo veiculo = new Veiculo("Ford", "Fiesta", "ABC1234", 2022, 45000.0);
        concessionaria.adicionarVeiculo(veiculo);
        System.out.printf("Veículo adicionado: %s, %s", veiculo.marca,veiculo.modelo);

        System.out.println("\n2. CADASTRANDO CLIENTE:");
        Cliente cliente = new Cliente("João Silva", 1, "11999999999", "joao@email.com");
        concessionaria.cadastrarCliente(cliente);
        System.out.printf("Cliente cadastrado: %s", cliente.nome);

        System.out.println("\n3. VEÍCULOS DISPONÍVEIS:");
        ArrayList<Veiculo> disponiveis = concessionaria.listarVeiculosDisponiveis();
        for (int i = 0; i < disponiveis.size(); i++) {
            System.out.println(disponiveis.get(i));
        }

        System.out.println("\n4. REALIZANDO VENDA:");
        boolean venda = concessionaria.realizarVenda(veiculo.placa, cliente.id, "15/05/2024", "À vista", veiculo.preco);
        if (venda) {
            System.out.println("Venda do " + veiculo.modelo + " para " + cliente.nome + ": SUCESSO");
        } else {
            System.out.println("Venda do " + veiculo.modelo + " para " + cliente.nome + ": FALHA");
        }

        System.out.println("\n5. VEÍCULOS DISPONÍVEIS APÓS VENDA:");
        ArrayList<Veiculo> disponiveisAposVenda = concessionaria.listarVeiculosDisponiveis();
        for (int i = 0; i < disponiveisAposVenda.size(); i++) {
            System.out.println(disponiveisAposVenda.get(i));
        }

        System.out.println("\n6. VENDAS REALIZADAS:");
        ArrayList<Venda> vendas = concessionaria.listarVendasRealizadas();
        for (int i = 0; i < vendas.size(); i++) {
            System.out.println(vendas.get(i));
        }

        System.out.println("\n7. RESUMO FINAL DA CONCESSIONÁRIA:");
        System.out.println(concessionaria);
    }
}