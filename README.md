## Projeto de Lista de Jogos
Esse projeto foi desenvolvido em um intensivão do canal [DevSuperior](https://www.youtube.com/@DevSuperior), no qual, construi uma API utilizando padrões de projeto e boas práticas com Java Spring. 

### Requisitos para rodar o projeto
- **Java JDK** versão 21 ou superior
- **Maven** versão 3.9.9 ou superior

### Como rodar o projeto

### Tecnologias utilizadas
- Java 
- Spring 
- Spring boot
- H2 (para ambiente de teste)
- PostgreSQL (para ambiente de homologação)
- Docker
- Postman
- Swagger

### Diagrama de classes

![imagem do diagrama de classes](image.png)

O diagrama de classes nos ajuda a compreender o domínio de negócio, representando as entidades, atributos e seus relacionamentos de forma clara. Essa estrutura serve como base para a construção do ORM com o JPA, que realiza o mapeamento das classes e relações para tabelas e colunas no banco de dados.

- A classe Game foi mapeada como uma tabela no banco que armazena os dados dos jogos
- A classe GameList foi mapeada como uma tabela no banco que armazena os dados das listas de jogos
- No relacionamento entre as duas classes tem o Belonging, que será mapeada como uma tabela intermediária entre Game e GameList. Ela vai guardar a posição do jogo na lista.

### Estrutura do projeto

Para boas práticas na estruturação do projeto, foram adicionadas alguns diretórios no sistema.

- controllers: tem todos os controllers que são responsáveis por gerenciar as requisições feitas para a API
- entity: tem todas as classes do modelo de negócio, que são mapeadas como tabelas no banco de dados.
- services: tem todas as services que são responsáveis por trabalhar com as regras de negócio do sistema.
- repositories: guarda todos os repositórios do JPA, ou seja, é a camada que acessa os dados com métodos herdados do JPA. Também é possível fazer queries personalizadas nesses repositórios.
- DTO: esse diretório armazena todos os DTOs do sistema, que são fundamentais para segurança, pois, com eles é possível selecionar dados especificos das entidades, evitando exibir a entidade na API.
- projections: são utilizados para deixar as consultas personalizadas mais rapidas e também serve para encapsular determinados dados, assim como o DTO.

### Perfis de projeto
No diretório resources tem alguns perfis de projeto, que servem para ajustar o ambiente:
- application-test: configuraçãoes para desenvolvimento/teste
- application-dev: configurações para homologação
- application-prod: configurações para produção

### API

| Método | Endpoint                         | Descrição                                            | Exemplo de Corpo (se aplicável)             |
|--------|----------------------------------|------------------------------------------------------|---------------------------------------------|
| GET    | `/games`                         | Retorna os dados mais relevantes de todos os jogos.  | -                                           |
| GET    | `/games/{gameId}`                | Retorna todos os dados do jogo com o ID especificado.| -                                           |
| GET    | `/lists`                         | Retorna todas as listas de jogos.                    | -                                           |
| GET    | `/lists/{gameListId}/games`      | Retorna todos os jogos de uma determinada lista.     | -                                           |
| POST   | `/lists/{gameListId}/replacement`| Troca a posição de um jogo na lista.                 | { "sourceIndex": 0, "destinationIndex": 4 } |

Caso você queira mais detalhes da documentação com uma interface do swagger, após executar o projeto acesse o endereço http://localhost:8080/swagger-ui/index.html


