# BandRehearsal — Etapa 1 (Android Views)

Projeto acadêmico da etapa parcial usando Android Views/XML e dados simulados.

## O que está implementado

- 2 telas em XML.
- Dashboard com `RecyclerView` e músicas mockadas.
- `TextView`, `ImageView`, `Space`, `LinearLayout`, `FrameLayout` e `RecyclerView`.
- Item XML reutilizável (`item_musica.xml`).
- Modelo imutável `data class Musica`.
- Campo opcional `observacao: String?` tratado com fallback.
- Navegação por `Intent` explícita.
- Passagem do nome da música, BPM e observação por extras.
- Tela 2 usa `findViewById`, conforme a proposta da atividade.
- Botões `+` e `-` alteram o BPM e atualizam o `TextView` imediatamente.
- Tela 1 usa ViewBinding.
- Sem API e sem banco de dados, como exigido na Etapa 1.

## Como abrir

1. Extraia o ZIP.
2. Se `gradle/wrapper/gradle-wrapper.jar` ainda não existir, execute `PREPARAR_GRADLE.bat` uma vez. Ele baixa o wrapper oficial e confere o SHA-256.
3. No Android Studio, use **Open** e selecione a pasta `BandRehearsal`.
4. Aguarde o Gradle Sync.
5. Se o Android Studio pedir o SDK 35, instale-o pelo SDK Manager.
6. Rode em um emulador ou aparelho Android API 24+.

## Gradle / Java

O projeto usa Android Gradle Plugin 9.4.0 e Gradle 9.6.0. O Gradle 9.6 suporta execução em Java 25, evitando o conflito que acontece com Gradle 8.9 + JVM 25.

## Fluxo para apresentar

1. Abrir o app: aparece o Dashboard do ensaio.
2. Mostrar a lista mockada no RecyclerView.
3. Tocar em qualquer música.
4. Explicar que a segunda Activity recebeu título e BPM pela Intent.
5. Pressionar `+` ou `-` e mostrar que o `TextView` do BPM muda.
6. Voltar ao repertório.

## Anotações por música

- Na tela da música, "Anotações do ensaio" é um `EditText` multilinha de texto livre.
- O texto é salvo por música (chave = título) em `SharedPreferences`, via `storage/NotasStorage.kt`.
- Salva ao tocar em "Salvar anotação" e também automaticamente em `onPause`.
- O Dashboard recarrega as anotações em `onResume`.
- Continua sem banco de dados; na Etapa 2 `NotasStorage` pode ser trocado por Room.

## Etapa 2

A próxima etapa pode substituir os mocks por Room + Repository + Flow/StateFlow e implementar a UI dinâmica em Compose, sem misturar banco/API nesta entrega parcial.


## Android SDK
O projeto usa `compileSdk = 36`, `targetSdk = 35` e `minSdk = 24`. Se o Android Studio solicitar, instale o Android SDK Platform 36 pelo SDK Manager.
