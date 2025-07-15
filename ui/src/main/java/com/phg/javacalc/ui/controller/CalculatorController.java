// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

package com.phg.javacalc.ui.controller;

import com.phg.javacalc.core.CalculatorEngine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent; // NOVO: Import necessário para eventos de teclado.

/**
 * CalculatorController (Versão Final)
 *
 * Esta versão do controlador inclui:
 * - Lógica de clique do botão via FXML.
 * - Tratamento do estado de "Erro".
 * - Ajuste dinâmico do tamanho da fonte do display.
 * - Manipulação de entrada do teclado físico.
 */
public class CalculatorController {

    @FXML
    private Label display;

    private final CalculatorEngine engine = new CalculatorEngine();

    @FXML
    public void initialize() {
        updateDisplay();
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        // Se a calculadora está em estado de erro, só permita a ação 'Clear'.
        if (display.getText().equals("Erro")) {
            if (((Button) event.getSource()).getText().equals("C")) {
                engine.clear();
                updateDisplay();
            }
            return; // Ignora qualquer outro clique
        }

        Button clickedButton = (Button) event.getSource();
        String text = clickedButton.getText();
        processInput(text); // Lógica de processamento foi movida para um método separado
    }

    /**
     * NOVO: Manipula eventos vindos do teclado físico.
     * Este método precisa ser chamado a partir da classe MainApplication.
     * @param event O evento de tecla pressionada.
     */
    public void handleKeyEvent(KeyEvent event) {
        // Se a calculadora está em estado de erro, só permita a ação 'Clear' (tecla Esc).
        if (display.getText().equals("Erro")) {
            if (event.getCode() == javafx.scene.input.KeyCode.ESCAPE) {
                engine.clear();
                updateDisplay();
            }
            return; // Ignora qualquer outra tecla
        }

        String keyText = event.getText();

        // Mapeia teclas especiais que não produzem um 'texto'
        switch (event.getCode()) {
            case ESCAPE:
                keyText = "C";
                break;
            case ENTER:
                keyText = "=";
                break;
        }

        processInput(keyText);
    }

    /**
     * NOVO: Centraliza a lógica de processamento de entrada (de botões ou teclado).
     * @param input O texto a ser processado (ex: "7", "+", "C").
     */
    private void processInput(String input) {
        try {
            int digit = Integer.parseInt(input);
            engine.inputDigit(digit);
        } catch (NumberFormatException e) {
            switch (input) {
                case ".": case ",": // Aceita tanto ponto quanto vírgula (do teclado numérico)
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
                    engine.performOperation(input);
                    break;
            }
        }
        updateDisplay();
    }

    /**
     * MODIFICADO: Atualiza o display e ajusta o tamanho da fonte dinamicamente.
     */
    private void updateDisplay() {
        String text = engine.getDisplayValue();
        display.setText(text);

        // Lógica para ajustar o tamanho da fonte com base no comprimento do texto
        if (text.length() > 9) {
            display.setStyle("-fx-font-size: 32pt;");
        } else if (text.length() > 6) {
            display.setStyle("-fx-font-size: 48pt;");
        } else {
            // Retorna ao tamanho padrão definido no CSS (ou um padrão aqui)
            display.setStyle("-fx-font-size: 60pt;");
        }
    }
}