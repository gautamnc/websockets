// @SOURCE:/Users/gchandra/Applications/play-2.0.1/apps/websockets/conf/routes
// @HASH:4ab3ae2b20275a92a9326520f76c1db029396b14
// @DATE:Thu May 31 14:01:00 PDT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:7
val controllers_Application_sockHandler1 = Route("GET", PathPattern(List(StaticPart("/greeter"))))
                    

// @LINE:10
val controllers_Assets_at2 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/greeter""","""controllers.Application.sockHandler()"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:7
case controllers_Application_sockHandler1(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.sockHandler(), HandlerDef(this, "controllers.Application", "sockHandler", Nil))
   }
}
                    

// @LINE:10
case controllers_Assets_at2(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                