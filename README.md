# BandRehearsal — Documentação do Projeto

Documento explicativo da estrutura e funcionalidades do projeto **BandRehearsal**.

---

## 1. Descrição do Aplicativo

O **BandRehearsal** é um aplicativo Android desenvolvido para auxiliar bandas no acompanhamento do seu repertório de ensaios. O aplicativo permite visualizar a lista de músicas, acessar os detalhes e o metrônomo de cada faixa e salvar anotações personalizadas.

---

## 2. Estrutura do Código e Arquivos

### Camada de Modelo e Dados
* `model/Musica.kt`: Classe de dados que representa a estrutura de uma música no repertório.
* `MockData.kt`: Arquivo contendo a lista estática de dados simulados (mocks) para exibição na interface.
* `storage/NotasStorage.kt`: Classe responsável pelo armazenamento local de anotações utilizando `SharedPreferences`.

### Interface e Apresentação
* `MainActivity.kt`: Activity principal que exibe o dashboard com a lista de músicas.
* `MetronomeActivity.kt`: Activity de detalhes e ajuste de BPM da música selecionada.
* `adapter/MusicaAdapter.kt`: Adapter para gerenciamento e vinculação dos dados ao `RecyclerView`.

### Layouts e Recursos (XML)
* `activity_main.xml`: Layout da tela principal com a lista de músicas.
* `activity_metronome.xml`: Layout da tela de detalhes e controle do metrônomo.
* `item_musica.xml`: Layout reutilizável para cada item da lista do `RecyclerView`.
* `bg_note.xml` e `bg_music_icon.xml`: Recursos visuais de fundo para os elementos da interface.
* `strings.xml`, `colors.xml` e `themes.xml`: Arquivos de definição de textos, cores e temas visuais.

### Configuração do Projeto
* `build.gradle.kts` e `app/build.gradle.kts`: Scripts de configuração e dependências do Gradle.
* `AndroidManifest.xml`: Registro de componentes e permissões do aplicativo Android.
* `PREPARAR_GRADLE.bat`: Script utilitário para baixar e preparar o Gradle Wrapper.

---

## 3. Fluxo de Funcionamento

1. A tela principal (`MainActivity`) carrega a lista de músicas disponibilizada por `MockData` e a exibe através do `MusicaAdapter`.
2. Ao selecionar uma música, é disparada uma `Intent` explícita que abre a `MetronomeActivity` passando os dados da faixa.
3. Na `MetronomeActivity`, é possível ajustar o valor do BPM e registrar anotações sobre a música.
4. As anotações inseridas são salvas localmente através do `NotasStorage` via `SharedPreferences`.

---

## 4. Instruções de Execução

1. Abra a pasta `BandRehearsal` no Android Studio.
2. Caso o Wrapper do Gradle não esteja presente na estrutura, execute o arquivo `PREPARAR_GRADLE.bat`.
3. Aguarde a conclusão da sincronização do Gradle (`build.gradle.kts`).
4. Execute o projeto em um emulador ou dispositivo físico com suporte para Android API 24 ou superior.
