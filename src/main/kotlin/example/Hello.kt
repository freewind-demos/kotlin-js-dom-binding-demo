package example

import kotlinx.html.INPUT
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.id
import kotlinx.html.js.onKeyUpFunction
import kotlinx.html.textInput
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.Node
import kotlin.browser.document

private val data = Var("abc")

fun main(args: Array<String>) {
    document.body?.append(createMyDiv())
}

fun createMyDiv(): Node {
    return document.create.div {
        div {
            textInput { this.bindValue(data) }
        }
        div {
            textInput { this.bindValue(data) }
        }
    }
}

private fun INPUT.bindValue(data: Var<String>) {
    val nodeId = nextId()
    this.id = nodeId
    fun self() = document.getElementById(nodeId) as HTMLInputElement
    data.addListener { newValue ->
        document.getElementById(nodeId)?.run {
            self().value = newValue
        } ?: run {
            this.value = newValue
        }
    }
    this.onKeyUpFunction = { _ -> data.set(self().value) }
}

private var id = 0
private fun nextId(): String {
    return "var-$id".also {
        id += 1
    }
}