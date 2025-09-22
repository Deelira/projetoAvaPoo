public class Veiculo {

    public String marca;
    public String modelo;
    public String placa;
    public int ano;
    public boolean disponivel;
    public double preco;

    public Veiculo (String marca, String modelo, String placa, int ano, double preco){
        this.disponivel = true;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
    }

    public void mudarDisponibilidade (boolean disponibilidade){
        this.disponivel = disponibilidade;
    }

    @Override
    public String toString() {
        return String.format("<Veículo: " +
               "\nMarca = %s " +
               "\nModelo = %s " +
               "\nPlaca = %s " +
               "\nAno = %s " +
               "\nDisponivel = %b " +
               "\nPreço = R$%.2f>"
                , this.marca, this.modelo, this.placa, this.ano, this.disponivel, this.preco);
    }
}
