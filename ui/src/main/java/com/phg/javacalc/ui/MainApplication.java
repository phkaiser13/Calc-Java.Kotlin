// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

package com.phg.javacalc.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

/**
 * MainApplication (Versão Final)
 *
 * Esta é a classe de entrada final. Sua única responsabilidade é carregar
 * a visão a partir do arquivo FXML, aplicar a folha de estilos CSS e
 * exibir a janela (Stage).
 */
public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. Criar o FXMLLoader.
        // Esta classe é o motor que lê o FXML e constrói o grafo de cena JavaFX.
        FXMLLoader loader = new FXMLLoader();

        // 2. Especificar a localização do arquivo FXML.
        // Usamos getClass().getResource() para encontrar o arquivo no nosso classpath.
        // Isso garante que funcione independentemente de como a aplicação é empacotada.
        URL fxmlUrl = getClass().getResource("calculator-view.fxml");
        loader.setLocation(fxmlUrl);

        // 3. Carregar o FXML.
        // Este método faz a mágica: parseia o XML, instancia os componentes
        // e o controlador, e conecta tudo. O resultado é o nó raiz da nossa UI.
        Parent rootNode = loader.load();

        // 4. Criar a cena com o nó raiz carregado do FXML.
        Scene scene = new Scene(rootNode, 320, 500);

        // 5. Encontrar e aplicar nossa folha de estilos CSS.
        // O processo é semelhante: encontramos o arquivo CSS como um recurso
        // e o adicionamos à lista de folhas de estilo da cena.
        URL cssUrl = getClass().getResource("styles.css");
        scene.getStylesheets().add(Objects.requireNonNull(cssUrl).toExternalForm());

        // 6. Configurar e exibir o palco (a janela).
        primaryStage.setTitle("Calculadora Bonita");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Opcional: impede o redimensionamento da janela.
        primaryStage.show();
    }
}