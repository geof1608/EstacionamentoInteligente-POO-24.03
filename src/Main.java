import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Veiculo[] veiculo = new Veiculo[5];
    static int indexVeiculo;
    static Registro[] registro = new Registro[20];
    static int indexRegistro;



    public static void main(String[] args) {

        int opcao;


        do {
            System.out.println("#### Estacionamento ParkEasy ####");
            System.out.println("[1] Entrada de veículo");
            System.out.println("[2] Saída de veículo");
            System.out.println("[3] Imprimir veículos estacionados");
            System.out.println("[4] Imprimir a receita");
            System.out.println("[5] Finalizar");
            opcao = sc.nextInt();//vai receber o valor da opcao, ou seja, para escolher alguma das opções acima

            switch (opcao){
                case 1 -> registrarEntrada();//quando ele estiver vermelho é so passar o mouse em cima que ele cria um metodo
                case 3 -> estacionados();
            }



        }while (opcao !=5);

    }

    private static void estacionados() {
        for (int i =0; i < indexRegistro; i++) {
            System.out.println(registro[i].veiculo.placa);
        }
    }


    private static void registrarEntrada() {
        String nome;
        String marca, modelo, placa;
        long cpf;
        String horaEntrada;

        Veiculo veiculoEncontrado = pesquisar();

        if (veiculoEncontrado == null){
            System.out.print("Nome do proprietario --> ");
            nome = sc.next();
            System.out.print("CPF do proprietário --> ");
            cpf = sc.nextLong();
            System.out.print("Placa --> ");
            placa = sc.next().toUpperCase();
            System.out.print("Marca --> ");
            marca = sc.next();
            System.out.print("Modelo -->");
            modelo = sc.next();

            Proprietario proprietario = new Proprietario(cpf, nome);//tem que ser na ordem certa, igual a classe proprietario
            veiculo[indexVeiculo] = new Veiculo(placa, modelo, marca, proprietario);
            indexVeiculo++;

        }
        else {
            System.out.print("Hora de Entrada (hh:mm) --> ");
            horaEntrada = sc.next();
            registro[indexRegistro] = new Registro(veiculoEncontrado, horaEntrada);
            indexRegistro++;

        }


    }

    private static Veiculo pesquisar(){//para buscar se a placa ja passou pelo estacionamento
        String placa;
        System.out.println("Placa para pesquisa --> ");
        placa = sc.next().toUpperCase();//uppercase para passar todas as letras para maiuscula
        for (int i = 0; i < indexVeiculo; i++){
            if (veiculo[i].placa.equals(placa)){//esta buscando a placa da classe Veiculo e comparando com a placa desse proprio metodo
                return veiculo[i];

            }
        }
        System.out.println("Veículo não encontrado!");
        return null;

    }




}
