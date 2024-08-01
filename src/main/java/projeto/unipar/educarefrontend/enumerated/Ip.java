package projeto.unipar.educarefrontend.enumerated;

public enum Ip {
    IP("localhost");
    //CASA 192.168.1.108
    //TRABALHO 192.168.0.188
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
