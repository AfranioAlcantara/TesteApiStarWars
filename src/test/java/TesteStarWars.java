import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class TesteStarWars {

    @Test

    public void teste1(){

    given() //dado
                .log().all() //Mostra os dados antes da requisição
                .contentType(ContentType.JSON) //Especifica o tipo de conteudo
            .when() //quando
                .get("https://swapi.dev/api/people/1/") //metodo + URL base + end point
            .then() //então
                .log().all() //Mostra os dados depois da requisição
                .statusCode(200) //valida status code
                .body("name", Matchers.is("Luke Skywalker")) //valida response
                .body("height", Matchers.is("172"))
                .body("mass", Matchers.is("77"))
                .body("hair_color", Matchers.is("blond"))
                .body("skin_color", Matchers.is("fair"))
                ;
    }
}
