abstract class Polygon(edges: List[Int]) {
  val n = edges.length // n個の辺から成るn角形
  val area: Double // 面積
  def printFigure(): Unit // 外形を標準出力
}

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
        ??? // 与えられた辺数に合う多角形が実装されていない場合
    }
}

class Triangle(edges: List[Int]) extends Polygon(edges) {
  // 与えられた辺では三角形が成り立たない可能性がある
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
  // 与えられた辺では四角形が成り立たない可能性がある
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)
  val d = edges(3)

  val area = {
    // Brahmagupta's formula
    // 対角の和が180度と勝手に仮定 (この仮定は簡単のため維持します)
    val s = (a + b + c + d) / 2.0
    math.sqrt((s - a) * (s - b) * (s - c) * (s - d))
  }
  def printFigure(): Unit = println("□")
}

val edges3 = List(3, 4, 5)
val polygon5 = Polygon.fromEdges(edges3) // 問題なし

val invalidEdges5 = List(3, 3, 3, 3, 3)
// 与えられた辺数に合う多角形が実装されていないのでエラー
// val invalidPolygon5 = Polygon.fromEdges(invalidEdges5)

val invalidEdges3 = List(3, 4, 8)
// 与えられた辺では三角形が成り立たないので
// エラーではないが計算結果が不正
// val invalidPolygon3 = Polygon.fromEdges(invalidEdges3)



abstract class Polygon(edges: List[Int]) {
  val n = edges.length // n個の辺から成るn角形
  val area: Double // 面積
  def printFigure(): Unit // 外形を標準出力
}

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
        // 与えられた辺の数に合う多角形が実装されていない場合は
        // `null` を返してみる
        null
    }
}

class Triangle(edges: List[Int]) extends Polygon(edges) {
  // 与えられた辺では三角形が成り立たない可能性がある
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
  // 与えられた辺では四角形が成り立たない可能性がある
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)
  val d = edges(3)

  val area = {
    // Brahmagupta's formula
    // 対角の和が180度と勝手に仮定 (この仮定は簡単のため維持します)
    val s = (a + b + c + d) / 2.0
    math.sqrt((s - a) * (s - b) * (s - c) * (s - d))
  }
  def printFigure(): Unit = println("□")
}

val edges3 = List(3, 4, 5)
val polygon5 = Polygon.fromEdges(edges3) // 問題なし

val invalidEdges5 = List(3, 3, 3, 3, 3)
val invalidPolygon5 = Polygon.fromEdges(invalidEdges5)
// >> `null`



abstract class Polygon(edges: List[Int]) {
  val n = edges.length
  val area: Double
}

object Polygon {
  // 与えられる `edges` の辺に応じて
  // 適切な多角形を生成する静的なファクトリメソッド
  // 返り値を `Option[Polygon]` 型に変更
  def fromEdges(edges: List[Int]): Option[Polygon] =
    edges.length match {
      case 3 =>
        // 三角形は実装されているので `Some[Polygon]` で返す
        Some(new Triangle(edges))
      case 4 =>
        // 四角形は実装されているので `Some[Polygon]` で返す
        Some(new Square(edges))
      case x =>
        // 与えられた辺数に合う多角形が実装されていないので `None` を返す
        None
    }
}

class Triangle(edges: List[Int]) extends Polygon(edges) {
  // 与えられた辺では三角形が成り立たない可能性がある
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
  // 与えられた辺では四角形が成り立たない可能性がある
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)
  val d = edges(3)

  val area = {
    // Brahmagupta's formula
    // 対角の和が180度と勝手に仮定 (この仮定は簡単のため維持します)
    val s = (a + b + c + d) / 2.0
    math.sqrt((s - a) * (s - b) * (s - c) * (s - d))
  }
  def printFigure(): Unit = println("□")
}

val edges3 = List(3, 4, 5)
val polygon3 = Polygon.fromEdges(edges3)
// >> :Some[Polygon]
// 面積を出力する
polygon3 match {
  case Some(p) => println(p.area)
  case None =>
    println("不正な辺が与えられたため面積は出力できません")
}
/* 出力
6.0
*/

// コレクションと同じメソッドが利用できる
// `Some[T]` は長さ1のコレクションのように振る舞う
polygon3.foreach(p => println(p.area))
/* 出力
6.0
*/
polygon3
  .map(p => p.area * 2)
  .foreach(area => println(area))
/* 出力
12.0
*/

val invalidEdges5 = List(3, 3, 3, 3, 3)
val invalidPolygon5 = Polygon.fromEdges(invalidEdges5)
// >> None
// 面積を出力する
invalidPolygon5 match {
  case Some(p) => println(p.area)
  case None =>
    println("不正な辺が与えられたため面積は出力できません")
}
/* 出力
"不正な辺が与えられたため面積は出力できません"
*/

// コレクションと同じメソッドが利用できる
// `None` は長さ0のコレクションのように振る舞う
invalidPolygon5.foreach(p => println(p.area))
// (長さ0なので実行されず, 何も出力されない)
invalidPolygon5
  .map(p => p.area * 2)
  .foreach(area => println(area))
// (長さ0なので実行されず, 何も出力されない)



// Mapのキーから値を取得, なければ `None`
val map1 = Map((1, "A"), (2, "B"))
val value1 = map1.get(1) // >> Some("A")
val value2 = map1.get(100) // >> None

// これでもキーから値を取得できるが例外の可能性があるのでダメ！
// val value3 = map1(1) // >> "A"
// val value4 = map1(100) // >> 例外発生

// 条件に一致する最初の値を取得, なければ `None`
val list1 = List(1, 2, 3, 4)
val found1 = list1.find(i => i % 2 == 0) // >> Some(2)
val found2 = list1.find(i => i % 5 == 0) // >> None



abstract class Polygon(edges: List[Int]) {
  val n = edges.length // n個の辺から成るn角形
  val area: Double // 面積
  def printFigure(): Unit // 外形を標準出力
}

object Polygon {
  // 与えられる `edges` の辺に応じて
  // 適切な多角形を生成する静的なファクトリメソッド
  def fromEdges(edges: List[Int]): Option[Polygon] =
    edges.length match {
      case 3 => Triangle.fromEdges(edges)
      case 4 => Square.fromEdges(edges)
      case x => None
    }
}

// プライベートコンストラクタに変更することで,
// インスタンス作成を `Triangle.fromEdges` 経由に制限
class Triangle private (edges: List[Int]) extends Polygon(edges) {
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

object Triangle {
  // 辺の数だけでなく図形が成立するかどうかもチェックするファクトリメソッド
  def fromEdges(edges: List[Int]): Option[Triangle] =
    if(edges.length == 3
        && edges(0) + edges(1) > edges(2)
        && edges(1) + edges(2) > edges(0)
        && edges(2) + edges(0) > edges(1))
      Some(new Triangle(edges))
    else None
}

// プライベートコンストラクタに変更することで,
// インスタンス作成を `Square.fromEdges` 経由に制限
class Square private (edges: List[Int]) extends Polygon(edges) {
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)
  val d = edges(3)

  val area = {
    // Brahmagupta's formula
    // 対角の和が180度と勝手に仮定 (この仮定は簡単のために維持します)
    val s = (a + b + c + d) / 2.0
    math.sqrt((s - a) * (s - b) * (s - c) * (s - d))
  }
  def printFigure(): Unit = println("□")
}

object Square {
  // 辺の数だけでなく図形が成立するかどうかもチェックするファクトリメソッド
  def fromEdges(edges: List[Int]): Option[Square] =
    if(edges.length == 4
        && edges(2) - edges(1) - edges(0) < edges(3)
        && edges(3) < edges(2) + edges(1) + edges(0))
      Some(new Square(edges))
    else None
}

val edges3 = List(3, 4, 5)
val polygon3 = Polygon.fromEdges(edges3)
// >> :Some[Triangle]
// 面積を出力する
polygon3 match {
  case Some(polygon) => println(polygon.area)
  case None =>
    println("不正な数の辺か図形が成立しない辺が与えられたため面積は出力できません")
}
/* 出力
6.0
*/

val invalidEdges3 = List(3, 4, 100)
val invalidPolygon3 = Polygon.fromEdges(invalidEdges3)
// >> None
// 面積を出力する
invalidPolygon3 match {
  case Some(polygon) => println(polygon.area)
  case None =>
    println("不正な数の辺か図形が成立しない辺が与えられたため面積は出力できません")
}
/* 出力
"不正な数の辺か図形が成立しない辺が与えられたため面積は出力できません"
*/
// (実際には辺の組合せが問題)

val invalidEdges5 = List(3, 3, 3, 3, 3)
val invalidPolygon5 = Polygon.fromEdges(invalidEdges5) // `None`
// 面積を出力する
invalidPolygon5 match {
  case Some(polygon) => println(polygon.area)
  case None => println("不正な数の辺か図形が成立しない辺が与えられたため面積は出力できません")
}
/* 出力
"不正な数の辺か図形が成立しない辺が与えられたため面積は出力できません"
*/
// (実際には辺の数が問題)



abstract class Polygon(edges: List[Int]) {
  val n = edges.length // n個の辺から成るn角形
  val area: Double // 面積
  def printFigure(): Unit // 外形を標準出力
}

object Polygon {
  // 与えられる `edges` の辺に応じて
  // 適切な多角形を生成する静的なファクトリメソッド
  def fromEdges(edges: List[Int]): Either[String, Polygon] =
    edges.length match {
      case 3 => Triangle.fromEdges(edges)
      case 4 => Square.fromEdges(edges)
      case x => Left(s"${x}個の辺から成る多角形は実装されていません")
    }
}

class Triangle private (edges: List[Int]) extends Polygon(edges) {
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

object Triangle {
  // 辺の数だけでなく図形が成立するかどうかもチェックするファクトリメソッド
  def fromEdges(edges: List[Int]): Either[String, Triangle] =
    if(edges.length != 3)
      Left(s"${edges.length}個の辺から三角形は作成できません")
    else if(!(edges(0) + edges(1) > edges(2)
        && edges(1) + edges(2) > edges(0)
        && edges(2) + edges(0) > edges(1)))
      Left("三角形が成立しない辺の組合せです")
    else Right(new Triangle(edges))
}

// プライベートコンストラクタに変更することで,
// インスタンス作成を `Square.fromEdges` 経由に制限
class Square private (edges: List[Int]) extends Polygon(edges) {
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)
  val d = edges(3)

  val area = {
    // Brahmagupta's formula
    // 対角の和が180度と勝手に仮定 (この仮定は簡単のために維持します)
    val s = (a + b + c + d) / 2.0
    math.sqrt((s - a) * (s - b) * (s - c) * (s - d))
  }
  def printFigure(): Unit = println("□")
}

object Square {
  // 辺の数だけでなく図形が成立するかどうかもチェックするファクトリメソッド
  def fromEdges(edges: List[Int]): Either[String, Square] =
    if(edges.length != 4)
      Left(s"${edges.length}個の辺から四角形は作成できません")
    else if(!(edges(2) - edges(1) - edges(0) < edges(3)
        && edges(3) < edges(2) + edges(1) + edges(0)))
      Left("四角形が成立しない辺の組合せです")
    else Right(new Square(edges))
}

val edges3 = List(3, 4, 5)
val polygon3 = Polygon.fromEdges(edges3)
// >> :Right[String, Triangle]
// 面積を出力する
polygon3 match {
  case Right(p) => println(p.area)
  case Left(err) => println(err)
}
/* 出力
6.0
*/

// コレクションと同じメソッドが利用できる
// `Right[L, R]` は長さ1のコレクションのように振る舞う
polygon3.foreach(p => println(p.area))
/* 出力
6.0
*/
polygon3
  .map(p => p.area * 2)
  .foreach(area => println(area))
/* 出力
12.0
*/

val invalidEdges3 = List(3, 4, 100)
val invalidPolygon3 = Polygon.fromEdges(invalidEdges3)
// >> :Left[String, Triangle]
// 面積を出力する
invalidPolygon3 match {
  case Right(p) => println(p.area)
  case Left(err) => println(err)
}
/* 出力
"三角形が成立しない辺の組合せです"
*/

// コレクションと同じメソッドが利用できる
// `Left[L, R]` は長さ0のコレクションのように振る舞う
invalidPolygon3.foreach(p => println(p.area))
// (長さ0なので実行されず, 何も出力されない)

val invalidEdges5 = List(3, 3, 3, 3, 3)
val invalidPolygon5 = Polygon.fromEdges(invalidEdges5)
// >> :Right[String, Polygon]
// 面積を出力する
invalidPolygon5 match {
  case Right(p) => println(p.area)
  case Left(err) => println(err)
}
/* 出力
"5個の辺から成る多角形は実装されていません"
*/

// コレクションと同じメソッドが利用できる
// `Left[L, R]` は長さ0のコレクションのように振る舞う
invalidPolygon5.foreach(p => println(p.area))
// (長さ0なので実行されず, 何も出力されない)



def divid(x: Int, y: Int): Int = x / y
def notImplementedSth(x: Int): Int = ???

// 式なので値を返せるが, `finally` は返り値と無関係
val msg1 = try {
    "Hello" + " " + "World"
  } catch {
    case e: java.lang.ArithmeticException =>
      s"Invalid arithmetics (${e.getMessage})"
    case e: Throwable =>
      "Unknown error"
  } finally { println("completed") }
// >> "Hello World"
/* 出力
"completed"
*/

try {
  println(divid(10, 0))
} catch {
  case e: java.lang.ArithmeticException =>
    println(s"Invalid arithmetics (${e.getMessage})")
  case e: Throwable =>
    println("Unknown error")
}
/* 出力
"Invalid arithmetics (/ by zero)"
*/
// 例外オブジェクトも利用できる
// `catch`・`finally` はどちらかだけでも良い

try {
  println(notImplementedSth(10))
} catch {
  case e: java.lang.ArithmeticException =>
    println(s"Invalid arithmetics (${e.getMessage})")
  case e: Throwable =>
    println("Unknown error")
} finally { println("completed") }
/* 出力
"Unknown error"
"completed"
*/
// `???` の実態は `Throwable` である `NotImplementedError`