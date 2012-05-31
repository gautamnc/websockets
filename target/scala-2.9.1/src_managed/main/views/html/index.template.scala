
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("websocks with scala")/*1.29*/ {_display_(Seq[Any](format.raw/*1.31*/("""
    
    <div class="greeting"></div>
    <button class="send">Send</button>
    
    <script type="text/javascript" charset="utf-8">
    
        $(function() """),format.raw("""{"""),format.raw/*8.23*/("""
            var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
            var sock = new WS(""""),_display_(Seq[Any](/*10.33*/routes/*10.39*/.Application.sockHandler().webSocketURL(request))),format.raw/*10.87*/("""")
            
            sock.onmessage = function(event) """),format.raw("""{"""),format.raw/*12.47*/("""
                $('.greeting').append(event.data)
            """),format.raw("""}"""),format.raw/*14.14*/("""
            
            $('button.send').click(function() """),format.raw("""{"""),format.raw/*16.48*/("""
                sock.send("I'm sending a message now.")
            """),format.raw("""}"""),format.raw/*18.14*/(""");            
        """),format.raw("""}"""),format.raw/*19.10*/(""")
    
    </script>

""")))})))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 31 14:29:40 PDT 2012
                    SOURCE: /Users/gchandra/git/websockets/app/views/index.scala.html
                    HASH: 8f98fe5d7cc8763db0ce56af2aab88933615e1d3
                    MATRIX: 578->1|613->28|652->30|860->192|1000->296|1015->302|1085->350|1194->412|1305->476|1413->537|1530->607|1601->631
                    LINES: 22->1|22->1|22->1|29->8|31->10|31->10|31->10|33->12|35->14|37->16|39->18|40->19
                    -- GENERATED --
                */
            