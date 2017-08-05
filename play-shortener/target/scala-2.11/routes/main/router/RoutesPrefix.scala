
// @GENERATOR:play-routes-compiler
// @SOURCE:U:/play/shortener/play-shortener/conf/routes
// @DATE:Sat Aug 05 13:26:03 PDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
