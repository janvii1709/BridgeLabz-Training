public class SmartHomeLighting {
    public static void main(String[] args) {
        // Motion detected -> bright white light
        LightAction motionTrigger = () ->
                System.out.println("Motion detected -> Bright white lights ON");
        // Night time -> dim warm light
        LightAction nightTrigger = () ->
                System.out.println("Night time -> Dim warm lights ON");
        // Voice command -> party mode
        LightAction voiceTrigger = () ->
                System.out.println("Voice command -> Party lights activated ");
        // Execute actions
        activateLight(motionTrigger);
        activateLight(nightTrigger);
        activateLight(voiceTrigger);
    }
    static void activateLight(LightAction action) {
        action.activate();
    }
}
