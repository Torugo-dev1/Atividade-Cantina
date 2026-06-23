package cantina;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CantinaController {

    @FXML
    private ListView<String> listaPedidos;

    @FXML
    private ListView<String> listaAtendidos;

    @FXML
    private TextField campoNovoPedido;

    private ObservableList<String> filaPedidosAbertos;
    private ObservableList<String> filaPedidosAtendidos;

    @FXML
    public void initialize() {
        filaPedidosAbertos = FXCollections.observableArrayList();
        filaPedidosAtendidos = FXCollections.observableArrayList();

        listaPedidos.setItems(filaPedidosAbertos);
        listaAtendidos.setItems(filaPedidosAtendidos);
    }

    @FXML
    public void adicionarPedido() {
        String nomeCliente = campoNovoPedido.getText();

        if (nomeCliente != null && !nomeCliente.trim().isEmpty()) {
            filaPedidosAbertos.add(nomeCliente);
            campoNovoPedido.clear();
        } else {
            mostrarAviso("Por favor, digite o nome do cliente.");
        }
    }

    @FXML
    public void atenderPedido() {
        if (!filaPedidosAbertos.isEmpty()) {
            String pedidoPronto = filaPedidosAbertos.remove(0);
            filaPedidosAtendidos.add(pedidoPronto);
        } else {
            mostrarAviso("Não há pedidos em aberto para atender.");
        }
    }

    @FXML
    public void limparTudo() {
        filaPedidosAbertos.clear();
        filaPedidosAtendidos.clear();
        campoNovoPedido.clear();
    }

    private void mostrarAviso(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Atenção");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}