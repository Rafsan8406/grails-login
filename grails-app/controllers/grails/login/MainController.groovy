package grails.login

import grails.plugin.springsecurity.annotation.Secured
import main.Document
import org.springframework.web.multipart.MultipartFile

@Secured(['ROLE_USER','ROLE_ADMIN'])
class MainController {

    def index() {
        def userName = "BBartes"
        [user: userName]
    }
    def upload(){
        def  file = request.getFile('file')
        if(file.empty){
        flash.message = "File not Found!"
        }else{
            def documentInstance = new Document(params)
            documentInstance.fileName = file.originalFilename
            documentInstance.fullPath = "F:/news-image/" + documentInstance.fileName
            file.transferTo(new File( documentInstance.fullPath))
            documentInstance.save()
        }
        redirect(action: 'index')

    }


}
