// 名前空間の宣言です
// 多くの場合ディレクトリ階層と合わせます
package example

// import scala.annotation.tailrec
// import scala.collection.mutable._
// `import` で別名前空間に属するパッケージ・クラス・メソッド
// を利用できるようになります
// `_` を利用することで直下の全てを対象にとれますが,
// 意図しないインポートの回避やコンパイル時間短縮のため
// 出来る限り避けるべきです

object Hello {
    // これは一行コメントです
    /* これは複数行コメントです
    JavaやCと同じですね */
  def main(args: Array[String]): Unit = {
    val message = "Hello World"
    // 末尾改行付き標準出力を行う関数です
    // 文字列以外も扱うことができます
    // Javaと違い `System.out.` といったプレフィックスは不要です
    println(message)
    /* 出力
    Hello World
    */
  }
}
