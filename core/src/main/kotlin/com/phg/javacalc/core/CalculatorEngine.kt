// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

package com.pedrohenrique.javacalc.core

/**
 * CalculatorEngine é o cérebro da calculadora.
 *
 * Esta classe gerencia o estado interno e a lógica de todas as operações matemáticas.
 * Ela é completamente independente da interface do usuário (UI), o que significa que
 * poderia ser usada em uma aplicação de console, web ou mobile sem nenhuma alteração.
 *
 * O estado é gerenciado por algumas variáveis-chave:
 * - displayValue: O valor que está sendo exibido na tela.
 * - currentOperand: O primeiro número de uma operação (ex: o '5' em '5 + 3').
 * - pendingOperation: A operação a ser executada (ex: soma, subtração).
 * - waitingForSecondOperand: Um flag para saber se o próximo dígito deve começar um novo número.
 */
class CalculatorEngine {

    // Propriedades privadas para gerenciar o estado interno.
    private var displayValue: String = "0"
    private var currentOperand: Double? = null
    private var pendingOperation: ((Double, Double) -> Double)? = null
    private var waitingForSecondOperand: Boolean = false

    /**
     * Retorna o valor atual que deve ser exibido na tela da calculadora.
     * A UI chamará este método para saber o que mostrar ao usuário.
     */
    fun getDisplayValue(): String {
        return displayValue
    }

    /**
     * Processa a entrada de um dígito numérico (0-9).
     */
    fun inputDigit(digit: Int) {
        if (waitingForSecondOperand) {
            // Se estávamos esperando o segundo número (ex: após clicar em '+'),
            // o novo dígito substitui o valor na tela.
            displayValue = digit.toString()
            waitingForSecondOperand = false
        } else {
            // Caso contrário, anexa o dígito ao número atual.
            // Evita ter múltiplos zeros à esquerda, como "007".
            displayValue = if (displayValue == "0") digit.toString() else displayValue + digit
        }
    }

    /**
     * Processa a entrada do ponto decimal.
     */
    fun inputDecimal() {
        // Adiciona um ponto decimal apenas se ainda não houver um.
        if (!displayValue.contains(".")) {
            displayValue += "."
        }
    }

    /**
     * Processa uma operação (+, -, *, /, =).
     */
    fun performOperation(symbol: String) {
        val valueOnDisplay = displayValue.toDoubleOrNull() ?: return // Converte o texto da tela para número

        // Se uma operação estava pendente, execute-a primeiro.
        // Ex: Se o usuário digitou '5', '+', '3', e agora clica em '-',
        // primeiro calculamos '5 + 3'.
        if (pendingOperation != null && currentOperand != null && !waitingForSecondOperand) {
            val result = pendingOperation!!(currentOperand!!, valueOnDisplay)
            displayValue = formatResult(result)
            currentOperand = result
        } else {
            // Se não, apenas armazena o valor atual.
            currentOperand = valueOnDisplay
        }

        // Prepara para o próximo número.
        waitingForSecondOperand = true

        // Armazena a nova operação, ou limpa se for '='.
        pendingOperation = when (symbol) {
            "+" -> { a, b -> a + b }
            "-" -> { a, b -> a - b }
            "*" -> { a, b -> a * b }
            "/" -> { a, b -> if (b == 0.0) Double.NaN else a / b } // Proteção contra divisão por zero
            else -> null // Para o '=' e outras operações, não há operação pendente.
        }

        // Se o símbolo for '=', o resultado já foi calculado e exibido.
        // Não precisamos fazer mais nada.
    }

    /**
     * Limpa toda a calculadora, resetando-a para o estado inicial.
     */
    fun clear() {
        displayValue = "0"
        currentOperand = null
        pendingOperation = null
        waitingForSecondOperand = false
    }

    /**
     * Formata o resultado para exibição, removendo o '.0' de números inteiros.
     */
    private fun formatResult(number: Double): String {
        return if (number.isNaN()) {
            "Erro" // Mensagem para divisão por zero
        } else if (number % 1.0 == 0.0) {
            number.toLong().toString() // Converte 12.0 para "12"
        } else {
            number.toString() // Mantém 12.5 como "12.5"
        }
    }
}