import java.util.ArrayList;

public class Concessionaria {

    public String nome;
    public ArrayList<Veiculo> veiculos;
    public ArrayList<Cliente> clientes;
    public ArrayList<Venda> vendas;
    public int totalVeiculos;
    public int totalClientes;
    public int totalVendas;
    public int totalLivros;

    public Concessionaria(String nome){
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
