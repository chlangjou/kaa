package org.kaaproject.kaa.examples.powerplant.resources;

import java.util.Comparator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataPoint {

    @XmlElement(name="panel")
    public int panelId;
    
    @XmlElement
    public double voltage;
    
    @XmlElement
    public long time;

    public DataPoint(int panelId, double voltage, long time) {
        super();
        this.panelId = panelId;
        this.voltage = voltage;
        this.time = time;
    }
    
    static final Comparator<DataPoint> TS_COMPARATOR = new Comparator<DataPoint>() {
        @Override
        public int compare(DataPoint o1, DataPoint o2) {
            if (o1.time > o2.time) {
                return 1;
            } else {
                return o1.time == o2.time ? 0 : -1;
            }
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + panelId;
        result = prime * result + (int) (time ^ (time >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DataPoint other = (DataPoint) obj;
        if (panelId != other.panelId) {
            return false;
        }
        if (time != other.time) {
            return false;
        }
        return true;
    }
}
