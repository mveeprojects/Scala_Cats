package chapter1

//import cats.instances.string._
//import cats.syntax.semigroup._
import chapter1.JsonWriterInstances._

final case class Person(name: String, email: String)

// 1.1.3 implementing implicit instances of type classes

object Main extends App {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
  val a: Json = toJson(Person("Mark", "marksemailaddress@email.com"))
  println(a.toString)
}
