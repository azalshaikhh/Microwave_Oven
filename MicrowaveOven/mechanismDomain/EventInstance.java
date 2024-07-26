package MicrowaveOven.mechanismDomain;

public class EventInstance {
    private int event;
    private Object parameters;

    public EventInstance(int event, Object parameters) {
        this.event = event;
        this.parameters = parameters;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public Object getParameters() {
        return parameters;
    }

    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "EventInstance{" +
                "event=" + event +
                ", parameters=" + parameters +
                '}';
    }
}
