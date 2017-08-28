package com.mbds.tprest

import grails.converters.JSON

class LivreController {

    def index() { 
    	switch(request.getMethod()) {
    		case "GET":
                println(params)
                def i = params.id as Long
                if(i && i instanceof Long) {
                    def livre = Livre.get(i)
                    render livre as JSON
                } else {
                    def livres = Livre.list()
                    render livres as JSON
                }
    			
    			break
            case "POST":
                if(!params.bibliotheque || !params.bibliotheque.id || !Bibliotheque.get(params.bibliotheque.id)) {
                    println(params)
                    render(status: 400,text:'Il faut une bibliotheque existante pour creer un livre ') as JSON
                    return
                }
                def livre = new Livre(params)
                if(livre.save(flush: true, failOnError: true)) {
                    response.status = 201
                } else {
                    response.status = 400
                }
                break
    		default:
    			def livres = Livre.list()
    			render livres as JSON
    	}
    }
}