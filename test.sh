
curl -v -X GET http://localhost:8080/bibliotheque;

curl -v -H "Accept: text/xml" -X GET http://localhost:8080/bibliotheque;


curl -v -X GET http://localhost:8080/bibliotheques;


curl -v -X POST -H "Content-Type: application/json" -d @test/bib_post.json http://localhost:8080/bibliotheque/;

curl -v -X POST -H "Content-Type: application/json" -H "Accept: text/xml" -d @test/bib_post.json http://localhost:8080/bibliotheque/;


curl -v -X POST -H "Content-Type: application/json" -d @test/bib_post.json http://localhost:8080/bibliotheques/;


curl -v -X POST -H "Content-Type: application/json" -d @test/bib_post_n.json http://localhost:8080/bibliotheque/;


curl -v -X PUT -H "Content-Type: application/json" -d @test/bib_put.json http://localhost:8080/bibliotheque/;

curl -v -X PUT -H "Content-Type: application/json" -H "Accept: text/xml" -d @test/bib_put.json http://localhost:8080/bibliotheque/;

curl -v -X PUT -H "Content-Type: application/json" -d @test/bib_put_n.json http://localhost:8080/bibliotheque/;


curl -v -X PUT -H "Content-Type: application/json" -d @test/bib_put_nn.json http://localhost:8080/bibliotheque/;

curl -v -X DELETE http://localhost:8080/bibliotheque/;

curl -v -X DELETE http://localhost:8080/bibliotheques/;


curl -v -X DELETE http://localhost:8080/bibliotheque/3;

curl -v -X DELETE http://localhost:8080/bibliotheque/40;

curl -v -X GET http://localhost:8080/bibliotheque/2;

curl -v -X GET -H "Accept: text/xml" http://localhost:8080/bibliotheque/2;


curl -v -X GET http://localhost:8080/bibliotheque/40;


curl -v -X GET http://localhost:8080/livre;


curl -v -X GET http://localhost:8080/livres;

curl -v -X GET http://localhost:8080/livre/2;
curl -v -X GET -H "Accept: text/xml" http://localhost:8080/livre/2;

curl -v -X GET http://localhost:8080/livre/41;






curl -v -X POST -H "Content-Type: application/json" -d @test/liv_post.json http://localhost:8080/livre/;
curl -v -X POST -H "Content-Type: application/json" -H "Accept: text/xml" -d @test/liv_post.json http://localhost:8080/livre/;
curl -v -X POST -H "Content-Type: application/json" -d @test/liv_post.json http://localhost:8080/livres/;
curl -v -X POST -H "Content-Type: application/json" -d @test/liv_post_n.json http://localhost:8080/livre/;
curl -v -X POST -H "Content-Type: application/json" -d @test/liv_post_nn.json http://localhost:8080/livre/;


curl -v -X PUT -H "Content-Type: application/json" -d @test/liv_put.json http://localhost:8080/livre/;
curl -v -X PUT -H "Content-Type: application/json" -H "Accept: text/xml" -d @test/liv_put.json http://localhost:8080/livre/;
curl -v -X PUT -H "Content-Type: application/json" -d @test/liv_put.json http://localhost:8080/livres/;
curl -v -X PUT -H "Content-Type: application/json" -d @test/liv_put_n.json http://localhost:8080/livre/;
curl -v -X PUT -H "Content-Type: application/json" -d @test/liv_put_nn.json http://localhost:8080/livre/;
curl -v -X PUT -H "Content-Type: application/json" -d @test/liv_put_nnnn.json http://localhost:8080/livre/;

curl -v -X DELETE http://localhost:8080/livre/2;
curl -v -X DELETE http://localhost:8080/livres;
curl -v -X DELETE http://localhost:8080/livre/;
curl -v -X DELETE http://localhost:8080/livre/29;



