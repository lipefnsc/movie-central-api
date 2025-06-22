# 🎥 Movie Central API
## Sobre o Projeto

Movie Central API é um projeto de API RESTful que demonstra a aplicação de Design Patterns em um ambiente Spring Boot. A API atua como um serviço centralizado onde usuários podem gerenciar suas listas de filmes favoritos e receber recomendações personalizadas.

A principal característica do projeto é a integração de dados locais, gerenciados com Spring Data JPA, com uma rica fonte de dados externa, a API do The Movie Database (TMDb), acessada de forma elegante através do OpenFeign.

## Conceitos e Design Patterns Aplicados

Este projeto foi construído com foco na aplicação de padrões de projeto clássicos para criar uma arquitetura robusta, manutenível e desacoplada.

**Singleton Pattern**

- Aplicação: Utilizado implicitamente pelo contêiner de Inversão de Controle (IoC) do Spring. Todas as classes anotadas com @Service, @Repository, @RestController e @Component são, por padrão, gerenciadas como beans de escopo Singleton. Isso garante que exista apenas uma instância desses componentes na aplicação, otimizando o uso de recursos e centralizando o estado e o comportamento.

**Facade Pattern**

- Aplicação: Implementado na classe RecommendationFacade. Este padrão fornece uma interface unificada e simplificada para um subsistema complexo. Em vez de o controller precisar conhecer o UserService, o FavoriteMovieService e o TmdbService, ele interage apenas com a RecommendationFacade. A facade esconde toda a complexidade de orquestrar as chamadas entre o banco de dados local e a API externa do TMDb.

**Strategy Pattern**

- Aplicação: O Spring Data JPA é um excelente exemplo do uso do padrão Strategy. Ao definir uma interface como UserRepository, nós delegamos a estratégia de como as consultas ao banco de dados são criadas e executadas para o framework. Podemos facilmente trocar a implementação (por exemplo, de Hibernate para EclipseLink) ou a fonte de dados sem alterar a interface do nosso repositório, que é o contrato.

##  Tecnologias Utilizadas
- **Java 21**
- **Spring Boot:** Framework principal para a construção da API.
- **Spring Web:** Para a criação de endpoints RESTful.
- **Spring Data JPA:** Para persistência de dados.
- **OpenFeign:** Para criar clientes de APIs REST de forma declarativa.
- **Maven:** Gerenciador de dependências.
- **Hibernate:** Implementação padrão do JPA.
- **H2 Database:** Banco de dados em memória para ambiente de desenvolvimento.
- **Springdoc OpenAPI:** Para geração automática da documentação da API com Swagger UI.

## Como Executar o Projeto
Siga os passos abaixo para executar o projeto em seu ambiente local.

**Pré-requisitos**
- **Java Development Kit (JDK)** - Versão 21 ou superior
- **Apache Maven** - Versão 4.0 ou superior
- **Chave da API do TMDb** - Você precisa de uma chave para que a integração funcione.

**Configuração**

**1. Obtenha sua chave da API do TMDb:**
- Crie uma conta em The Movie Database (TMDb).
- Nas configurações da sua conta, vá para a seção "API" e solicite uma chave.
- Com a chave em mãos, abra o arquivo src/main/resources/application.properties.
- Adicione a seguinte linha, substituindo SUA_CHAVE_AQUI:
  `tmdb.api.key=SUA_CHAVE_AQUI`

**Execução**

1. Clone o repositório:
   `git clone https://github.com/lipefnsc/movie-central-api.git`

2. Acesse a pasta do projeto:
   `cd movie-central-api`

3. Execute a aplicação com o Maven:
   `mvn spring-boot:run`

4. A API estará rodando em http://localhost:8080.

## Documentação e Endpoints
A documentação interativa da API, gerada com Swagger UI, está disponível assim que a aplicação é iniciada.

👉 http://localhost:8080/swagger-ui.html

## Endpoints da API

| Método HTTP | Endpoint                         | Descrição                                          |
|:------------|:---------------------------------|:---------------------------------------------------|
| `POST`      | `/users`                         | Cria um novo usuário.                              |
| `GET`       | `/users/{username}`              | Busca os detalhes de um usuário.                   |
| `POST`      | `/users/{username}/favorites`    | Adiciona um filme à lista de favoritos do usuário. |
| `GET`       | `/recommendations/{username}`    | Gera recomendações de filmes para um usuário.      |

## Contato

Felipe Fonseca - devfelipefonseca@outlook.com