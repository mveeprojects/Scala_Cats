package chapter1

object JsonWriterInstances {

  // 1.1.2 creating instances of type classes to use later (implmentation of trait and case classes below)

  implicit val stringWriter: JsonWriter[String] = new JsonWriter[String] {
    override def write(value: String): Json = JsString(value)
  }

  implicit val personWriter: JsonWriter[Person] = new JsonWriter[Person] {
    override def write(value: Person): Json = JsObject(
      Map(
        "name" -> JsString(value.name),
        "email" -> JsString(value.email)
      )
    )
  }

  implicit val numberWriter: JsonWriter[Double] = new JsonWriter[Double] {
    override def write(value: Double): Json = JsNumber(value)
  }
}


// 1.1.1 defining case classes to be applied to the JsonWriter trait when implemented

sealed trait Json

final case class JsObject(get: Map[String, Json]) extends Json

final case class JsString(get: String) extends Json

final case class JsNumber(get: Double) extends Json

case object JsNull extends Json

trait JsonWriter[A] {
  def write(value: A): Json
}
