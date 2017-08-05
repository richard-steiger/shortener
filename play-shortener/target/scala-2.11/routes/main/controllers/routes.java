
// @GENERATOR:play-routes-compiler
// @SOURCE:U:/play/shortener/play-shortener/conf/routes
// @DATE:Sat Aug 05 13:26:03 PDT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAliasController AliasController = new controllers.ReverseAliasController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAliasController AliasController = new controllers.javascript.ReverseAliasController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
