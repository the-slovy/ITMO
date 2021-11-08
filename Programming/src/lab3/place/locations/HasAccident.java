package lab3.place.locations;

public interface HasAccident {
    default String getDescription() {
        return "Это тихое и прекрасное место";
    }
}
