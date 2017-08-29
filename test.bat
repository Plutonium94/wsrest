
curl -v -X GET http://localhost:8080/bibliotheque;

curl -v -X POST -H "Content-Type: application/json" -d @test/bib_post.json http://localhost:8080/bibliotheque/;

curl -v -X POST -H "Content-Type: application/json" -d @test/bib_post_n.json http://localhost:8080/bibliotheque/;

curl -v -X POST -H "Content-Type: application/json" -d @test/bib_post_nnn.json http://localhost:8080/bibliotheque/;

curl -v -X PUT -H "Content-Type: application/json" -d @test/bib_put.json http://localhost:8080/bibliotheque/;

curl -v -X PUT -H "Content-Type: application/json" -d @test/bib_put_n.json http://localhost:8080/bibliotheque/;


curl -v -X PUT -H "Content-Type: application/json" -d @test/bib_put_nn.json http://localhost:8080/bibliotheque/;

curl -v -X DELETE http://localhost:8080/bibliotheque/;

curl -v -X DELETE http://localhost:8080/bibliotheque/5;

curl -v -X DELETE http://localhost:8080/bibliotheque/40;

curl -v -X DELETE http://localhost:8080/bibliotheque/huit;



curl -v -X POST -H "Content-Type: application/json" -d @test/liv_post.json http://localhost:8080/livre/;


curl -v -X PUT -H "Content-Type: application/json" -d @test/liv_put.json http://localhost:8080/livre/;

curl -v -X DELETE http://localhost:8080/livre/2;



