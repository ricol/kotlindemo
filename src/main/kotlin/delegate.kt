import kotlin.properties.Delegates
import kotlin.reflect.KProperty

interface Base
{
    val msg: String
    fun print()
    fun newPrint()
}

class BaseImpl(x: Int, override val msg: String) : Base
{
    override fun print()
    {
        println("hi world!")
    }

    override fun newPrint()
    {
        println("hello world")
    }
}

class Derived(b: Base) : Base by b
{
    override val msg: String
        get() = "msg in Derived"

    override fun newPrint()
    {
        println("welcome to the world!")
    }
}

val lazyValue: String by lazy { println("computed"); "hello" }

class User
{
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("$prop: $old -> $new")
    }
}

class Example
{
    var p: String by Delegate()
}

class Delegate
{
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String
    {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String)
    {
        println("$value has been assigned to '${property.name}' in $thisRef")
    }
}

class UserA
{
    var name: String by Delegates.observable("no name") { prop, old, new ->
        println("$prop: $old -> $new")
    }
}

class UserB(map: MutableMap<String, Any?>)
{
    val name: String by map
    val age: Int by map
    var address: String by map
}

fun main()
{
    val b = BaseImpl(10, "ricol")
    Derived(b).print()
    Derived(b).newPrint()
    println(b.msg)
    println(Derived(b).msg)
    println(lazyValue)

    val user = User()
    user.name = "first"
    user.name = "second"
    println(user.name)

    val e = Example()
    println(e.p)
    e.p = "wangxinghe"
    println(e.p)
    println(Example().p)

    val u = UserA()
    u.name = "ricol"
    u.name = "wang"
    println(u.name)

    val c = UserB(mapOf("name" to "ricolwang", "age" to 25, "address" to "21 monaplace, south yarra").toMutableMap())
    println(c.name)
    println(c.age)
    println(c.address)
    c.address = "China"
    println(c.address)
}
