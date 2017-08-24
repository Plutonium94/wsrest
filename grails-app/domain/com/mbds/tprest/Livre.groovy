package com.mbds.tprest


class Livre {

    static constraints = {
    	nom blank : false
    	dateSortie nullable: false
    	isbn null : false
    	auteur blank: false
    }

    static belongsTo = [bibliotheque : Bibliotheque]

    String nom
    String auteur
    Date dateSortie
    String isbn
}
