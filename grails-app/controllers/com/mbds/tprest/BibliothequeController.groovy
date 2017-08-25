package com.mbds.tprest

import grails.converters.JSON

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
    			def bibliotheque = new Bibliotheque(params)
    			if(bibliotheque.save(failOnError: true, flush: true)) {
    				response.status = 201
    			} else {
    				response.status = 400
    			}
                break
            default:
                response.status = 405

    	}
    }

    
    

}
