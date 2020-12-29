typealias NodeSet = Set<Int>

class AA
{
    class B
    {

    }
}

typealias AAInner = AA.B

fun main()
{
    val a = AA()
    val b = AA.B()
    println("welcome")
    println(a)
    println(b)
    println(AAInner())
}