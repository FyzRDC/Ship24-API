package center.fyz.ship24.api.entities;

/**
 * This class represents timestamps associated with a shipment.
 * Timestamps include various stages of shipment such as info received datetime, in transit datetime, 
 * out for delivery datetime, failed attempt datetime, available for pickup datetime, exception datetime, and delivered datetime.
 *
 * @author @FyzRDC
 */
public class Timestamps {

    private String infoReceivedDatetime;
    private String inTransitDatetime;
    private String outForDeliveryDatetime;
    private String failedAttemptDatetime;
    private String availableForPickupDatetime;
    private String exceptionDatetime;
    private String deliveredDatetime;

    /**
     * Constructor to initialize the timestamps with given datetime values.
     * 
     * @param infoReceivedDatetime         Info received datetime of shipment.
     * @param inTransitDatetime            In transit datetime of shipment.
     * @param outForDeliveryDatetime       Out for delivery datetime of shipment.
     * @param failedAttemptDatetime        Failed attempt datetime of shipment.
     * @param availableForPickupDatetime   Available for pickup datetime of shipment.
     * @param exceptionDatetime            Exception datetime of shipment.
     * @param deliveredDatetime            Delivered datetime of shipment.
     */
    public Timestamps(String infoReceivedDatetime, String inTransitDatetime, String outForDeliveryDatetime,
            String failedAttemptDatetime, String availableForPickupDatetime, String exceptionDatetime,
            String deliveredDatetime) {
        this.infoReceivedDatetime = infoReceivedDatetime;
        this.inTransitDatetime = inTransitDatetime;
        this.outForDeliveryDatetime = outForDeliveryDatetime;
        this.failedAttemptDatetime = failedAttemptDatetime;
        this.availableForPickupDatetime = availableForPickupDatetime;
        this.exceptionDatetime = exceptionDatetime;
        this.deliveredDatetime = deliveredDatetime;
    }

    /**
     * Get the available for pickup datetime of shipment.
     * 
     * @return Available for pickup datetime.
     */
    public String getAvailableForPickupDatetime() {
        return availableForPickupDatetime;
    }

    /**
     * Get the delivered datetime of shipment.
     * 
     * @return Delivered datetime.
     */
    public String getDeliveredDatetime() {
        return deliveredDatetime;
    }

    /**
     * Get the exception datetime of shipment.
     * 
     * @return Exception datetime.
     */
    public String getExceptionDatetime() {
        return exceptionDatetime;
    }

    /**
     * Get the failed attempt datetime of shipment.
     * 
     * @return Failed attempt datetime.
     */
    public String getFailedAttemptDatetime() {
        return failedAttemptDatetime;
    }

    /**
     * Get the info received datetime of shipment.
     * 
     * @return Info received datetime.
     */
    public String getInfoReceivedDatetime() {
        return infoReceivedDatetime;
    }

    /**
     * Get the in transit datetime of shipment.
     * 
     * @return In transit datetime.
     */
    public String getInTransitDatetime() {
        return inTransitDatetime;
    }

    /**
     * Get the out for delivery datetime of shipment.
     * 
     * @return Out for delivery datetime.
     */
    public String getOutForDeliveryDatetime() {
        return outForDeliveryDatetime;
    }

}
