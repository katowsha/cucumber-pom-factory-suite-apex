package Suite.Steps;


import Suite.Models.Actions.BaseActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseSteps {
    private static Logger log = LogManager.getLogger(BaseSteps.class.getName());

    BaseActions page;

    public BaseSteps(){
        page = new BaseActions();
    }


}
