import com.mbds.tprest.*;

class BootStrap {

    def initializeEntitiesService

	

    def init = { servletContext ->
    	initializeEntitiesService.initializeEntities()
    }
    
    def destroy = {

    }
}
