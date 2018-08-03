package example

typealias Listener<T> = (T) -> Unit

class Var<T>(initValue: T) {
    private var _value = initValue
    private val listeners = mutableListOf<Listener<T>>()

    fun addListener(listener: Listener<T>) {
        this.listeners.add(listener)
        listener.invoke(this._value)
    }

    fun get() = this._value

    fun set(value: T) {
        val changed = this._value != value
        this._value = value
        if (changed) {
            listeners.forEach { it.invoke(value) }
        }
    }

}