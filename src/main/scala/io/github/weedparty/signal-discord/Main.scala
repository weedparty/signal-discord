package io.github.weedparty.signaldiscord

import ackcord._
import ackcord.data._
import org.json4s._
import org.json4s.jackson.JsonMethods._

case class Configure(clientId: String, clientSecret: String){
  implicit val formats = DefaultFormats
}

object Main extends Json with App {
  val key = json4s().get("clientId") //clientId or clientSecret
  println(key)
}