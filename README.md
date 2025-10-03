# Projeto MovieRating
CRUD simples desenvolvido em Java com Spring Boot.
O objetivo do projeto é permitir adicionar, listar, buscar, atualizar e deletar filmes com título, avaliação e review.

## Tecnologias utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Funcionalidades
- **POST** `/movies/` = Adiciona um filme a lista
- **GET** `/movies/` = Lista todos os filmes adicionados
- **GET** `/movies/{id}` = Busca um filme pelo ID
- **PUT** `/movies/{id}` = Atualiza os dados de um filme
- **DELETE** `/movies/{id}` = Remove um filme da lista

## Como rodar o projeto
1. Clone este repositório:
```git clone https://github.com/diogof-kode/Projeto-MovieRating.git```
2. Entre na pasta:
```cd Projeto-MovieRating```
3. Rode o projeto
```mvn spring-boot:run```
4. Acesse no navegador ou plataforma de teste:
[```http://localhost:8080/movies/```](http://localhost:8080/movies/)

## Estrutura do filme em Json (MovieModel)
```json
{
  "title": "Star Wars: Episódio III - A Vingança dos Sith"
  "rating": 10
  "review": "O melhor da trilogia"
}
```
