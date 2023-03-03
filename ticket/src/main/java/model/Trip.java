package model;

import java.util.Objects;

public class Trip {




	private String stationStart;
	private String stationEnd;
	private Integer startedJourneyAt;
	private int costInCents;
	private int zoneFrom;
	private int zoneTo;

	public Trip() {}
	
	public Trip(String stationStart, String stationEnd, int startedJourneyAt,  int costInCents,int zoneFrom, int zoneTo) {
		this.stationStart = stationStart;
		this.stationEnd = stationEnd;
		this.startedJourneyAt = startedJourneyAt;
		this.costInCents = costInCents;
		this.zoneFrom = zoneFrom;
		this.zoneTo = zoneTo;
	}
	
	 

	public String getStationStart() {
		return stationStart;
	}



	public void setStationStart(String stationStart) {
		this.stationStart = stationStart;
	}



	public String getStationEnd() {
		return stationEnd;
	}



	public void setStationEnd(String stationEnd) {
		this.stationEnd = stationEnd;
	}



	public Integer getStartedJourneyAt() {
		return startedJourneyAt;
	}



	public void setStartedJourneyAt(Integer startedJourneyAt) {
		this.startedJourneyAt = startedJourneyAt;
	}



	public int getZoneFrom() {
		return zoneFrom;
	}



	public void setZoneFrom(int zoneFrom) {
		this.zoneFrom = zoneFrom;
	}



	public int getZoneTo() {
		return zoneTo;
	}



	public void setZoneTo(int zoneTo) {
		this.zoneTo = zoneTo;
	}



	public int getCostInCents() {
		return costInCents;
	}



	public void setCostInCents(int costInCents) {
		this.costInCents = costInCents;
	}



	@Override
	public String toString() {
		return "{stationStart:" + stationStart + ", stationEnd:" + stationEnd + ", startedJourneyAt:"
				+ startedJourneyAt + ", costInCents=" + costInCents + ", zoneFrom:" + zoneFrom + ", zoneTo:" + zoneTo
				+ "}";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }
        if (!(obj instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) obj;
        return Objects.equals(stationStart, other.stationStart)
                && Objects.equals(stationEnd, other.stationEnd)
                && Objects.equals(startedJourneyAt, other.startedJourneyAt)
                && costInCents == other.costInCents
                && zoneFrom == other.zoneFrom
                && zoneTo == other.zoneTo;
    }
	
	
	
}

 