package example

import sbt.io.IO
import java.io.File

import org.json4s.jackson.Serialization.{read, write}

object Hello {
  val sourceFile = new File("sample.json")
  val destinationFile = new File("modified.json")

  def main(args: Array[String]): Unit = {
    // 元となるファイルを作成
    createSourceJSON(15)

    // ファイルを読み込んでFizzBuzzを実行
    fizzBuzzFromJSON()

    // ファイルを直接見ることのできないScastieで確認する用
    // println(IO.read(destinationFile))
  }

  def createSourceJSON(n: Int): Unit = {
    require(n >= 1) // `n` は1以上とする

    IO.write(sourceFile,
      s"""{"intArray":[${(1 to n).mkString(",")}]}""")
  }

  def fizzBuzzFromJSON(): Unit = {
    implicit val formats = org.json4s.DefaultFormats

    // `sample.json` を読み込み
    val rawJson = IO.read(sourceFile)
    val intArrayHolder = read[IntArrayHolder](rawJson)

    // JSON内の配列を元にFizzBuzzに変換
    val fizzBuzz = intArrayHolder.intArray.map(i => 
      i match {
        case x if x % 15 == 0 => "FizzBuzz"
        case x if x % 3 == 0 => "Fizz"
        case x if x % 5 == 0 => "Buzz"
        case x => x.toString
      })
    val fizzBuzzHolder = FizzBuzzHolder(fizzBuzz)

    // FizzBuzzの結果を `modified.json` に書き出す
    IO.write(destinationFile, write(fizzBuzzHolder))
  }
}

case class IntArrayHolder(intArray: Array[Int])
case class FizzBuzzHolder(fizzBuzz: Array[String])
