import java.util.ArrayList;
import java.util.List;
public class VesselUtil {
    private List<Vessel> vesselList = new ArrayList<>();
    //using getter and setter method now
    public List<Vessel> getVesselList() {
        return vesselList;
    }
    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }
    //add vessels
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }
    // get vessel by id (veseelId is case sensitve) 
    public Vessel getVesselById(String vesselId){
        for(Vessel v : vesselList){
            if(v.getVesselId().equals(vesselId)){
                return v;
            }
        }
        return null;
    }
    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> result = new ArrayList<>();
        if(vesselList.isEmpty()){
            return result;
        }
        double maxSpeed = vesselList.get(0).getAverageSpeed();

        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() > maxSpeed) {
                maxSpeed = v.getAverageSpeed();
            }
        }

        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() == maxSpeed) {
                result.add(v);
            }
        }

        return result;
    }
}
