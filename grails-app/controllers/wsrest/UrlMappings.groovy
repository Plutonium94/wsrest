package wsrest

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/Bibliotheque/$id?"(controller:"Bibliotheque",action:"index")
        "/Livre/$id?"(controller:"Livre",action:"index")

        "/"(redirect:"/index.html")

        /*"/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')*/
    }
}