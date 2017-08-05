
// @GENERATOR:play-routes-compiler
// @SOURCE:U:/play/shortener/play-shortener/conf/routes
// @DATE:Sat Aug 05 13:26:03 PDT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  AliasController_1: controllers.AliasController,
  // @LINE:10
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    AliasController_1: controllers.AliasController,
    // @LINE:10
    Assets_0: controllers.Assets
  ) = this(errorHandler, AliasController_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AliasController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.AliasController.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """alias""", """controllers.AliasController.addAlias()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """address<.+>""", """controllers.AliasController.followAlias(address:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_AliasController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_AliasController_index0_invoker = createInvoker(
    AliasController_1.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AliasController",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_AliasController_addAlias1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("alias")))
  )
  private[this] lazy val controllers_AliasController_addAlias1_invoker = createInvoker(
    AliasController_1.addAlias(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AliasController",
      "addAlias",
      Nil,
      "POST",
      """""",
      this.prefix + """alias"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_at2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at2_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_AliasController_followAlias3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("address", """.+""",false)))
  )
  private[this] lazy val controllers_AliasController_followAlias3_invoker = createInvoker(
    AliasController_1.followAlias(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AliasController",
      "followAlias",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """""" + "$" + """address<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_AliasController_index0_route(params) =>
      call { 
        controllers_AliasController_index0_invoker.call(AliasController_1.index())
      }
  
    // @LINE:7
    case controllers_AliasController_addAlias1_route(params) =>
      call { 
        controllers_AliasController_addAlias1_invoker.call(AliasController_1.addAlias())
      }
  
    // @LINE:10
    case controllers_Assets_at2_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at2_invoker.call(Assets_0.at(path, file))
      }
  
    // @LINE:12
    case controllers_AliasController_followAlias3_route(params) =>
      call(params.fromPath[String]("address", None)) { (address) =>
        controllers_AliasController_followAlias3_invoker.call(AliasController_1.followAlias(address))
      }
  }
}
