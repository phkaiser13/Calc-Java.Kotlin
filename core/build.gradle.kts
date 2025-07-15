// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

/*
 * build.gradle.kts (Módulo core)
 *
 * Este arquivo de build é específico para o módulo 'core'.
 * Ele herda as configurações do build.gradle.kts raiz e adiciona
 * as configurações que se aplicam SOMENTE a este módulo.
 */

// O bloco 'plugins' aplica os plugins necessários para este módulo específico.
plugins {
    // Aqui, nós aplicamos de fato o plugin do Kotlin para a JVM.
    // Diferente do arquivo raiz que tinha 'apply false', aqui estamos dizendo:
    // "Este módulo contém código Kotlin e precisa ser compilado".
    // A versão do plugin já foi definida no arquivo raiz, então não precisamos
    // repeti-la aqui.
    kotlin("jvm")
}

// O bloco 'dependencies' é onde listamos todas as bibliotecas externas
// que este módulo precisa para funcionar.
dependencies {
    // Por enquanto, nosso módulo 'core' é autossuficiente. Ele só precisa
    // da biblioteca padrão do Kotlin (Kotlin Standard Library), que o plugin
    // 'kotlin("jvm")' já adiciona automaticamente para nós.
    // Portanto, este bloco pode ficar vazio por agora.
    // Se precisássemos de uma biblioteca matemática avançada, por exemplo,
    // nós a adicionaríamos aqui.
}