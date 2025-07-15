// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

/*
 * build.gradle.kts (Raiz)
 *
 * Este é o arquivo de build do projeto raiz. Sua principal função em um
 * projeto multi-módulo é configurar aspectos que são COMUNS a todos os
 * submódulos (core, ui).
 *
 * Isso segue o princípio DRY (Don't Repeat Yourself - Não se Repita).
 */

// O bloco 'plugins' no nível raiz é usado para declarar as versões dos plugins
// que os submódulos poderão usar.
plugins {
    // Declara o plugin do Kotlin para a JVM (Java Virtual Machine).
    // A versão é gerenciada pelo Gradle. 'apply false' significa que o plugin
    // é apenas disponibilizado aqui, mas cada submódulo deve aplicá-lo ativamente
    // se precisar dele. Isso evita que o projeto raiz, que não tem código,
    // tente se configurar como um projeto Kotlin.
    kotlin("jvm") version "1.9.23" apply false
}

// O bloco 'subprojects' aplica uma configuração a TODOS os submódulos
// que foram declarados no settings.gradle.kts (ou seja, 'core' e 'ui').
subprojects {
    // Define o 'group' para os artefatos gerados (os .jar). É uma convenção
    // usar um domínio reverso. Isso ajuda a identificar unicamente seus projetos.
    group = "com.pedrohenrique.javacalc"
    // Define a versão inicial do nosso projeto.
    version = "1.0.0"

    // O bloco 'repositories' diz ao Gradle onde procurar por bibliotecas (dependências).
    repositories {
        // mavenCentral() é o repositório mais comum e vasto de bibliotecas Java/Kotlin.
        // É como se fosse a "loja de aplicativos" padrão para nossas dependências.
        mavenCentral()
    }
}