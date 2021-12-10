package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable ChoucairIncio() {
        return Task.where("{0} abre la seccion empleos de Choucair",
                Open.browserOn().the(ChoucairJobsPage.class));
    }
}
