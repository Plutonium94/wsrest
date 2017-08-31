package wsrest

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/Bibliotheques"(controller:'Bibliotheque', action:'index')
        "/bibliotheques"(controller:'Bibliotheque', action:'index')
        "/Bibliotheque/$id?"(controller:"Bibliotheque",action:"index")
        "/bibliotheque/$id?"(controller:"Bibliotheque",action:"index")

        "/Livres"(controller:"Livre",action:"index")
        "/livres"(controller:"Livre",action:"index")
        "/Livre/$id?"(controller:"Livre",action:"index")
        "/livre/$id?"(controller:"Livre",action:"index")


        "/"(redirect:"/index.html")

        /*"/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')*/
    }
}
