package controllers

import models.{DB, Person}
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Hellow, World!."))
  }
  
  val personForm: Form[Person] = Form {
    mapping(
        "name" -> text
        )(Person.apply)(Person.unapply)
  }
  
  def addPerson = Action { implicit request =>
    val person = personForm.bindFromRequest.get
    DB.save(person)
    Redirect(routes.HomeController.index())
  }

  def getPersoins = Action {
    val persons = DB.query[Person].fetch
    OK(Json.toJson(persons))
  }
}
