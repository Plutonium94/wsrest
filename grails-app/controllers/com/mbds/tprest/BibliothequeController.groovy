package com.mbds.tprest

import grails.converters.JSON
import grails.converters.XML

class BibliothequeController {

    def numberService

    def index() {
        println(request.getMethod())
    	switch(request.getMethod()) {
    		case "GET":
                println(params)
                def i = params.id as Long
                if(i && i instanceof Long) {
                    def bibliotheque = Bibliotheque.get(i)
                    if(bibliotheque) {

                        render bibliotheque as JSON
                    } else {
                        render(status: 404, "La bibliotheque id " + i + " n'existe pas")
                    }
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
                    render(status:400, text: 'Il faut un nom, adresse et anneeCreation pour creer une Bibliotheque');
                } else {
                    def bibnew = bibliotheque.save(failOnError: true, flush: true)
                    if(!bibnew) {
                        response.status = 400
                    } else {
    				    render(status: 201, text: bibnew as JSON)
                    }
    			}
                break
            case "PUT":
                def corps = request.JSON
                /*if(request.XML) {
                    corps = request.XML
                    x = XML.parse(corps)
                    println(x)
                    response.status= 401

                }*/
                println corps
                if(!corps.id) {
                    render(status: 400, text: 'Il faut specifier id de la Bibliotheque a modifier')
                } else if(!corps.nom && !corps.adresse && !corps.anneeCreation) {
                    render(status: 400, text: 'Vous pouvez modifier soit le nom, soit adresse, soit anneeCreation d\'une Bibliotheque')
                } else  {
                    def bibliotheque =Bibliotheque.get(corps.id as Long)
                    if(!bibliotheque) {
                        render(status: 404, text: 'Il existe aucun bibliotheque avec id = ' + corps.id)
                        
                    } else {
                        if(corps.nom) {
                            bibliotheque.nom = corps.nom
                        }
                        if(corps.adresse) {
                            bibliotheque.adresse = corps.adresse
                        } 
                        if(corps.anneeCreation) {
                            bibliotheque.anneeCreation = corps.anneeCreation
                        }

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
                        render(status: 404, text: 'Il existe aucune bibliotheque avec id = ' + id)   
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
