package ch11

@DslMarker
annotation class DialogDsl

@DialogDsl
class Dialog {
    var title: String = ""
    var message: String = ""
    private var okButton: Button? = null
    private var cancelButton: Button? = null

    @DialogDsl
    fun okButton(init: Button.() -> Unit) {
        okButton = Button().apply(init)
    }

    @DialogDsl
    fun cancelButton(init: Button.() -> Unit) {
        cancelButton = Button().apply(init)
    }

    fun show() {}

    @DialogDsl
    class Button {
        var message: String = ""
        var handler: () -> Unit = {}
    }
}

@DialogDsl
fun showDialog(init: Dialog.() -> Unit) {
    Dialog().apply(init).show()
}

fun main() {
    showDialog {
        title = "some dialog"
        message = "just accept it, ok?"
        okButton {
            message = "OK"
            handler = {}
        }
    }
}
