package entities;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private final int andares;
    private final List<Apto> hotel;

    public Hotel(int andares) throws Exception {
        if (andares <= 0) throw new Exception("Número de andares inválidos.");

        this.andares = andares;
        this.hotel = new ArrayList<>();

        for (int andar = 1; andar <= andares; andar++) {
            int quantidadeApartamentos = calcularQuantidadeApartamentos(andar);

            for (int i = 0; i < quantidadeApartamentos; i++) {
                Apto apto = criarApto(andar, i);
                apto.setNumero(andar * 100 + i + 1);
                this.hotel.add(apto);
            }
        }
    }

    private int calcularQuantidadeApartamentos(int andar) {
        int porcentagem = andar * 100 / andares;
        return switch (porcentagem) {
            case 20 -> 10;
            case 15 -> 20;
            case 30 -> 15;
            default -> 5;
        };
    }

    private Apto criarApto(int andar, int indice) {
        Apto apto = new Apto();

        apto.setNumero(andar * 100 + indice + 1);

        switch (andar) {
            case 2:
                apto.setCapacidade(2 + 1);
                apto.setComCamaDeCasal(true);
                break;
            case 3:
                apto.setCapacidade(1);
                break;
            case 4:
                apto.setCapacidade(2);
                break;
            case 5:
                apto.setCapacidade(3);
                break;
            default:
                apto.setCapacidade(4);
                apto.setComCamaDeCasal(false);
                break;
        }

        apto.setOcupado(false);
        apto.setInterditado(false);

        return apto;
    }
    public void interdite(int numero) throws Exception {
        if (numero < 0) throw new Exception("Número de identificação do apartamento vazio.");
        boolean numeroApExiste = false;
        for (Apto apto : this.hotel) {
            if (apto.getNumero() == numero) {
                apto.setInterditado(true);
                numeroApExiste = true;
                break;
            }
        }
        if (!numeroApExiste) throw new Exception("Número de identificação do apartamento não encontrado.");
    }

    public void ocupe(int numero) throws Exception {
        if (numero < 0) throw new Exception("Número de identificação do apartamento vazio.");
        boolean numeroApExiste = false;
        for (Apto apto : this.hotel) {
            if (apto.getNumero() == numero) {
                apto.setOcupado(true);
                numeroApExiste = true;
                break;
            }
        }
        if (!numeroApExiste) throw new Exception("Número de identificação do apartamento não encontrado.");
    }

    public void desocupe(int numero) throws Exception {
        if (numero < 0) throw new Exception("Número de identificação do apartamento vazio.");
        boolean numeroApExiste = false;
        for (Apto apto : this.hotel) {
            if (apto.getNumero() == numero) {
                apto.setOcupado(false);
                numeroApExiste = true;
                break;
            }
        }
        if (!numeroApExiste) throw new Exception("Número de identificação do apartamento não encontrado.");
    }

    public int capacidade() {
        int capacidade = 0;
        for (Apto apto : this.hotel) {
            if (!(apto.isOcupado() || apto.isInterditado())) capacidade += apto.getCapacidade();
        }
        return capacidade;
    }

    @Override
    public String toString() {
        String result = "";
        for (Apto apto : this.hotel) result += apto.toString() + "\n";
        return result;
    }

}
