## Descrição
A aplicação tem como objetivo o gerenciamento de livros através de um crud feito em Java + Spring Boot, além da utilização de uma
interface básica para visualização dos cadastros no banco de dados (SQLite).

## Utilização:
Ao utilizar essa aplicação, definir no application.properties o local que o banco de dados será gerado.
```bash
PersonalLibrary/src/main/resources/application.properties
```
Após isso, inicializar a aplicação PersonalLibraryApplication.java.

Para ter acesso à interface frontend com HTML, CSS e Javascript Acessar: Http://localhost:8080 definido como padrão das aplicações Spring Boot.

## Interface:
Na página inicial é gerado uma lista com os livros cadastrados dentro do sistema.
Para cadastrar um livro, no canto superior direito 'Adicionar Livro' e completar as informações para ser gerado a entidade Livro.
Cada livro tem a função de ser editado e deletado.
