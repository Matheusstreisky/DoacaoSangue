# Cadastro de doadores para banco de sangue

- Este é um projeto para cadastrar pessoas como doadoras em um banco de sangue.
- O projeto consiste num CRUD básico, onde permite ao usuário cadastrar, editar, excluir e listar as pessoas cadastradas. 
- Foi utilizado Spring Data para a criação das tabelas e realização das operações de inserção, edição, exclusão e consulta no banco de dados Postgres.
- Foi utilizado o HTML e JSF para desenvolvimento do front-end.
- Foi utilizado JUnit e Mockito para realização de testes unitários.

## Execução do Projeto:
- Para execução do projeto é necessário a criação prévia de um banco de dados no Postgres com as seguintes configurações:
    - Usuário: postgres
    - Senha: 12345
    - BD: DoacaoSangue
    - Também é possível alterar as configurações de conexão no arquivo: \src\main\resources\application.properties

## Comandos:
- Ir até a pasta do projeto e executar o comando que deseja:
    - Para rodar o programa: **mvnw spring-boot:run**
    - Para rodar somente os testes: **mvnw clean test**
