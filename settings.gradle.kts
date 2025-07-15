// 2025
// By Pedro henrique garcia.
// Github/gitlab: Phkaiser13

/*
 * settings.gradle.kts
 *
 * Este é o arquivo de configurações do Gradle.
 * A principal responsabilidade dele em um projeto multi-módulo é declarar
 * quais subdiretórios são módulos incluídos no build.
 *
 * Quando o Gradle é executado, ele lê este arquivo primeiro para entender
 * a estrutura completa do projeto antes de começar a compilar qualquer coisa.
 */

// Define o nome do projeto raiz. Isso é útil para a organização e para
// como o projeto será exibido em IDEs como o IntelliJ.
rootProject.name = "JavaCalc"

// A função include() é a parte mais importante aqui.
// Ela informa ao Gradle para procurar por um arquivo build.gradle.kts
// dentro dos diretórios 'core' e 'ui' e tratá-los como submódulos
// independentes, mas que fazem parte do mesmo projeto.
include("core", "ui")