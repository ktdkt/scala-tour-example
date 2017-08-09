abstract class Polygon(edges: List[Int]) {
  val n = edges.length // n角形
  val area: Double // 面積
  def printFigure(): Unit // 外形を標準出力
}



abstract class Polygon(edges: List[Int]) {
  val n = edges.length // n個の辺から成るn角形
  val area: Double // 面積
  def printFigure(): Unit // 外形を標準出力
}

class Triangle(edges: List[Int]) extends Polygon(edges) {
  // 与えられた辺から三角形が成立すると勝手に仮定
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)

  val area = {
    // Heron's formula
    val s = (a + b + c) / 2.0
    math.sqrt(s * (s - a) * (s - b) * (s - c))
  }
  def printFigure(): Unit = println("△")
}

class Square(edges: List[Int]) extends Polygon(edges) {
  // 与えられた辺から四角形が成立すると勝手に仮定
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)
  val d = edges(3)

  val area = {
    // Brahmagupta's formula
    // 対角の和が180度と勝手に仮定
    val s = (a + b + c + d) / 2.0
    math.sqrt((s - a) * (s - b) * (s - c) * (s - d))
  }
  def printFigure(): Unit = println("□")
}



// [3, 4, 5] から成るリストを作成します
// 6章で詳しく紹介します
val edges = List(3, 4, 5)
val triangle = new Triangle(edges)
println(triangle.area)
/* 出力
6.0
*/

triangle.printFigure()
/* 出力
△
*/



abstract class Polygon(edges: List[Int]) {
  val n = edges.length // n個の辺から成るn角形
  val area: Double // 面積
  def printFigure(): Unit // 外形を標準出力
}

// 追加するコンパニオンオブジェクト
object Polygon {
  // 与えられる `edges` の辺に応じて
  // 適切な多角形を生成する静的なファクトリメソッド
  def fromEdges(edges: List[Int]): Polygon =
    edges.length match {
      case 3 =>
        new Triangle(edges)
      case 4 =>
        new Square(edges)
      case x =>
        ??? // 該当なし
    }
}

class Triangle(edges: List[Int]) extends Polygon(edges) {
  // 与えられた辺から三角形が成立すると勝手に仮定
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)

  val area = {
    // Heron's formula
    val s = (a + b + c) / 2.0
    math.sqrt(s * (s - a) * (s - b) * (s - c))
  }
  def printFigure(): Unit = println("△")
}

class Square(edges: List[Int]) extends Polygon(edges) {
  // 与えられた辺から四角形が成立すると勝手に仮定
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)
  val d = edges(3)

  val area = {
    // Brahmagupta's formula
    // 対角の和が180度と勝手に仮定
    val s = (a + b + c + d) / 2.0
    math.sqrt((s - a) * (s - b) * (s - c) * (s - d))
  }
  def printFigure(): Unit = println("□")
}

val edges3 = List(3, 4, 5)
val edges4 = List(3, 13, 13, 14)
val polygon3 = Polygon.fromEdges(edges3)
val polygon4 = Polygon.fromEdges(edges4)
println(s"辺の数: ${polygon3.n}, 面積: ${polygon3.area}")
/* 出力
辺の数: 3, 面積: 6.0
*/
println(s"辺の数: ${polygon4.n}, 面積: ${polygon4.area}")
/* 出力
辺の数: 4, 面積: 100.12336140981284
*/

val edges5 = List(3, 3, 3, 3, 3)
// val polygon5 = Polygon.fromEdges(edges5) // Error



sealed abstract class Animal(val cryJP: String, val cryEN: String)
object Cat extends Animal("にゃー", "Meow")
object Dog extends Animal("わんわん", "Bowwow")
object Lion extends Animal("がおー", "Roar")

val animal = Cat
animal match {
  case Cat =>
    println(s"Catです. 日本語では「${animal.cryJP}」, 英語では「${animal.cryEN}」と鳴きます")
  case Dog =>
    println(s"Dogです. 日本語では「${animal.cryJP}」, 英語では「${animal.cryEN}」と鳴きます")
  case Lion =>
    println(s"Lionです. 日本語では「${animal.cryJP}」, 英語では「${animal.cryEN}」と鳴きます")
}
/* 出力
Catです. 日本語では「にゃー」, 英語では「Meow」と鳴きます
*/



class Foo {
  def apply(): Unit =
    println("インスタンスメソッドの方のapplyです")
}
object Foo {
  def apply(str: String): Int = {
    println("クラスメソッドの方のapplyです")
    println(s"引数や返り値も自由にできます${str}")
    str.length
  }
}
val foo = new Foo
foo()
/* 出力
インスタンスメソッドの方のapplyです
*/
val result = Foo("!!!")
/* 出力
クラスメソッドの方のapplyです
引数や返り値も自由にできます!!!
*/
println(result)
/* 出力
3
*/



val generator = new scala.util.Random
case class Foo(i: Int) {
  val randomValue = generator.nextInt // 乱数
}

// 1. の機能であたかも `new` キーワードを省略するようにみえる
val foo1 = Foo(10) // == Foo.apply(10)

// 2. の機能で `val` を付けずにコンストラクタ引数が外部から参照できる
println(foo1.i)
/* 出力
10
*/

// 3. の機能でいい感じの文字列を得ることができる
println(foo1.toString)
/* 出力
Foo(10)
*/
println(foo1)
/* 出力
Foo(10)
*/

// 普通のクラスだとハッシュ値が出てくる
class Bar
val bar = new Bar
println(bar.toString)
/* 出力 (環境によって異なります)
Bar@79cf123b
*/
println(bar)
/* 出力 (環境によって異なります)
Bar@79cf123b
*/

// 4. の機能でインスタンスのコピーが可能になる
val foo2 = foo1.copy()
// コンストラクタ引数はコピーされるので等しい (`i == 10`) が,
// `randomValue` はコピーされないのでバラバラになる
println(s"${foo1}, randomValue: ${foo1.randomValue}")
/* 出力 (乱数はランダムです)
Foo(10), randomValue: -603337545
*/
println(s"${foo2}, randomValue: ${foo2.randomValue}")
/* 出力 (乱数はランダムです)
Foo(10), randomValue: 1511398269
*/

// 5. の機能でパターンマッチが可能になる
foo1 match {
  // 引数リストが変数に束縛されるので利用可能
  case Foo(i) => println(s"Fooであり, iは${i}です")
  case _ => println("Fooではありません")
}
/* 出力
"Fooであり, iは10です"
*/



sealed abstract class Animal(val cryJP: String, val cryEN: String)
case object Cat extends Animal("にゃー", "Meow")
case object Dog extends Animal("わんわん", "Bowwow")
case object Lion extends Animal("がおー", "Roar")

val animal = Cat
// いい感じに名前を取得することができる
println(s"${animal}です. 日本語では「${animal.cryJP}」, 英語では「${animal.cryEN}」と鳴きます")
/* 出力
Catです. 日本語では「にゃー」, 英語では「Meow」と鳴きます
*/



// コンストラクタ引数を利用するので抽象クラスを選択
abstract class Polygon(edges: List[Int]) {
  val n = edges.length // n個の辺から成るn角形
  val area: Double // 面積
  def printFigure(): Unit // 外形を標準出力
}

// `Red` と `Green` の両方ミックスインしたいのでトレイトを選択
trait Color {
  val R: Int
  val G: Int
  val B: Int
}
trait Red extends Color {
  override val R = 255
  override val G = 0
  override val B = 0
}
trait Green extends Color {
  override val R = 0
  override val G = 255
  override val B = 0
}

class ColoredTriangle(edges: List[Int])
    extends Polygon(edges) with Red with Green {
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)

  val area = {
    // Heron's formula
    val s = (a + b + c) / 2.0
    math.sqrt(s * (s - a) * (s - b) * (s - c))
  }
  def printFigure(): Unit = println("△")
}

// `Red` と `Green` が菱形継承問題を起こしている
// 後勝ちなので, `Green` による値が利用される
val edges = List(3, 4, 5)
val greenTriangle = new ColoredTriangle(edges)
println(greenTriangle.R)
/* 出力
0
*/
println(greenTriangle.G)
/* 出力
255
*/
println(greenTriangle.B)
/* 出力
0
*/