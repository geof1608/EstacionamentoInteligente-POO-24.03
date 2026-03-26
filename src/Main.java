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
                case 2 -> registrarSaida();
                case 3 -> estacionados();
                case 4 -> imprimirReceita();
                case 5 -> System.out.println("ParkEasy agradece");
                default -> System.out.println("Opção Inválida");//se digitar qualquer numero diferente de 1 a 5
            }

            System.out.println();
        }while (opcao !=5);

    }

    private static void imprimirReceita() {
        double valor = 0;
        for (int i = 0; i < indexRegistro; i ++){
            if (registro[i].horaSaida != null){//ele so vai continuar caso tenha hora de saida
                valor += registro[i].calcularValor();
            }
        }
        System.out.println("Receita total R$ "+ valor);
    }

    private static void registrarSaida() {
        String horaSaida;
        double valor;
        Registro registro = pesquisarRegistro();//como não tem nenhum objeto na frente dele quer dizer que ele não faz parte de um objeto
        //essa parte de cima serve para podermos chamar funçoes do outro objeto
        if (registro != null){
            System.out.print("Hora de saída (hh:mm) --> ");
            horaSaida = sc.next();
            registro.horaSaida = horaSaida;
            valor = registro.calcularValor();//ja esse aqui pertence ao objeto Registro
            System.out.println("Valor total a pagar R$ "+ valor);
        }
    }

    private static Registro pesquisarRegistro(){//trocamos o objeto de Veiculo para Registro
        String placa;
        System.out.println("Placa para pesquisa --> ");
        placa = sc.next().toUpperCase();//uppercase para passar todas as letras para maiuscula
        for (int i = 0; i < indexRegistro; i++){//mudamos o index para o registro
            if (registro[i].veiculo.placa.equals(placa)){
                return registro[i];

            }
        }
        System.out.println("Veículo não encontrado!");
        return null;

    }



    private static void estacionados() {
        for (int i =0; i < indexRegistro; i++) {
            if(registro[i].horaSaida == null) {
                System.out.println(registro[i].veiculo.placa);
            }
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
            veiculoEncontrado = veiculo[indexVeiculo];
            indexVeiculo++;
        }

            System.out.print("Hora de Entrada (hh:mm) --> ");
            horaEntrada = sc.next();
            registro[indexRegistro] = new Registro(veiculoEncontrado, horaEntrada);
            indexRegistro++;

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
