inline class Name(val s: String) : Printable
{
    val length: Int
        get() = s.length

    fun greet()
    {
        println("hello, $s")
    }

    override fun prettyPrint(): String
    {
        return "welcome $s"
    }
}

interface Printable
{
    fun prettyPrint(): String
}

class AAA
{

}

inline class BBB(val s: String)
{

}

interface I

inline class Foo(val i: Int) : I

fun asInline(f: Foo)
{
}

fun <T> asGeneric(x: T)
{
}

fun asInterface(i: I)
{
}

fun asNullable(i: Foo?)
{
}

fun <T> id(x: T): T = x

typealias NameTypeAlias = String

inline class NameInlineClass(val s: String)

fun acceptString(s: String)
{
}

fun acceptNameTypeAlias(n: NameTypeAlias)
{
}

fun acceptNameInlineClass(p: NameInlineClass)
{
}

fun main()
{

    val name = Name("ricolwang")
    name.greet()
    println(name.length)
    println(name.prettyPrint())

    val f = Foo(42)

    asInline(f)    // unboxed: used as Foo itself
    asGeneric(f)   // boxed: used as generic type T
    asInterface(f) // boxed: used as type I
    asNullable(f)  // boxed: used as Foo?, which is different from Foo

    // below, 'f' first is boxed (while being passed to 'id') and then unboxed (when returned from 'id')
    // In the end, 'c' contains unboxed representation (just '42'), as 'f'
    val c = id(f)

    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""

    acceptString(nameAlias) // OK: pass alias instead of underlying type
//    acceptString(nameInlineClass) // Not OK: can't pass inline class instead of underlying type

    // And vice versa:
    acceptNameTypeAlias(string) // OK: pass underlying type instead of alias
//    acceptNameInlineClass(string) // Not OK: can't pass underlying type instead of inline class
}