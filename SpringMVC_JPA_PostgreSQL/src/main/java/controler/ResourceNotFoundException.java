package controler;

public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;

    public ResourceNotFoundException(String resourceName) {
        super(String.format("Resource %s not found with %s: '%s'", resourceName));
        this.resourceName = resourceName;

    }

    public String getResourceName() {
        return resourceName;
    }
}
