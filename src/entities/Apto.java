package entities;

public class Apto implements Comparable<Apto> {
    private int numero;
    private int capacidade;
    private boolean comCamaDeCasal;
    private boolean ocupado;
    private boolean interditado;

    public Apto() {
    }

    public Apto(int numero, int capacidade, boolean comCamaDeCasal, boolean ocupado, boolean interditado) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.comCamaDeCasal = comCamaDeCasal;
        this.ocupado = ocupado;
        this.interditado = interditado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isComCamaDeCasal() {
        return comCamaDeCasal;
    }

    public void setComCamaDeCasal(boolean comCamaDeCasal) {
        this.comCamaDeCasal = comCamaDeCasal;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isInterditado() {
        return interditado;
    }

    public void setInterditado(boolean interditado) {
        this.interditado = interditado;
    }

    @Override
    public int compareTo(Apto apto) {
        if (apto == null) try {
            throw new Exception("Apartamento sem informações");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Integer.compare(this.capacidade, apto.capacidade);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Apto apto = (Apto) o;
        return numero == apto.numero && capacidade == apto.capacidade && comCamaDeCasal == apto.comCamaDeCasal && ocupado == apto.ocupado && interditado == apto.interditado;
    }

    @Override
    public int hashCode() {
        int hash = 777;
        hash = 31 * hash + Integer.valueOf(numero).hashCode();
        hash = 31 * hash + Integer.valueOf(capacidade).hashCode();
        hash = 31 * hash + (comCamaDeCasal ? 1 : 0);
        hash = 31 * hash + (ocupado ? 1 : 0);
        hash = 31 * hash + (interditado ? 1 : 0);
        if (hash < 0) hash = -hash;
        return hash;
    }

    @Override
    public String toString() {
        return "Apartamento : " + "n°" + numero + ", capacidade: " + capacidade + ", " + (comCamaDeCasal ? "com cama de casal " : "sem cama de casal ") + "," + (ocupado ? " está ocupado" : " está vazio") + " e " + (interditado ? "está interditado." : "não está inteditado.");
    }
}
