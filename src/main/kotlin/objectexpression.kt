val helloWorld = object {
    val hello = "Hello"
    val world = "World"
    // object expressions extend Any, so `override` is required on `toString()`
    override fun toString() = "$hello $world"
}

open class Oba(x: Int) {
    public open val y: Int = x
}

interface BB { /*...*/ }

val ab: Oba = object : Oba(1), BB {
    override val y = 15
}

fun main()
{
    println(helloWorld)
    println(ab.y)
}