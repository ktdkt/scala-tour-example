class Box[T](var element: T) {
  def get(): T = element
  def set(newElement: T): Unit = {
    element = newElement
  }
}

val intBox = new Box[Int](10) // `Box[Int]`
println(intBox.get())
/* 出力
10
*/
intBox.set(0)
println(intBox.get())
/* 出力
0
*/

sealed abstract class Animal(val cryJP: String, val cryEN: String)
object Cat extends Animal("にゃー", "Meow")
object Dog extends Animal("わんわん", "Bowwow")
object Lion extends Animal("がおー", "Roar")

val animalBox = new Box[Animal](Cat) // `Box[Animal]`
println(animalBox.get())
/* 出力
Cat
*/
animalBox.set(Dog) // `Dog` は `Animal` を継承してるのでok
println(animalBox.get())
/* 出力
Dog
*/

// 型パラメータの省略
val intBox2 = new Box(10) // `Box[Int]`
val catBox = new Box(Cat) // `Box[Animal]` ではなく `Box[Cat]`
// catBox.set(Dog) // Error: `Box[Cat]` に `Dog` は入らない



def toFizzBuzz(numbers: List[Int]): List[String] =
  numbers.map((i: Int) => i match {
    case x if x % 15 == 0 => "FizzBuzz"
    case x if x % 3 == 0 => "Fizz"
    case x if x % 5 == 0 => "Buzz"
    case x => x.toString
  })

val n = 15
val numbers = (1 to n).toList
val fizzBuzzList = toFizzBuzz(numbers)
fizzBuzzList.foreach((s: String) => println(s))
// `s` のシグネチャであるは型推論されるので省略できる
// fizzBuzzList.foreach(s => println(s))

// メソッドに括りださなければもっと簡潔に書ける
(1 to n).foreach(i => i match {
  case x if x % 15 == 0 => "FizzBuzz"
  case x if x % 3 == 0 => "Fizz"
  case x if x % 5 == 0 => "Buzz"
  case x => x.toString
})
// 更に省略する方法もありますがここでは敢えて紹介しません



def toFizzBuzz(numbers: List[Int]): List[String] = {
  val f: Int => String = (i: Int) => i match {
    case x if x % 15 == 0 => "FizzBuzz"
    case x if x % 3 == 0 => "Fizz"
    case x if x % 5 == 0 => "Buzz"
    case x => x.toString
  }
  numbers.map(f)
}



val string = "Hello"

string.foreach(c => println(c))
/* 出力
H
e
l
l
o
*/



// 不等号で例えると `<=`
val oneToThree = 1 to 3 // >> [1, 2, 3]

// 不等号でと例えると `<`
val oneUntilThree = 1 until 3 // >> [1, 2]

// `by` で負値を指定することで逆順で生成
val threeToOne = 3 to 1 by -1 // >> [3, 2, 1]

// `to`, `until` や `by` はメソッドの中置記法
val oneToThree0 = 1.to(3) // == 1 to 3



// 要素数から初期化
// 要素数5の `Int` 配列
val arr1 = Array[Int](5)

// 値から初期化
val arr2 = Array("Hello", "World")

// `()` でインデックスによるアクセスができる
for { i <- 0 to 1 } { println(arr2(i)) }
/* 出力
"Hello"
"World"
*/

// 明示的にインデックスによるアクセスをせずとも
// コレクションメソッドで同様の操作ができる
arr2.foreach(el => println(el))
/* 出力
"Hello"
"World"
*/

// 要素は可変なので再代入できる
arr2(0) = "Hell" 
arr2.foreach(el => println(el))
/* 出力
"Hell"
"World"
*/



// 要素数から初期化
// 要素数5の `Int` リスト
val list1 = List[Int](5)

// 値から初期化
val list2 = List("Hello", "World")

// 明示的にインデックスによるアクセスをせずとも
// コレクションメソッドで同様の操作ができる
list2.foreach(el => println(el))
/* 出力
"Hello"
"World"
*/

// 要素は不変なので再代入はできない
// list2(0) = "Hell" // Error

// 全体の可変/不変性と要素の可変/不変性を混同しないこと
var list3 = List("Hello", "World")
list3 = List("Hell", "World") // OK
// list3(0) = "Cell" // Error

// 要素を列挙して初期化することもできる
// ここの `::` はメソッドであり, 中置記法になっている
// 名前が `:` で終わるメソッドは中置記法の際には
// 例外的に呼び出し順序が逆として扱われる
// `1 :: 2 :: 3 :: Nil` を省略せず書くと
// `1.::(2).::(3).::(Nil)` ではなく `Nil.::(1).::(2).::(3)`
val list4 = 1 :: 2 :: 3 :: Nil
// == Nil.::(1).::(2).::(3)
// >> List(1, 2, 3)

val list5 = 0 :: list4 // >> List(0, 1, 2, 3)

// `::` はケースクラスでもあるのでパターンマッチができる
// 条件で使われている `::` はケースクラス
// 式で使われている `::` はメソッド
def threeTimesThree(list: List[Int]): List[Int] =
  list match {
    // リストにまだ要素があり,
    // 取り出した先頭の値が3で割り切れる場合
    case head :: tail if head % 3 == 0 =>
      (head * 3) :: threeTimesThree(tail)
    // リストにまだ要素がある場合
    case head :: tail =>
      head :: threeTimesThree(tail)
    // リストにもう要素がなかった場合
    case Nil => Nil
  }
threeTimesThree(list5) // >> List(0, 1, 2, 9)



// 値から初期化
val set1 = Set(0, 0, 0) // >> Set(0)

// 明示的にインデックスによるアクセスをせずとも
// コレクションメソッドで同様の操作ができる
set1.foreach(el => println(el))
/* 出力
0
*/
println(set1.size)
/* 出力
1
*/

val list = List(0, 0, 1, 1)
println(list.size)
/* 出力
4
*/

// `toSet` メソッドで `Set` に変換できる
val set2 = list.toSet // >> Set(0, 1)
println(set2.size)
/* 出力
2
*/



// 値から初期化
// キー・バリューの形になるタプルを渡す
val map1 = Map((1, "A"), (2, "B"))

// キーを元に値を取得 (ここの詳細は7章にて)
val value1 = map1.get(1) // Some("A")
val value2 = map1.get(100) // None

// タプル
val tuple21 = (1, "A") // 要素が2個のタプル
// 要素が2個の時だけ `->` でも作成できる
val tuple22 = 1 -> "A" // == (1, "A")
val tuple3 = (1, "A", "X") // 要素が3個のタプル

// タプルの要素には `._` + 1-オリジンのインデックス
// で取り出すことができる
println(tuple21._1)
/* 出力
1
*/
println(tuple21._2)
/* 出力
"A"
*/

// 要素は不変なので再代入はできない
// tuple21._1 = 100 // Error

// タプルのコレクションはマップに変換することができる
// タプルの型は要素の型を `()` で括った形で表される
val list1: List[(Int, String)] = 
  List((1, "A"), (2, "B"))
val map2 = list1.toMap // >> Map((1, "1"), (2, "2"))

// そうでないリストの場合は
// 一旦タプルのコレクションを経由する必要がある
val list2 = List(1, 2)
val map3 = list2.map(i => (i, i.toString)).toMap
// >> Map((1, "1"), (2, "2"))



val list1 = List(1, 2, 3)
val list2 = list1.map(i => s"No. ${i}")
// list2 >> List("No. 1", "No. 2", "No. 3")



val list1 = List(1, 2, 3)
list1.foreach(i => println(i))
/* 出力
1
2
3
*/



val list1 = List(1, 2, 3, 4)
val list2 = list1.filter(i => i % 2 == 0)
// >> List(2, 4)



val list1 = List(1, 2, 3, 4)
println(list.count(i => i % 2 == 0))
/* 出力
2
*/



val list1 = List(1, 2, 3)
println(list1.contains(1)) // true
println(list1.contains(1111111)) // false



val list1 = List(1, 2, 3)
val list2 = List(5, 6, 7)
val list3 = list1 ++ list2
// == list1.++(list2)
// >> List(1, 2, 3, 5, 6, 7)
val list4 = list2 ++ list1
// == list2.++(list1)
// >> List(5, 6, 7, 1, 2, 3)



val list1 = List(1, 2, 3)
println(list1.mkString)
/* 出力
"123"
*/
println(list1.mkString(","))
/* 出力
"1,2,3"
*/
println(list1.mkString("[", ",", "]"))
/* 出力
"[1,2,3]"
*/