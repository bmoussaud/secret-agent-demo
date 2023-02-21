package org.moussaud.sb.secretagent.domain;

public class EnvironmentResponse {

    private final String key;

    private final String value;

    public EnvironmentResponse(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    

    
}
