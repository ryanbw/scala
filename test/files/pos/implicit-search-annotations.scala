object SuffixParser {
  def apply(s: String): Int =
    s.last match {
      case 'k'|'K' => s.substring(0, s.length - 1).toInt << 10
      case 'm'|'M' => s.substring(0, s.length - 1).toInt << 20
      case _ => s.toInt
    }
}

class suffixStyle extends annotation.Annotation
object suffixStyle {
  implicit def stringToInt(s: String): Int = SuffixParser(s)
}

object Test {
  def foo(i: Int @suffixStyle) {}

  foo("50k")
}