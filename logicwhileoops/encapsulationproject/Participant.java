package logicwhileoops.encapsulationproject;

public class Participant {
    private int participantId;
    private String  name;
    private double baseRegistrationFee;
    private int numberOfEvents;
    private double eventChargesPerHead;
    private double totalfee=0;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseRegistrationFee() {
        return baseRegistrationFee;
    }

    public void setBaseRegistrationFee(double baseRegistrationFee) {
        this.baseRegistrationFee = baseRegistrationFee;
    }

    public int getNumberOfEvents() {
        return numberOfEvents;
    }

    public void setNumberOfEvents(int numberOfEvents) {
        this.numberOfEvents = numberOfEvents;
    }

    public double getEventChargesPerHead() {
        return eventChargesPerHead;
    }

    public void setEventChargesPerHead(double eventChargesPerHead) {
        this.eventChargesPerHead = eventChargesPerHead;
    }

    public double calculateTotalFee() {
        totalfee =baseRegistrationFee+(numberOfEvents * eventChargesPerHead);
        return totalfee;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "participantId=" + participantId +
                ", name='" + name + '\'' +
                ", baseRegistrationFee=" + baseRegistrationFee +
                ", numberOfEvents=" + numberOfEvents +
                ", eventChargesPerHead=" + eventChargesPerHead +
                ", totalfee=" + totalfee +
                '}';
    }

    public void setTotalfee(double totalfee) {
        this.totalfee = totalfee;
    }
}
