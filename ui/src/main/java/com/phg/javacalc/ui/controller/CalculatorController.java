// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

package com.pedrohenrique.javacalc.ui.controller;

import com.pedrohenrique.javacalc.core.CalculatorEngine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * CalculatorController (Versão FXML)
 *
 * Esta versão do controlador é projetada para funcionar com um arquivo FXML.
 * A criação da UI foi movida para o 'calculator-view.fxml'.
 * A responsabilidade desta classe é puramente de 'controlar' a UI.
 *
 * As anotações @FXML são a cola entre o arquivo FXML e este código Java.
 */
public class CalculatorController {

    // A anotação @FXML diz ao FXMLLoader para injetar o componente
    // com fx:id="display" do arquivo FXML nesta variável.
    @FXML
    private Label display;

    // A instância do nosso motor lógico permanece a mesma.
    private final CalculatorEngine engine = new CalculatorEngine();

    /**
     * Este método é chamado AUTOMATICAMENTE pelo FXMLLoader depois que o arquivo FXML
     * é carregado e todos os campos @FXML foram injetados.
     * É o lugar perfeito para fazer qualquer configuração inicial.
     */
    @FXML
    public void initialize() {
        // Garante que o display comece sincronizado com o estado inicial do engine.
        updateDisplay();
    }

    /**
     * Manipula o evento de clique de QUALQUER botão definido no FXML.
     * O FXML foi configurado para que todos os botões chamem este método (onAction="#handleButtonClick").
     *
     * @param event O evento de ação, que contém informações sobre o que aconteceu,
     *              incluindo qual botão foi a fonte do evento.
     */
    @FXML
    private void handleButtonClick(ActionEvent event) {
        // 1. Descobrir qual botão foi clicado.
        Button clickedButton = (Button) event.getSource();
        String text = clickedButton.getText();

        // 2. A lógica para processar o texto é exatamente a mesma de antes.
        try {
            int digit = Integer.parseInt(text);
            engine.inputDigit(digit);
        } catch (NumberFormatException e) {
            switch (text) {
                case ".":
                    engine.inputDecimal();
                    break;
                case "C":
                    engine.clear();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "=":
                    engine.performOperation(text);
                    break;
            }
        }

        // 3. Após cada ação, atualizamos o display.
        updateDisplay();
    }

    /**
     * Atualiza o texto do display com o valor atual do CalculatorEngine.
     * Este método não muda, mas agora ele opera no Label que foi injetado pelo FXML.
     */
    private void updateDisplay() {
        display.setText(engine.getDisplayValue());
    }
}