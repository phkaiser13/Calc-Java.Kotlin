// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

package com.phg.javacalc.ui;

import com.phg.javacalc.ui.controller.CalculatorController; // <-- 1. IMPORTAR O CONTROLADOR
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent; // Import já estava presente, agora será usado

import java.net.URL;
import java.util.Objects;

/**
 * MainApplication (Versão Final)
 *
 * Esta é a classe de entrada final. Sua responsabilidade é carregar
 * a visão do FXML, aplicar o CSS, conectar o suporte a teclado e
 * exibir a janela (Stage).
 */
public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL fxmlUrl = getClass().getResource("calculator-view.fxml");
        loader.setLocation(fxmlUrl);

        Parent rootNode = loader.load();

        // 2. OBTER A INSTÂNCIA DO CONTROLADOR
        // Após o 'loader.load()' ser chamado, o FXMLLoader já criou uma instância
        // do nosso controlador. Podemos pegá-la para usar seus métodos.
        CalculatorController controller = loader.getController();

        Scene scene = new Scene(rootNode, 320, 500);

        // 3. ADICIONAR O LISTENER DE TECLADO À CENA
        // O método setOnKeyPressed usa uma expressão lambda para definir o que
        // acontece quando uma tecla é pressionada.
        // Nós simplesmente delegamos o evento para um novo método no controlador.
        scene.setOnKeyPressed(event -> controller.handleKeyEvent(event));

        URL cssUrl = getClass().getResource("styles.css");
        scene.getStylesheets().add(Objects.requireNonNull(cssUrl).toExternalForm());

        primaryStage.setTitle("Calculadora Bonita");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}