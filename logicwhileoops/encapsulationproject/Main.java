package logicwhileoops.encapsulationproject;

public class Main {
    public static void main(String[] args) {
        Participant participant = new Participant();
        participant.setParticipantId(501);
        participant.setName("John Doe");
        participant.setBaseRegistrationFee(200);
        participant.setNumberOfEvents(3);
        participant.setEventChargesPerHead(100);


        System.out.println(participant);
        System.out.println("total fee is "+participant.calculateTotalFee());
    }
}
