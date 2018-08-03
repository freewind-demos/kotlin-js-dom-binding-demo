Kotlinx DOM Binding Demo
========================

手动实现页面中两个`textInput`之间双向绑定。好像比想象中简单很多。

其中的DOM部分是由[kotlinx](https://github.com/Kotlin/kotlinx.html)生成。

```
npm install
./gradlew compileKotlin2Js
open index.html
```

在页面上，当你在某一个textInput中输入，则另一个也会跟着变。
