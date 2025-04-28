import controller.ConsumoController;
import model.ConsumokWH;
import view.ConsumoView;

public class Main {
    public static void main(String[] args) {
        ConsumokWH consumo = new ConsumokWH(30); 
        ConsumoController controller = new ConsumoController();
        ConsumoView view = new ConsumoView();

        for (int d = 0; d < 30; d++) {
            for (int h = 0; h < 23; h++) {
                consumo.setConsumo(d, h, Math.random() * 900);
            }
        }

        controller.cambiarConsumoHora(consumo, 1, 5, 250.0);

        double consumoMin = controller.hallarConsumoMinimo(consumo);
        view.mostrarConsumoMinimo(consumoMin);

        double consumoMax = controller.hallarConsumoMaximo(consumo);
        view.mostrarConsumoMaximo(consumoMax);

        double[] franjas = controller.hallarConsumoPorFranjas(consumo);
        view.mostrarConsumoPorFranjas(franjas);

        double[] consumoDias = controller.hallarConsumoPorDias(consumo);
        view.mostrarConsumoPorDias(consumoDias);
    }
}