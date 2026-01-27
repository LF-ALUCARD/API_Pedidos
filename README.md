# Estudo de Caso: Implementação Java com Spring Boot e JPA

## 📜 Descrição do Projeto

Este projeto é um **Estudo de Caso** prático focado na implementação de um modelo conceitual abrangente utilizando o *framework* **Spring Boot** e a especificação **JPA (Java Persistence API)**. O objetivo principal é demonstrar a aplicação de padrões de mercado e boas práticas de programação orientada a objetos (POO) na construção de um sistema de backend robusto.

## 🎯 Objetivos de Aprendizado

O estudo de caso aborda e implementa diversos conceitos cruciais de modelagem e desenvolvimento orientado a objetos:

*   **Modelagem de Dados:** Leitura e implementação de Diagramas de Classes e Objetos da UML.
*   **Associações:** Implementação de diversos tipos de associações (um para um, um para muitos, muitos para muitos).
*   **Padrões de Projeto:** Uso de conceitos como Herança, Classes de Associação, Conceito Dependente e Enumerações.
*   **Persistência:** Utilização do JPA/Hibernate para mapeamento objeto-relacional.

## 🛠️ Tecnologias Utilizadas

As seguintes tecnologias e ferramentas foram utilizadas no desenvolvimento e execução do projeto:

| Categoria | Tecnologia |
| :--- | :--- |
| **Linguagem** | Java (JDK 21+) |
| **Framework** | Spring Boot 3.5.10 |
| **Persistência** | Spring Data JPA / Hibernate |
| **Build** | Maven |
| **Banco de Dados** | PostgreSQL |
| **IDE** | Spring Tool Suite (STS) |
| **Testes** | Postman |

## 📦 Estrutura do Projeto (Modelo Conceitual)

O sistema implementa um modelo de domínio de comércio eletrônico (e-commerce) simplificado, com as seguintes entidades principais:

*   **Produto** e **Categoria** (Associação N:N)
*   **Cliente** e **Endereço** (Associação 1:N)
*   **Pedido** e **ItemPedido** (Classe de Associação)
*   **Pagamento** (com herança para `PagamentoComBoleto` e `PagamentoComCartao`)
*   **Cidade** e **Estado** (Associação N:1)

## 🚀 Funcionalidades (API REST)

O projeto expõe uma API REST básica para manipulação dos dados. Os principais *endpoints* disponíveis incluem:

| Recurso | Método | Endpoint | Descrição |
| :--- | :--- | :--- | :--- |
| **Categorias** | `GET` | `/categorias/{id}` | Recupera uma categoria específica. |
| **Clientes** | `GET` | `/clientes/{id}` | Recupera um cliente e seus endereços. |
| **Pedidos** | `GET` | `/pedidos/{id}` | Recupera um pedido, seus itens e detalhes de pagamento. |

## ⚙️ Como Executar o Projeto

### Pré-requisitos

Certifique-se de ter instalado em sua máquina:

1.  **Java Development Kit (JDK)** versão 8 ou superior.
2.  **Maven** (gerenciador de dependências).
3.  Um cliente Git.

### Instalação

1.  **Clone o repositório:**
    ```bash
    git clone git@github.com:LF-ALUCARD/API_Pedidos.git
    cd cursomc
    ```
    *(O nome do projeto original é `cursomc`)*

2.  **Construa o projeto com Maven:**
    ```bash
    mvn clean install
    ```

### Execução

1.  **Execute a aplicação Spring Boot:**
    ```bash
    mvn spring-boot:run
    ```

2.  A aplicação será iniciada na porta padrão `8080` (ou na porta configurada em `application.properties`).

### Testes

Utilize o **Postman** ou ferramenta similar para testar os *endpoints* da API.

*   **Exemplo de requisição:** `GET http://localhost:8080/categorias/1`

Os dados iniciais (povoamento/seeding) são carregados automaticamente ao iniciar a aplicação, permitindo que você teste os *endpoints* imediatamente.
