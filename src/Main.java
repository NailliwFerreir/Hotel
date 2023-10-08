import entities.Hotel;

public class Main {
    public static void main(String[] args) throws Exception {
        //Criando Hotel
        Hotel hotel = new Hotel(1);
        System.out.println(hotel);
        // Interditando apartamento-> se não exister o apartamento é lançado exceção
        hotel.interdite(101);
        // Ocupando apartamento-> se não exister o apartamento é lançado exceção
        hotel.ocupe(201);
        hotel.ocupe(203);
        System.out.println(hotel);
        //Verificando a capacidade do apartamento
        System.out.println("Capacidade de pessoas no :" + hotel.capacidade());
    }
}