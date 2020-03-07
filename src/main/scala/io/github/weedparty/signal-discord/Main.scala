package io.github.weedparty.signaldiscord

import ackcord._
import ackcord.data._
import org.json4s._
import org.json4s.jackson.JsonMethods._

object Main extends App {
  val key = Json.json4s.get("clientId") //clientId or clientSecret
  println(key)
}