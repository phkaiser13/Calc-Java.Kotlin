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
    group = "com.phg.javacalc"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }

    // ADICIONE ESTE BLOCO DE CÓDIGO
    // Isso configura a "toolchain" (cadeia de ferramentas) do Java.
    // Ele diz ao Gradle que todos os submódulos devem ser compilados
    // usando um JDK de versão 21.
    // Se o Gradle não encontrar um JDK 21 já configurado, ele pode até
    // baixá-lo automaticamente para você. Isso torna o build muito robusto.
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }
}