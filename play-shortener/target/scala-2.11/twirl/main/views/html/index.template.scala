
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""

"""),_display_(/*3.2*/main("May I Shorten Your URL?")/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""
    """),format.raw/*4.5*/("""<script type='text/javascript' src='"""),_display_(/*4.42*/routes/*4.48*/.Assets.at("javascripts/index.js")),format.raw/*4.82*/("""'></script>

    <form method="POST" action=""""),_display_(/*6.34*/routes/*6.40*/.AliasController.addAlias()),format.raw/*6.67*/("""">
        <label for="name"><input type="text" name="name"/>
        <input type="submit" style="display: none" />
    </form>

    <div>shortened to: <b>"""),_display_(/*11.28*/id),format.raw/*11.30*/("""</b></div>
""")))}),format.raw/*12.2*/("""
"""))
      }
    }
  }

  def render(id:String): play.twirl.api.HtmlFormat.Appendable = apply(id)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (id) => apply(id)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sat Aug 05 13:26:03 PDT 2017
                  SOURCE: U:/play/shortener/play-shortener/app/views/index.scala.html
                  HASH: 305e8d0b95a80ed912db03b7c7b00ddd80281cd1
                  MATRIX: 527->1|634->13|662->16|701->47|740->49|771->54|834->91|848->97|902->131|974->177|988->183|1035->210|1218->366|1241->368|1283->380
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|28->4|28->4|28->4|30->6|30->6|30->6|35->11|35->11|36->12
                  -- GENERATED --
              */
          