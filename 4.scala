val n = 3
for { i <- (1 to n) } {
  println(i)
}
/* 出力
1
2
3
*/



for {
  i <- (0 to 12 by 3) if i % 2 == 0
  j <- (1 to 3)
} {
  println(i * j)
}



val result = for {
  i <- (1 to 3)
} {
  i
} // >> ()
// 単純に i を返すだけの式にしたい
// つまり, `1`, `2`, `3` と3つの値が返ってきて欲しい
// が, `result` は `Unit` 型の `()` になってしまう



val result = for {
  i <- (1 to 3)
} yield {
  i
} // >> `1`, `2`, `3` の3つの値からなるコレクション



def fizzBuzz(n: Int): Unit = for { i <- 1 to n } {
  if (i % 15 == 0) {
    println("FizzBuzz")
  } else if (i % 3 == 0) {
    println("Fizz")
  } else if (i % 5 == 0) {
    println("Buzz")
  } else {
    println(i)
  }
}



def fizzBuzz(n: Int): Unit = for { i <- 1 to n } {
  i match {
    case x if x % 15 == 0 =>
      println("FizzBuzz")
    case x if x % 3 == 0 =>
      println("Fizz")
    case x if x % 5 == 0 =>
      println("Buzz")
    case x =>
      println(x)
  }
}



val data = 10
val result = data match {
  // 定数値を条件にできます
  case 0 =>
    "0です"

  // `|` でOR条件を作れます
  case 1 | 2=>
    "1か2です"

  // ここの `x` のように宣言することで, 条件
  // (ここでいう `x % 3 == 0`) とマッチした値を
  // 変数として参照することができます
  case x if x % 3 == 0 => 
     // `toString` を呼び出すことで文字列に変換できます
     "0でも1でも2でもなく3で割り切れる値である" + x.toString + "です"

  // 条件がない `x`, つまり対象がどんな値であれマッチします
  // `x` のような変数代わりに `_` というキーワードを利用することができます
  // `_` を使うと `x` のように値の参照はできなくなります
  case x => 
    // 文字列を括るクォーテーション (`"`) の前に `s` を付けると
    // 文字列内で `${}` として変数を参照して式を記述できるようになります
    // この機能を文字列補完と呼びます
    s"0でも1でも2でもなく3で割り切れない値である${x}です"
}

println(result)
/* 出力
"0でも1でも2でもなく3で割り切れない値である10です"
*/



def fizzBuzz(n: Int, i: Int = 1): Unit = {
  // 値に応じて出力
  i match {
    case x if x % 15 == 0 =>
      println("FizzBuzz")
    case x if x % 3 == 0 =>
      println("Fizz")
    case x if x % 5 == 0 =>
      println("Buzz")
    case x =>
      println(x)
  }

  // `i` が `n` になるまで再帰呼び出し
  if (i < n) fizzBuzz(n, i + 1)
}

fizzBuzz(15) // 最初の呼び出し



def fib(n: Int): Int =
  if (n < 2) n else fib(n - 1) + fib(n - 2)



def fib(n: Int): Int = {
  // 慣習的に再帰のために切り出された内部メソッドには
  // go` や `loop` という名前が用いられることが多い
  @scala.annotation.tailrec
  def go(n: Int, prev: Int, curr: Int): Int =
    if(n == 0) prev
    else go(n - 1, curr, prev + curr)
  go(n, 0, 1)
}