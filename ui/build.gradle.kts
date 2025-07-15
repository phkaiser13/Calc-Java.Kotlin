// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

/*
 * build.gradle.kts (Módulo ui)
 *
 * Este é o arquivo de build para o módulo de interface do usuário (UI).
 * Ele configura o JavaFX, define a classe principal da aplicação e,
 * crucialmente, estabelece a dependência com o módulo 'core'.
 */

plugins {
    // O plugin 'application' é usado para projetos que geram um executável.
    // Ele nos dá tarefas como 'run' para executar a aplicação diretamente
    // pelo Gradle. Ele também aplica o plugin 'java' automaticamente.
    application

    // Plugin oficial para facilitar a integração com o JavaFX.
    // Ele gerencia o download das bibliotecas do JavaFX e as configurações
    // necessárias para a JVM executá-las.
    id("org.openjfx.javafxplugin") version "0.1.0"
}

// O bloco 'javafx' é configurado pelo plugin 'org.openjfx.javafxplugin'.
javafx {
    // Define a versão do JavaFX que queremos usar. Usar uma versão recente é bom.
    version = "21"
    // Especifica quais módulos do JavaFX nossa aplicação precisa.
    // 'javafx.controls' é essencial para botões, labels, etc.
    // 'javafx.fxml' é para carregar layouts de arquivos FXML (uma boa prática).
    modules("javafx.controls", "javafx.fxml")
}

application {
    // Define o ponto de entrada da nossa aplicação.
    // Estamos dizendo ao Gradle: "Quando alguém rodar este projeto, a classe
    // a ser executada é a 'MainApplication' dentro do pacote especificado".
    // Nós ainda não criamos este arquivo, mas vamos criá-lo em seguida.
    mainClass.set("com.pedrohenrique.javacalc.ui.MainApplication")
}

dependencies {
    // ESTA É A LINHA MAIS IMPORTANTE PARA A MODULARIZAÇÃO.
    // 'implementation(project(":core"))' diz ao Gradle que o módulo 'ui'
    // DEPENDE do módulo 'core'.
    // Isso significa que o código no 'ui' pode importar e usar as classes
    // do 'core' (como a nossa CalculatorEngine). O Gradle garantirá que o 'core'
    // seja compilado antes do 'ui'.
    implementation(project(":core"))
}