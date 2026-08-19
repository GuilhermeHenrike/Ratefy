# Ratefy

## Sobre o Projeto
O Ratefy é uma aplicação web desenvolvida para permitir que usuários descubram, organizem e avaliem álbuns musicais de forma simples e personalizada.
O sistema centraliza a avaliação de álbuns em um único ambiente, permitindo aos usuários criar seus perfis, registrar álbuns e compartilhar suas opiniões por meio de notas e descrições.
aplicação também integra dados de álbuns através da Deezer API, facilitando a busca e o cadastro de músicas e artistas.

### 🛠️ Tecnologias Principais
* **Back-end:** Java 17, Spring Boot, Spring Data JPA, Spring Security (BCrypt), Hibernate, Bean Validation, Banco de Dados Relacional (PostgreSQL)
* **Front-end:** React (Vite), Axios, Material UI (MUI)

---

🌐 Acesso

A aplicação está disponível em produção:

🔗 Acessar aplicação
* [Acessar](https://ratefy-react.vercel.app/)

O projeto foi publicado utilizando:

Frontend: Vercel

Backend: Render

Banco de dados: Neon

Nota: Como o backend está hospedado no plano gratuito do Render, o serviço pode entrar em modo de suspensão após um período de inatividade.
Nesse caso, a primeira requisição pode levar algum tempo para ser processada enquanto o servidor é reativado.

---

## 🗂️ Estrutura do Repositório
O projeto está dividido em duas partes:
* [Back-end (API)](https://github.com/GuilhermeHenrike/Ratefy)
* [Front-end (Interface)](https://github.com/GuilhermeHenrike/Ratefy-React)

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* [Java Development Kit (JDK 17 ou superior)](https://www.oracle.com/java/technologies/downloads/)
* [Maven](https://maven.apache.org/) (ou utilize o wrapper embutido `mvnw`)
* [Node.js](https://nodejs.org/) (versão 18+ recomendada)
* [Git](https://git-scm.com/)

---

### 1. Rodando o Back-end (Spring Boot)

Clone o repositório do back-end, acesse a pasta e inicie a aplicação:

```bash
# Clone o repositório do back-end
git clone <url-do-repo-do-back>

# Execute a aplicação utilizando o Maven
* **Pela IDE:** Abra o projeto na sua IDE (IntelliJ, Eclipse, etc.),
navegue até a classe principal `DemoApplication.java` e clique no botão de **Run** (ícone de play verde).
