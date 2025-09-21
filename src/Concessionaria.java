import java.util.ArrayList;

public class Concessionaria {
    public String nome;
    public ArrayList<Veiculo> veiculos;
    public ArrayList<Cliente> clientes;
    public ArrayList<Venda> vendas;
    public int totalVeiculos;
    public int totalClientes;
    public int totalVendas;

    public Concessionaria (String nome){

        this.nome = nome;
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }


    public boolean adicionarVeiculo(Veiculo veiculo, int totalVeiculos) {
        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).placa.equals(veiculo.placa)) {
                return false;
            }
        }
        boolean statusAdicinonado = this.veiculos.add(veiculo);
        if (statusAdicinonado) {
            this.totalVeiculos++;
        }
        return statusAdicinonado;
    }

}

    public boolean adicionarVeiculo(Veiculo veiculo){
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).placa.equals(veiculo.placa)){
                return false;
            }
        }
        boolean statusInserido = this.veiculos.add(veiculo);
        if (statusInserido){
            this.totalVeiculos++;
        }
        return statusInserido;
    }

    public boolean removerVeiculo(String placa){
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).placa.equals(placa)){
                Veiculo veiculoBuscado = this.veiculos.get(i);
                this.veiculos.remove(veiculoBuscado);
                this.totalVeiculos--;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Veiculo> buscarVeiculoPorMarca(String marca){
        ArrayList<Veiculo> veiculosBuscados = new ArrayList<>();
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).marca.toLowerCase().contains(marca.toLowerCase())){
                Veiculo veiculo = this.veiculos.get(i);
                veiculosBuscados.add(veiculo);
            }
        }
        return veiculosBuscados;
    }

    public ArrayList<Veiculo> buscarVeiculoPorModelo(String modelo){
        ArrayList<Veiculo> veiculosBuscados = new ArrayList<>();
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).modelo.toLowerCase().contains(modelo.toLowerCase())){
                Veiculo veiculo = this.veiculos.get(i);
                veiculosBuscados.add(veiculo);
            }
        }
        return veiculosBuscados;
    }

    public boolean cadastrarCliente(Cliente cliente){
        for (int i = 0; i < this.totalClientes; i++){
            if (this.clientes.get(i).id == cliente.id){
                return false;
            }
        }
        boolean statusInserido = this.clientes.add(cliente);
        if (statusInserido){
            this.totalClientes++;
        }
        return statusInserido;
    }

    public boolean removerCliente(int idCliente){
        for (int i = 0; i < this.totalClientes; i++){
            if (this.clientes.get(i).id == idCliente){
                Cliente clienteremovido = this.clientes.get(i);
                this.clientes.remove(clienteremovido);
                this.totalClientes--;
                return true;
            }
        }
        return false;
    }

    public boolean realizarVenda(String placa, int idCliente, String datavenda, String formaPagamento, double valor){

        Veiculo veiculo = null;

        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).placa.equals(placa)) {
                if (!this.veiculos.get(i).disponivel) {
                    return false; // para veiculo ja vendido
                }
                veiculo = this.veiculos.get(i);
                break;
            }
        }
        if (veiculo == null){ // para veiculo nao encontrado
            return false;
        }


        Cliente cliente = null;

        for (int i = 0; i < this.totalClientes; i++){
            if (this.clientes.get(i).id == idCliente){
                cliente = this.clientes.get(i);
                break;
            }
        }
        if (cliente == null){ // para cliente nao encontrado
            return false;
        }

        veiculo.disponivel = false; // pra dizer que ele ja foi vendido

        Venda venda = new Venda(
                veiculo,
                cliente,
                datavenda,
                formaPagamento,
                valor
        );
    }
}
