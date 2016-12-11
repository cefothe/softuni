package app.domain.entities.camera;

/**
 * Created by cefothe on 11.12.16.
 */
public enum CameraTypes {
    DSLR("DSLR_CAMERA","DSLR"), MIRRORLESS("MIRROLESS_CAMERA", "Mirrorless");

    private String databaseType;
    private String jsonType;

    private CameraTypes(String databaseType, String jsonType) {
        this.databaseType = databaseType;
        this.jsonType = jsonType;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public String getJsonType() {
        return jsonType;
    }

}
