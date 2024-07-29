package projeto.unipar.educarefrontend.enumerated;

public enum Ip {
    IP("192.168.0.188");
    
    private final String ipAddress;

    Ip(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return ipAddress;
    }
    
}
