package controllers

import play.api._
import play.api.mvc._

import play.api.libs.{ Comet }
import play.api.libs.iteratee._
import play.api.libs.concurrent._

import akka.util.duration._

import scala.io._
import scala.xml.XML
import scala.actors._
import Actor._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index())
  }

  var liveData = ""

  lazy val data: Enumerator[String] = {
    
    Enumerator.fromCallback { () =>
      Promise.timeout({
val caller = self

        for (woeid <- Array(2295426, 2502265, 2507854, 4097)) {
          actor {
            caller ! getWeatherForWOEID(woeid toString)
          }
        }

      	for (woeid <- Array(2295426, 2502265, 2507854, 4097)) {
   			 receive{
      				case (location, sunrise, temparature) => liveData = "Weather for " + location + " is [ temparature : " + temparature + " and Sunrise : " + sunrise + " ]"
      				case _ => {
      					println("here")
      					liveData = "Ooops, TIMEOUT!"
      				}
    		}
  		}
  		Some(liveData)
      	}, 10000 milliseconds)
    }
  }

  def getWeatherForWOEID(woeid: String): (String, String, String) = {
    val url = "http://weather.yahooapis.com/forecastrss?w=" + woeid
    val xmlResponse = scala.xml.XML.loadString(Source.fromURL(url).mkString)

    var location = xmlResponse \\ "location" \\ "@city" mkString
    var sunrise = xmlResponse \\ "astronomy" \\ "@sunrise" mkString
    var temparature = (xmlResponse \\ "forecast" \\ "@high" head) mkString

    println("Returning :" + (location, sunrise, temparature))
    (location, sunrise, temparature)
  }
  
  def liveStream = Action {
    Ok.stream(data &> Comet(callback = "parent.dataChanged"))
  }
  
}
