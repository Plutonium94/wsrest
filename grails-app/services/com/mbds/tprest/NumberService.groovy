package com.mbds.tprest

import grails.transaction.Transactional

@Transactional
class NumberService {

    def toLong(Object i) {
    	try {
    		return i as Long
    	} catch(NumberFormatException nfe) {
    		return -1
    	}
    }
}
