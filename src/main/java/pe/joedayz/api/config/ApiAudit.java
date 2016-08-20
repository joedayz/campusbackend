package pe.joedayz.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.joedayz.api.util.TimeChronometer;

/**
 * Created by josediaz on 17/08/2016.
 */
public class ApiAudit {
    public static final Logger logRtgRoutingRestriction = buildLogger("RoutingRoutingRestriction");
    public static final Logger logRtgDrayMilesRestriction = buildLogger("RoutingDrayMilesRestriction");
    public static final Logger logRtgAutoAccesorial = buildLogger("RoutingAutomatedAccesorial");
    public static final Logger logRtgCustomerMarginFee = buildLogger("RoutingCustomerMarginFee");
    public static final Logger logRtgAssembler = buildLogger("RoutingAssembly");
    public static final Logger logRtgCalc = buildLogger("RoutingCalc");
    public static final Logger logRtgDataLoader = buildLogger("RoutingDataLoader");
    public static final Logger logRtgPersister = buildLogger("RoutingPersister");
    public static final Logger logRtgSummary = buildLogger("RoutingSummary");

    private static Logger buildLogger(String routingRoutingRestriction) {
        return LoggerFactory.getLogger(ApiAudit.class.getName() + "." + routingRoutingRestriction);
    }


    public static TimeChronometer buildRoutingChronometer(String name) {
        return new TimeChronometer("Routing-" + name).start();
    }
}
