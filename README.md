# Server_Programming_git

To test from SPRING BOOT REST

all
GET http://localhost:8080/books

by Id
GET http://localhost:8080/book/3

To test from SPRING DATA REST 

all
GET http://localhost:8080/api/books

by Id
GET http://localhost:8080/api/books/3

Add new data
POST http://localhost:8080/api/books/

body
{
    "author": "Ernest",
    "isbn": "1232324-21",
    "title": "A Farewell to Arm",
    "year": 2020,
    "category": "http://localhost:8080/api/categories/1"
}

Get data by year
GET http://localhost:8080/api/books/search/findByYear?year=1929
