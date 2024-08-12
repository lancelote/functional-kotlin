package ch11

@DslMarker
annotation class HtmlDsl

@HtmlDsl
fun html(init: HtmlBuilder.() -> Unit): HtmlBuilder {
    return HtmlBuilder().apply(init)
}

@HtmlDsl
class HtmlBuilder {
    private var head: HeadBuilder? = null
    private var body: BodyBuilder? = null

    @HtmlDsl
    fun head(init: HeadBuilder.() -> Unit) {
        this.head = HeadBuilder().apply(init)
    }

    @HtmlDsl
    fun body(init: BodyBuilder.() -> Unit) {
        this.body = BodyBuilder().apply(init)
    }

    override fun toString(): String =
        listOfNotNull(head, body)
            .joinToString(
                separator = "",
                prefix = "<html>\n",
                postfix = "</html>",
                transform = { "$it\n" }
            )
}

@HtmlDsl
class HeadBuilder {
    var title: String = ""
    private var styles: List<String> = emptyList()

    @HtmlDsl
    fun style(css: String) {
        styles += css
    }

    override fun toString(): String {
        val css = styles
            .joinToString(separator = "") {
                "<style>$it</style>\n"
            }
        return "<head>\n<title>$title</title>\n$css</head>"
    }
}

@HtmlDsl
class BodyBuilder {
    private var elements: List<BodyElement> = emptyList()

    @HtmlDsl
    fun h1(text: String) {
        this.elements += H1(text)
    }

    @HtmlDsl
    fun h3(text: String) {
        this.elements += H3(text)
    }

    operator fun String.unaryPlus() {
        elements += Text(this)
    }

    override fun toString(): String {
        val body = elements.joinToString(separator = "\n")
        return "<body>\n$body</body>"
    }
}

sealed interface BodyElement

data class H1(val text: String) : BodyElement {
    override fun toString(): String = "<h1>$text</h1>"
}

data class H3(val text: String) : BodyElement {
    override fun toString(): String = "<h3>$text</h3>"
}

data class Text(val text: String) : BodyElement {
    override fun toString(): String = text
}

fun main() {
    val html = html {
        head {
            title = "my website"
            style("some CSS 1")
            style("some CSS 2")
        }
        body {
            h1("title")
            h3("subtitle 1")
            + "some text 1"
            h3("subtitle 2")
            + "some text 2"
        }
    }

    println(html)
}
