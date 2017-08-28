package com.mbds.tprest

import grails.converters.JSON
import grails.converters.XML

class BibliothequeController {

    def index() {
        println(request.getMethod())
    	switch(request.getMethod()) {
    		case "GET":
                println(params)
                def i = params.id as Long
                if(i && i instanceof Long) {
                    def bibliotheque = Bibliotheque.get(i)
                    render bibliotheque as JSON
                } else {
        			def bibliotheques = Bibliotheque.list()
        			render bibliotheques as JSON
                }
    			break
    		case "POST":
                def corps = request.JSON
                println(corps)
    			def bibliotheque = new Bibliotheque(corps)
                if(!corps.nom || !corps.adresse || !corps.anneeCreation) {
                    render(status:400, text: 'Il faut un nom, addresse et anneeCreation pour creer une Bibliotheque');
                } else if(bibliotheque.save(failOnError: true, flush: true)) {
    				response.status = 201
    			} else {
    				response.status = 400
    			}
                break
            case "PUT":
                def corps = request.JSON
                if(request.XML) {
                    corps = request.XML
                    x = XML.parse(corps)
                    println(x)
                    response.status= 401

                }
                println corps
                if(!corps.id) {
                    render(status: 400, text: 'Il faut specifier id de la Bibliotheque a modifier')
                } else if(!corps.nom && !corps.adresse && !corps.anneeCreation) {
                    render(status: 400, text: 'Vous pouvez modifier soit le nom, soit adresse, soit anneeCreation d\'une Bibliotheque')
                } else  {
                    def bibliotheque =Bibliotheque.get(corps.id as Long)
                    if(!bibliotheque) {
                        render(status: 404, text: 'Il existe aucun livre avec id = ' + corps.id)
                        
                    } else {
                        bibliotheque.save(failOnError: true, flush: true)
                        render(status: 200, text: bibliotheque as JSON)
                    }
                }
                break
            case "DELETE":
                println(params.id)
                def id = params.id as Long
                if(!id) {
                    render(status: 400, text:'Il faut specifier id de la Bibliotheque a supprimer')
                } else {
                    def bibliotheque = Bibliotheque.get(id)
                    if(!bibliotheque) {
                        render(status: 404, text: 'Il existe aucun livre avec id = ' + id)   
                    } else {
                        bibliotheque.delete(failOnError: true, flush: true)
                        render(status: 200, text: 'La Bibliotheque id=' + id + " est supprime")
                    }
                }
            default:
                response.status = 405

    	}
    }

    
    

}
