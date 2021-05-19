open class Oa(x: Int)
{
    public open val y: Int = x
}

interface B
{

}

fun foo()
{
    val adhoc = object
    {
        var x = 0
        var y = 0
    }

    println(adhoc)
    println(adhoc.x + adhoc.y)
}

class MyClass
{
    companion object : Factory<MyClass>
    {
        override fun create(): MyClass = MyClass()
    }
}

interface Factory<T>
{
    fun create(): T
}

fun main()
{
    val ab: Oa = object : Oa(1), B
    {
        override val y = 15
    }

    println(ab)

    println(MyClass.create())
}