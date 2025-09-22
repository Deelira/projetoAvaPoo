import java.util.ArrayList;

public class Concessionaria {
    public String nome;
    public ArrayList<Veiculo> veiculos;
    public ArrayList<Cliente> clientes;
    public ArrayList<Venda> vendas;
    public int totalVeiculos;
    public int totalClientes;
    public int totalVendas;

    public void Concessionaria(String nome){
    }

    public boolean adicionarVeiculo(Veiculo veiculo){
        for (int i = 0; i < totalVeiculos; i++){
            if (this.veiculos.get(i).placa.equals(veiculo.placa)){
                return false;
            }
            boolean statusAdicionado = this.veiculos.add(veiculo);
            this.totalVeiculos++;
            return statusAdicionado;
        }
        return false;
    }

    public boolean removerVeiculo(Veiculo veiculo){
        for (int i = 0; i < totalVeiculos; i++){
            if (this.veiculos.get(i).placa.equals(veiculo.placa)){
                Veiculo veiculoEcontrado = this.veiculos.get(i);
                this.veiculos.remove(veiculoEcontrado);
                this.totalVeiculos--;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Veiculo> buscarVeiculoPorMarca(String marca){
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();
        for (int i = 0; i < totalVeiculos; i++){
            if (this.veiculos.get(i).marca.equals(marca)){
                veiculosEncontrados.add(veiculos.get(i));
            }
        }
        return veiculosEncontrados;
    }

    public ArrayList<Veiculo> buscarVeiculoPorModelo(String modelo){
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();
        for (int i = 0; i < totalVeiculos; i++){
            if (this.veiculos.get(i).modelo.equals(modelo)){
                veiculosEncontrados.add(veiculos.get(i));
            }
        }
        return veiculosEncontrados;
    }

    public boolean cadastrarCliente(Cliente cliente){
        if (cliente != null){
            clientes.add(cliente);
            totalClientes++;
            return true;
        }
        return false;
    }

    public boolean removerCliente(Cliente cliente){
        for (int i = 0; i < totalClientes; i++){
            if (this.clientes.get(i).id == cliente.id){
                Cliente clienteEncontrado = this.clientes.get(i);
                this.clientes.remove(clienteEncontrado);
                this.totalClientes--;
                return true;
            }
        }
        return false;
    }

    ///  João pedro: concluir métodos restantes e fazer o toString
  public boolean realizarVenda(String placa, int idCliente, String dataVenda, String formaPagamento, double valor) {
        Veiculo veiculoSelecionado = null;
        Cliente clienteSelecionado = null;

        // busca veículo pela placa
        for (int i = 0; i < totalVeiculos; i++) {
            if (this.veiculos.get(i).placa.equals(placa)) {
                veiculoSelecionado = this.veiculos.get(i);
                break;
            }
        }

        // busca cliente pelo id
        for (int i = 0; i < totalClientes; i++) {
            if (this.clientes.get(i).id == idCliente) {
                clienteSelecionado = this.clientes.get(i);
                break;
            }
        }

        if (veiculoSelecionado != null && clienteSelecionado != null) {
            Venda venda = new Venda(veiculoSelecionado, clienteSelecionado, dataVenda, formaPagamento, valor);
            vendas.add(venda);
            veiculos.remove(veiculoSelecionado);
            totalVendas++;
            totalVeiculos--;
            return true;
        }
        return false;
    }

    public ArrayList<Veiculo> listarVeiculosDisponiveis() {
        return new ArrayList<>(veiculos);
    }

    public ArrayList<Venda> listarVendasRealizadas() {
        return new ArrayList<>(vendas);
    }

    @Override
    public String toString() {
        return "Concessionaria: " + nome +
               "\nTotal de Veículos: " + totalVeiculos +
               "\nTotal de Clientes: " + totalClientes +
               "\nTotal de Vendas: " + totalVendas;
    }
}