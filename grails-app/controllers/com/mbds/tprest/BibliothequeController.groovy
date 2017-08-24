package com.mbds.tprest

import grails.converters.JSON

class BibliothequeController {

    def index() { 
    	switch(request.getMethod()) {
    		case "GET":
    			def bibliotheques = Bibliotheque.list()
    			render bibliotheques as JSON
    			break
    		case "POST":
    			def bibliotheque = new Bibliotheque(params)
    			if(bibliotheque.save(failOnError: true, flush: true)) {
    				response.status = 201
    			} else {
    				response.status = 400
    			}
    	}
    }

    def id(num) {
        num = num as Long
        switch(request.getMethod()) {
            case "GET":
                def bibliotheque = Bibliotheque.get(num)
                render bibliotheque as JSON
                break;

            case "OPTIONS":
                render ["GET","PUT","DELETE"] as JSON
        }
    }


}
