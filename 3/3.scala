val message = "Hello World"
// message = "Changed World" // NG



val message: String = "Hello World"



var mutableMessage = "Hello World"
mutableMessage = "Changed World" // OK



{
  println("Hello World")
}



val result = {
  val x = 1 + 2
  x * 2
} // >> 6



def add(x: Int, y: Int): Int = x + y



// 値をそのまま返すだけのメソッド
def identity(x: Int): Int = x