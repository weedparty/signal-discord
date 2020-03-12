package io.github.weedparty.signaldiscord

import ackcord._
import ackcord.syntax._

object Main extends App {

  require(Json.json4s.contains("token"))
  val token = Json.json4s("token").asInstanceOf[String]
  val settings = ClientSettings(token)
  import settings.executionContext

  settings
    .createClient()
    .foreach { client =>
      client.onEvent {
        import client.sourceRequesterRunner._
        client.withCache[SourceRequest, APIMessage] { implicit c => {
          case APIMessage.Ready(_) =>
            println("ready")
            client.sourceRequesterRunner.unit
          case APIMessage.MessageCreate(message, _) if message.content == "ping" && message.isAuthorUser =>
            for {
              guildChannel <- optionPure(message.tGuildChannel)
              _ <- run(guildChannel.sendMessage("pong"))
            } yield ()
          case _ => client.sourceRequesterRunner.unit
        }
        }
      }
      client.login()
    }
}