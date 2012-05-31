package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index()
  }

  def sockHandler = new WebSocket<String> {
	  	def onReady(in : WebSocket.In<String>, out WebSocket.Out<String>) = {
	  		in.onMessage(new Callback<String> {
	  					def invoke(event : String) = {
	  						Logger.info(" ++++++++ "+event)
	  					}
	  				}
	  			)
	  		out.write("I'm reaching you for websocket thing..")
	  	}
  	}
}