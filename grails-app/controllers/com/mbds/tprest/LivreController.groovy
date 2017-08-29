package com.mbds.tprest

import grails.converters.JSON

class LivreController {


    def index() { 
    	switch(request.getMethod()) {
    		case "GET":
                println(params.id)
                def i = params.id as Long
                if(i) {
                    def livre = Livre.get(i)
                    render livre as JSON
                } else {
                    def livres = Livre.list()
                    render livres as JSON
                }
    			
    			break
            case "POST":
                def corps = request.JSON
                println(corps)
                if(!corps.bibliotheque || !corps.bibliotheque.id) {
                    render(status: 400,text:'Il faut une bibliotheque existante pour creer un livre ') as JSON
                    
                } else {
                    def bid = corps.bibliotheque.id as Long
                    if(bid && bid instanceof Long) {
                        def bibliotheque = Bibliotheque.get(corps.bibliotheque.id as Long)
                        if(!bibliotheque) {
                            render(status: 404, text:'La bibliotheque precisee n\'existe pas')
                        } else {
                            corps.dateSortie = Date.parse("yyyy-MM-dd",corps.dateSortie)
                            def livre = new Livre(corps)
                            def livnew = livre.save(flush: true, failOnError: true)
                            if(livre) {
                                render(status: 201, text: livnew as JSON)
                            } else {
                                response.status = 400
                            }
                        }
                    } else {
                        render(status: 404, text:'Veuillez preciser un id de bibliotheque valide')
                    }
                }
                break
            case "PUT":
                def corps = request.JSON
                
                println corps
                if(!corps.id) {
                    render(status: 400, text: 'Il faut specifier id du livre a modifier')
                } else if(!corps.nom && !corps.dateSortie && !corps.isbn && !(corps.bibliotheque && corps.bibliotheque.id)) {
                    render(status: 400, text: 'Vous pouvez modifier soit le nom, soit dateSortie, soit isbn soit id de bibliotheque d\'un livre')
                } else  {

                    def livre = Livre.get(corps.id as Long)
                    if(!livre) {
                        render(status: 404, text: 'Il existe aucun livre avec id = ' + corps.id)
                        
                    } else {
                        livre.save(failOnError: true, flush: true)
                        render(status: 200, text: livre as JSON)
                    }
                }
                break
            case "DELETE":
                println(params.id)
                def id = params.id as Long
                if(!id) {
                    render(status: 400, text:'Il faut specifier id du livre a supprimer')
                } else {
                    def livre = Livre.get(id)
                    if(!livre) {
                        render(status: 404, text: 'Il existe aucun livre avec id = ' + id)   
                    } else {
                        livre.delete(failOnError: true, flush: true)
                        render(status: 200, text: 'La livre id=' + id + " est supprime")
                    }
                }
    		default:
    			response.status = 405
    	}
    }
}
