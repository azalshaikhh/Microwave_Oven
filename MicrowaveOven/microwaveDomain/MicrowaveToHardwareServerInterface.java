package MicrowaveOven.microwaveDomain;

public interface MicrowaveToHardwareServerInterface {

    /**
     * Sets the cooking period for the microwave.
     * 
     * @param cookingTime The duration for cooking in milliseconds.
     */
    void setCookingPeriod(int cookingTime);

    /**
     * Starts the cooking process.
     */
    void startCooking();

    /**
     * Cancels the ongoing cooking process.
     */
    void cancelCooking();

    /**
     * Marks the cooking process as complete.
     */
    void cookingComplete();

    /**
     * Opens the microwave door.
     */
    void openDoor();

    /**
     * Closes the microwave door.
     */
    void closeDoor();

    /**
     * Checks if the microwave door is secure.
     * 
     * @return true if the door is secure, false otherwise.
     */
    boolean isDoorSecure();

    /**
     * Turns the microwave light on.
     */
    void turnLightOn();

    /**
     * Turns the microwave light off.
     */
    void turnLightOff();

    /**
     * Retrieves the current status of the microwave.
     * 
     * @return A string describing the current status of the microwave.
     */
    String getMicrowaveStatus();

    /**
     * Updates the status of the microwave based on hardware feedback.
     * 
     * @param status The status to be updated.
     */
    void updateStatus(String status);

    /**
     * Gets the remaining cooking time.
     * 
     * @return The remaining cooking time in milliseconds.
     */
    int getRemainingCookingTime();
}
