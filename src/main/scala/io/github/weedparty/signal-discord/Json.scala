package io.github.weedparty.signaldiscord

import org.json4s._
import org.json4s.jackson.JsonMethods._

import scala.io.Source

object Json {
  lazy val json4s: Map[String, Any] = {
    val source = Source.fromFile("config/config.json", "UTF-8")
    val json = parse(source.mkString)
    val maps = json.values.asInstanceOf[Map[String, Any]]
    maps
  }
}