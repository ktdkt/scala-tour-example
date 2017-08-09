object Outer {
  implicit class MyString(val str: String) extends AnyVal {
    // 末尾にピリオドを付けた新たな文字列を返す
    // ただし既に付いていた場合はそのまま返す
    def addPeriod(): String =
      if (str.endsWith(".")) str else str + "."
  }

  println("Hello World".addPeriod)
  println("I am a pen.".addPeriod)
}
Outer
// >> "Hello World."
// >> "I am a pen."

// ここからは `MyString` が見えないので `addPeriod` は利用できない
// println("Hello World".addPeriod) // Error
