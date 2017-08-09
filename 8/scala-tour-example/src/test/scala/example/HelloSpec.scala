package example

import org.scalatest._

import sbt.io.IO
import java.io.File

class HelloSpec extends FlatSpec {
  def createSourceJSONAndThenFizzBuzzFromJSON(n: Int): Unit = {
    Hello.createSourceJSON(n)
    Hello.fizzBuzzFromJSON()

    val answer = (1 to n).map(i => i match {
      case x if x % 15 == 0 => """"FizzBuzz""""
      case x if x % 3 == 0 => """"Fizz""""
      case x if x % 5 == 0 => """"Buzz""""
      case x => s""""${x}""""
    }).mkString(",,") // Oops!

    assert(IO.read(new File("modified.json")) ===
      s"""{"fizzBuzz":[${answer}]}""")
  }

  // 処理が例外を投げるはずのテストケース
  s"`createSourceJSON` and `fizzBuzzFromJSON` (1 to 0)" should
      "throw IllegalArgumentException" in {
    assertThrows[IllegalArgumentException] {
      createSourceJSONAndThenFizzBuzzFromJSON(0)
    }
  }

  // 処理が成功するはずのテストケース
  for { n <- Array(1, 15, 100) } {
    s"`createSourceJSON` and `fizzBuzzFromJSON` (1 to $n)" should
        "apply FizzBuzz to data from JSON file" in {
      createSourceJSONAndThenFizzBuzzFromJSON(n)
    }
  }

  // 処理の成功を前提としているが, 実際には処理が例外を投げてしまうテストケース
  // s"`createSourceJSON` and `fizzBuzzFromJSON` (1 to 0)" should
  //     "apply FizzBuzz to data from JSON file" in {
  //   createSourceJSONAndThenFizzBuzzFromJSON(0)
  // }
}

