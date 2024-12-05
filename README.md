# Literalura

<img src="/src/main/assets/screenshot/screenshot_2024_12_04.png" alt="Capitura de tela do menu interativo." width="50%" height="auto"> 

## 🔎 Descrição
O `Literalura` é uma aplicação Java que permite que os usuários possam buscar e gerenciar informações sobre livros e autores, integrando-se à API Gutendex. A aplicação também permite realizar buscas por títulos, listar livros e autores registrados, buscar autores vivos em um determinado ano e filtrar livros por um determinado idioma.

## 🔨 Funcionalidades
- `Buscar livro pelo título:` Permite procurar por um livro específico na API e verificar se ele já está registrado no sistema.
- `Listar livros registrados:` Exibe todos os livros armazenados no banco de dados.
- `Listar autores registrados:` Exibe todos os autores armazenados no banco de dados.
- `Listar autores vivos em determinado ano:` Filtra os autores com base no ano informado.
- `Listar livros por idioma:` Permite buscar livros registrados com base em um idioma específico.

## 🔬 Tecnologias Utilizadas
 <div style="display: flex; align-items: center;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" style="width: 40px; height: auto; margin-right: 10px;">
  <p>Linguagem <b>Java</b>. <b>Java Streams</b> para processamento de informações. <b>Scanner</b> para entrada de dados via terminal.</p>
</div>

 <div style="display: flex; align-items: center;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/fastapi/fastapi-original.svg" style="width: 40px; height: auto; margin-right: 10px;">
  <p><b>API Gutendex</b> para consumo de dados sobre livros.</p>
</div>

<div style="display: flex; align-items: center;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-original-wordmark.svg" style="width: 40px; height: auto; margin-right: 10px;">
  <p><b>Banco de dados</b> para armazenamento de informações.</p>
</div>

<div style="display: flex; align-items: center;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" style="width: 40px; height: auto; margin-right: 10px;">
  <p><b>Intelij</b> IDE utilizada para o desenvolvimento da aplicação.</p>
</div>

## 📂 Estrutura do Projeto
O projeto segue uma arquitetura organizada com as seguintes camadas principais:

- **Model:** Contém classes que representam as entidades principais do sistema, como `Book`, `Author` e `ResponseApi`.
- **Repository:** Interface que define métodos para interagir com o banco de dados.
- **Service:** Camada de serviços que inclui funcionalidades como consumo de API, conversão de dados e limpeza de terminal.
- **Principal:** Classe principal que gerencia o fluxo do programa e apresenta um menu interativo ao usuário.

## 💁 Como Executar o Projeto
1. Clone este repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```
2. Importe o projeto em sua IDE favorita (recomendado: IntelliJ IDEA).
3. Configure o banco de dados e as dependências necessárias.
4. Execute a classe `Principal`.
5. Navegue pelo menu interativo para explorar as funcionalidades.

## 👀 Estrutura do Menu Interativo
O menu apresenta as seguintes opções:

```
------------------------------
1. Buscar livro pelo título.
2. Listar livros registrados.
3. Listar autores registrados.
4. Listar autores vivos em determinado ano.
5. Listar livros em um determinado idioma.

0 - Pressione 0 para encerrar a aplicação.
------------------------------
```

## 💻 Exemplo de Uso
**1. Buscar livro pelo título:**
- Digite o título desejado, e o sistema irá consultar a API Gutendex para buscar informações sobre o livro. Caso o livro ou autor não estejam registrados no banco de dados, serão adicionados automaticamente.

**2. Listar livros registrados:**
- O sistema exibirá todos os livros armazenados localmente, incluindo detalhes como título, idioma e número de downloads.

**3. Listar autores vivos em determinado ano:**
- Insira o ano, e o sistema filtrará os autores registrados que estavam vivos nesse período.

## 💪 Contribuições
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:
1. Faça um fork deste repositório.
2. Crie um branch para sua funcionalidade:
   ```bash
   git checkout -b minha-funcionalidade
   ```
3. Realize suas alterações e faça commit:
   ```bash
   git commit -m "Adiciona nova funcionalidade"
   ```
4. Envie suas alterações:
   ```bash
   git push origin minha-funcionalidade
   ```
5. Abra um Pull Request.

---
Desenvolvido com ❤ por Gabriel Lobo.

