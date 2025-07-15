# JavaCalc ☕🔢

![JavaCalc](https://i.imgur.com/uT2dM2x.png) Uma calculadora simples e moderna desenvolvida com JavaFX para a interface gráfica e Kotlin para o motor de cálculos. Este projeto é um ótimo exemplo de uma aplicação desktop multi-módulo construída com Gradle.

## ✨ Funcionalidades

* Operações aritméticas básicas: Adição, Subtração, Multiplicação e Divisão.
* Suporte para números decimais.
* Botão "C" para limpar o display.
* Interface de usuário responsiva e com um tema escuro (dark mode).

## 🚀 Tecnologias Utilizadas

* **Linguagens:** Java 21 e Kotlin 1.9
* **Framework de UI:** JavaFX 21
* **Ferramenta de Build:** Gradle
* **Arquitetura:** Projeto multi-módulo (`core` para a lógica e `ui` para a interface).

## 📋 Pré-requisitos

Para compilar e executar este projeto, você precisará ter instalado:

* **JDK (Java Development Kit)** - Versão 21 ou superior.

## ▶️ Como Executar

1.  **Clone o repositório** para a sua máquina local:
    ```bash
    git clone <https://github.com/phkaiser13/JavaCalc.git>
    ```

2.  **Navegue até o diretório raiz** do projeto:
    ```bash
    cd JavaCalc
    ```

3.  **Execute o projeto** usando o Gradle Wrapper. O comando iniciará a interface gráfica da calculadora.

    * No Windows (usando o Prompt de Comando ou PowerShell):
        ```bash
        .\gradlew.bat ui:run
        ```

    * No Linux ou macOS:
        ```bash
        ./gradlew ui:run
        ```

