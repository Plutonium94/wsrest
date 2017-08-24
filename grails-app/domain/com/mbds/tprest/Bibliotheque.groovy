package com.mbds.tprest

class Bibliotheque {

    static constraints = {
    	nom blank : false
    	adresse blank: false
    	anneeCreation nullable: false
    }

    static hasMany = [livres : Livre]

    String nom
    String adresse
    Integer anneeCreation

}
