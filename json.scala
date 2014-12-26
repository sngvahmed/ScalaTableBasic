//package bot
//
//import scala.io.Source
//
//object Test {
//  def fn(filename: String): Map[String, String] = {
//    var parsed : Map[String, String] = Map()
//    for (line <- Source.fromFile(filename).getLines()) {
//      var i = line.indexOf(':')
//      var key = line.substring(0, i)
//      var value = line.substring(i + 1)
//      parsed += (key -> value)
//    }
//    return parsed
//  }
//  def main(args: Array[String]) {
//    var result = fn("test.txt")
//    println(result.get("handle").get)
//  }
//}
