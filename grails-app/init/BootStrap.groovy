import com.mbds.tprest.*;

class BootStrap {

	static Date datify(String d) {
		return Date.parse("yyyy-MM-dd",d)
	}

    def init = { servletContext ->
    	def l1 = new Livre(nom: "Petit livre", auteur:"M Mollet",isbn:"sdkfdfksdfzeoirezer", dateSortie: Date.parse("yyyy-MM-dd","2013-03-10"))
    	def l2 = new Livre(nom: "Art de jouer des pions", auteur:"Oublie", isbn: "zoerijezvzer", dateSortie: Date.parse("yyyy-MM-dd", "1998-02-11"))

    	def b1 = new Bibliotheque(nom:"Louis Nucera",adresse:"Nice",anneeCreation:2013)
    	b1.addToLivres(l1)
    	b1.addToLivres(l2)
    	b1.save(flush:true,failOnError:true)

    	def b2 = new Bibliotheque(nom: "Mediatheque Garbejaire",adresse:"Valbonne", anneeCreation: 2001)
    	b2.addToLivres(new Livre(nom:"Java pour les Nuls", auteur:"Inconnu", isbn:"dsfdsiozererzze", dateSortie: datify("1999-09-13")))
        b2.save(flush:true,failOnError:true)
    }
    def destroy = {

    }
}
